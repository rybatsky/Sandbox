package com.testpay.sandbox.configuration;

import com.testpay.sandbox.security.PaymentAuthEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class PaymentResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter {

    @Autowired
    PaymentAuthEntryPoint authEntryPoint;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.authenticationEntryPoint(authEntryPoint);
    }
}
