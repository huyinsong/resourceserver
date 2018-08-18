package com.huyinsong;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class OAuth2ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	@Autowired
    private CustomAccessTokenConverter customAccessTokenConverter;

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http.authorizeRequests().anyRequest().permitAll().and().httpBasic().disable();
        // @formatter:on                
    }
	
	
	@Override
	public void configure(ResourceServerSecurityConfigurer config) throws Exception {
		config.tokenServices(tokenServices()).resourceId("openid");
	}

	@Bean
	public TokenStore tokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}
	
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		Resource resource = new ClassPathResource("public.pem");
		String publicKey = null;
		try {
			publicKey = inputStream2String(resource.getInputStream());
		} catch (final IOException e) {
			throw new RuntimeException(e);
		}
		converter.setVerifierKey(publicKey);
		converter.setAccessTokenConverter(customAccessTokenConverter);
		return converter;
	}
	
	@Bean
	public TokenStore jwtTokenStore() {
		return new JwtTokenStore(accessTokenConverter());
	}
	
	@Bean
	@Primary
	public DefaultTokenServices tokenServices() {
		final DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setTokenStore(tokenStore());
		return defaultTokenServices;
	}

	protected String inputStream2String(InputStream is) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		while ((line = in.readLine()) != null) {
			buffer.append(line);
		}
		return buffer.toString();
	}
	

}
