package com.testpay.sandbox.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testpay.sandbox.controller.response.ErrorResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class PaymentAuthEntryPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException) throws IOException, ServletException {
        ErrorResponse failure = new ErrorResponse("AUTHENTIFICATION_FAILURE",
                "Authentication failed due to invalid authentication credentials");
        String jsonFailure = new ObjectMapper().writeValueAsString(failure);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(jsonFailure);
    }
}
