package com.testpay.sandbox.controller;


import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.testpay.sandbox.controller.request.WebhookRequest;
import com.testpay.sandbox.model.PaymentEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class WebhookSender
{
    public void send(final PaymentEntity paymentEntity)
    {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        final String secretWord = "secret";
        final String sha2str = toSha256(secretWord).toUpperCase();

        final String fields = paymentEntity.getTransactionAmountCurrency() +
                paymentEntity.getTransactionAmountValue() +
                paymentEntity.getPaymentId() +
                paymentEntity.getTransactionExternalId() +
                paymentEntity.getState() +
                sha2str;

        final WebhookRequest request = new WebhookRequest(paymentEntity.getTransactionAmountCurrency(),
                paymentEntity.getTransactionAmountValue(), paymentEntity.getPaymentId(),
                paymentEntity.getTransactionExternalId(), paymentEntity.getState().toString(), toSha256(fields));

        final RequestEntity<WebhookRequest> requestEntity = new RequestEntity<>(request,
                httpHeaders, HttpMethod.POST, URI.create(paymentEntity.getNotificationUrl()));

        new RestTemplate().exchange(requestEntity, Object.class);
    }


    private String toSha256(final String text)
    {
        try
        {
            final MessageDigest digest = MessageDigest.getInstance("SHA-256");
            final byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            return new String(hash);
        }
        catch (final NoSuchAlgorithmException e)
        {
            e.printStackTrace();
            return "";
        }
    }
}
