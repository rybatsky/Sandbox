package com.testpay.sandbox.configuration;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;


@Configuration
@EnableAuthorizationServer
public class OAuth2Adapter extends AuthorizationServerConfigurerAdapter
{
    private final AuthenticationManager manager;


    public OAuth2Adapter(final AuthenticationManager manager)
    {
        this.manager = manager;
    }


    @Override
    public void configure(final AuthorizationServerEndpointsConfigurer endpoints)
    {
        endpoints.authenticationManager(manager);
        endpoints.pathMapping("/oauth/token", "/oauth2/token");
    }


    @Override
    public void configure(final ClientDetailsServiceConfigurer clients) throws Exception
    {
        clients.inMemory()
                .withClient("test")
                .secret("secret")
                .scopes("http://localhost:8080/payments/.*")
                .accessTokenValiditySeconds(3600)
                .authorizedGrantTypes("client_credentials")
                .resourceIds("oauth2-resource");
    }
}
