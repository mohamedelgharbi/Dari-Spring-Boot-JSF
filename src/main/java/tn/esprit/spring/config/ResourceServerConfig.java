package tn.esprit.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "resource_id";


    @Autowired
    @Qualifier("tokenStore")
    private TokenStore tokenStore;


    private static final String[] PUBLIC_MATCHERS = {
            "/oauth/token/**"

    };
    private static final String[] PRIVATE_MATCHERS = {
            "/users/**"
    		
    };




    @Autowired
    @Qualifier("tokenServices")
    private DefaultTokenServices tokenServices;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST).permitAll()
                .antMatchers(PUBLIC_MATCHERS).permitAll()
                .antMatchers(PRIVATE_MATCHERS).authenticated();
                
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources
                .resourceId(RESOURCE_ID)
                .tokenServices(tokenServices)
                .tokenStore(tokenStore);
    }
}