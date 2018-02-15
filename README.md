# The TestPay Sandbox
## Description
There is a fictional payment system - the TestPay. We have already integrated the
TestPay with our product using the TestPay API reference, but we need to check that we did it
properly. Unfortunately, the TestPay does not provide any kind of testing environment.

You should carefully read the TestPay API reference and implement a sandbox - self-contained
testing environment that mimics the live TestPay production environment. You need to
implement just two REST methods and send one asynchronous notification.

Then we will connect our product to your sandbox, so we can initiate and watch our application
process the requests we make to the TestPay APIs without touching any live TestPay accounts.

##Implementation notes
* Use one of modern Web frameworks (Spring boot, Dropwizard, etc)
* Use Maven or Gradle as a build tool
#The TestPay API Reference
The TestPay APIs are HTTP-based RESTful APIs that use OAuth 2.0 for authorization. A
request and response bodies are formatted in JSON.
##The TestPay payment flow
1. When the customer is ready to pay for goods or services on your website, they select the
TestPay payment option on your website.
2. You obtain the OAuth access token (if needed)
3. You request the payment by passing customer email and transaction details to the
TestPay
4. TestPay provides you with asynchronous notification, sent to your webhook listener,
confirming the transaction details and status
##Authentication and authorization
The TestPay REST API uses the OAuth 2.0 protocol to authorize calls. When you create a
merchant account, TestPay generates a set of OAuth client ID and secret credentials for you
app. You pass these credentials in the Authorization header in get access token request.

In exchange for these credentials, the TestPay authorization server issues tokens called bearer
tokens that you use for authorization when you make REST API requests.

###Get an access token
POST /oauth2/token

In response, the TestPay authorization server issues an access token. Re-use the access token
until it expires. When it expires, you can get a new token.

Request example:
```
c url -v https://api.testpay.com/oauth2 / token \
-H "Accept: application/json" \
-H "Accept-Language: en_US" \
-u " <client_id> : <secret> " \
-d "grant_type=client_credentials"
```
Where:

* /oauth2/token The get access token endpoint
* client_id You client ID
* secret Your secret
* grant_type The grant type. Set to client_credentials

Sample response:
```
{
"scope" : "https://api.testpay.com/payments/.*" ,
"Access-Token" : " <Access-Token> " ,
"token_type" : "Bearer" ,
"expires_in" : 32398
}
```
Where:

* Access-Token You access token
* expires_in The number of seconds after which token expires. Request another token

when the current one expires.

##Make REST API calls
With a valid access token, you can make REST API calls.

This sample call creates a TestPay account payment. The access token in the call is an OAuth bearer token.
```
curl -v https: // api.testpay.com / payments / payment \
-H "Content-Type: application/json" \
-H "Authorization: Bearer <Access-Token> " \
-d '{
"intent" : "order",
"notification_url" : "https://example.com/your_notification_url",
"payer" : {
"email" : "test@example.com"
},
"transaction" : {
"external_id" : “123456789”
"amount" : {
"value" : "7.47",
"currency" : "USD"
},
"description" : “The payment transaction description”
}
}'
```
The successful call returns a JSON-formatted response body with payment details.
##Payments
###Create payment
POST /payments/payment

Creates a payment. A Payment API call is asynchronous, which lets you show payout details at
a later time. After payment processing, you will receive webhook event notification with final
payment status.

A successful request returns the HTTP 200 OK status code and a JSON response body that
shows payment details.

Request example:
```
curl -v https: // api.testpay.com / payments / payment \
-H "Content-Type: application/json" \
-H "Authorization: Bearer <Access-Token> " \
-d '{
"intent" : "order",
"notification_url" : "https://example.com/your_notification_url",
"payer" : {
"email" : "test@example.com"
},
"transaction" : {
"external_id" : “123456789”
"amount" : {
"value" : "7.47",
"currency" : "USD"
},
"description" : “The payment transaction description”
}
}'
```
Where:
* /payments/payment Create payment endpoint
* intent enum required The payment intent. Available value is: order
* notification_url string required The URL for your webhook listener
* payer object required The source of funds for this payment
* transaction object required A transaction defines what the payment is for and
who fulfills the payment

Payer object schema:

* email string required The email address associated with the payee’s TestPay account

Transaction object schema:

* external_id string optional The merchant-provided Id for the payment unit
* amount object required The amount being collected
* description string optional The description of the payment

TestPay API is idempotent on external_id

Amount object schema:

* value string required The amount charged to the payee by the payer. Maximum length
is 10 characters. Supports two decimal places
* currency string required The three-character ISO-4217 currency code

Sample response:
```
{
"id" : "1B56960729604235TKQQIYVY" ,
"create_time" : " 2017-09-22T20:53:43Z" ,
"state" : "created"
}
```
Where:
* id string The id of the payment generated by TestPay
* create_time string The date and time when the payment was created, in internet date
and time format
* state enum The state of the payment. Available value is: created , approved and
failed

##API responses
TestPay API calls return HTTP status codes with JSON response bodies that include
information about the resource. Each REST API request returns a success or error HTTP status
code.
###Success
In the responses, TestPay returns these HTTP status codes for successful request:

Status code Description

200 The request succeeded
###Error
In the responses for failed requests, TestPay returns 4xx or 5xx status codes.
For all errors TestPay returns an error response body that includes additional error details in
format:
```
{
"error" : "ERROR_CODE" ,
"error_description" : "ERROR_DESCRIPTION"
}
```
In the responses, TestPay returns these HTTP status codes for failed requests:

Status code Error code Error description

400 INVALID_REQUEST Request is not well-formatted,
syntactically incorrect or violates schema

401 AUTHENTIFICATION_FAILURE Authentication failed due to invalid
authentication credentials

415 UNSUPPORTED_MEDIA_TYPE The server does not support the request
payload media type

500 INTERNAL_SERVER_ERROR An internal server error has occurred

####Validation errors

For validation errors, TestPay returns the HTTP 400 Bad Request status code. To prevent
validation errors, ensure that parameters are of the right type and conform to constraints.

####Authentication errors

For authentication errors, TestPay returns the HTTP 401 Unauthorised status code. Access
token-related issues often cause authentication errors. Ensure that access token is valid and
present and not expired.

##Webhooks API
The TestPay REST APIs use webhooks for event notification. Webhooks are HTTP callbacks
that receive notification messages for events.

A webhook listener is a server that you configure at a specific web URL to listen for incoming
HTTP POST notification messages that are triggered when those events occur.
The POST notification message contains event information. If your webhook endpoint is
unavailable or takes too long to respond, TestPay resends the notification message 25 times
over the course of three days until a successful response is given. A successful response is a
HTTP 200 OK status code.

A text field called sha2sig is included to the notification message. The value of this field is a
256-bit message digest, expressed as a string. The signature is constructed by performing an
Sha2 calculation on string build up by concatenating the fields sended to to your webhook
listener. This includes:
* currency
* amount
* The uppercase Sha2 value of the ASCII equivalent of the secret word submitted in the
Settings section of your TestPay merchant account
* id
* external_id
* status

The purpose of the signature is to ensure the integrity of the data posted to your server. You
should always compare the signature value posted by TestPay’s servers with the one you
calculated.

Event notification message parameters:

Field name Description

currency The three-character ISO-4217 currency code

amount The amount of the payment. Maximum length is 10 characters. Supports two
decimal places

id The id of the payment generated by TestPay

external_id The merchant-provided Id for the payment unit

status The state of the payment. Available value is: created, approved and failed
sha2sig Sha2 signature
