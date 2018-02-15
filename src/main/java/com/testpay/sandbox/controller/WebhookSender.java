package com.testpay.sandbox.controller;

import com.testpay.sandbox.controller.request.WebhookRequest;
import com.testpay.sandbox.model.PaymentEntity;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class WebhookSender {

    public void send(PaymentEntity paymentEntity) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        String secretWord = "secret";
        String sha2str = toSha256(secretWord).toUpperCase();

        String fields = paymentEntity.getTransactionAmountCurrency() +
                paymentEntity.getTransactionAmountValue() +
                paymentEntity.getPaymentId() +
                paymentEntity.getTransactionExternalId() +
                paymentEntity.getState() +
                sha2str;

        WebhookRequest request = new WebhookRequest(paymentEntity.getTransactionAmountCurrency(),
                paymentEntity.getTransactionAmountValue(),
                paymentEntity.getPaymentId(),
                paymentEntity.getTransactionExternalId(),
                paymentEntity.getState().toString(),
                toSha256(fields));

        RequestEntity<WebhookRequest> requestEntity = new RequestEntity<>(request,
                httpHeaders,
                HttpMethod.POST,
                URI.create(paymentEntity.getNotificationUrl()));

        new RestTemplate().exchange(requestEntity, Object.class);
    }

    private String toSha256(String text) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(text.getBytes(StandardCharsets.UTF_8));
            return new String(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
    }
}
