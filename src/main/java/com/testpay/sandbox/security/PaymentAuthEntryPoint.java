package com.testpay.sandbox.security;


import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.testpay.sandbox.controller.response.ErrorResponse;
import org.springframework.http.MediaType;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;


@Component
public class PaymentAuthEntryPoint implements AuthenticationEntryPoint
{
    @Override
    public void commence(final HttpServletRequest request, final HttpServletResponse response,
            final AuthenticationException authException) throws IOException
    {
        final ErrorResponse failure = new ErrorResponse("AUTHENTIFICATION_FAILURE",
                "Authentication failed due to invalid authentication credentials");

        final String jsonFailure = new ObjectMapper().writeValueAsString(failure);

        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(jsonFailure);
    }
}
