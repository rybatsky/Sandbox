package com.testpay.sandbox.configuration;


import com.testpay.sandbox.security.PaymentAuthEntryPoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;


@Configuration
@EnableResourceServer
public class PaymentResourceServerConfigurerAdapter extends ResourceServerConfigurerAdapter
{
    private final PaymentAuthEntryPoint authEntryPoint;


    public PaymentResourceServerConfigurerAdapter(final PaymentAuthEntryPoint authEntryPoint)
    {
        this.authEntryPoint = authEntryPoint;
    }


    @Override
    public void configure(final ResourceServerSecurityConfigurer resources)
    {
        resources.authenticationEntryPoint(authEntryPoint);
    }
}
