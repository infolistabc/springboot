package com.sun.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableAuthorizationServer  //当前应用是一个授权服务器
public class OAuth2AuthServerConfig extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private AuthenticationManager authenticationManager;
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	@Autowired
	private DataSource dataSource;
	/**
	 * 把token信息持久化到数据库
	 * @return
	 */
	@Bean
	public TokenStore tokenStore() {
		//return new JdbcTokenStore(dataSource);
		return new JwtTokenStore(JwtTokenEnhancer());
	}
	
	@Bean
	public JwtAccessTokenConverter JwtTokenEnhancer() {
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("12345");
		return converter;
	}



	/**
	 * 用来配置授权（authorization）以及令牌（token）的访问端点和令牌服务(token services)，
	 * 还有token的存储方式(tokenStore)；
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.tokenStore(tokenStore())
			.tokenEnhancer(JwtTokenEnhancer())
			.authenticationManager(authenticationManager);
	}
	
	/**
	 * 用来配置客户端详情服务（ClientDetailsService），客户端详情信息在这里进行初始化，
	 * 你能够把客户端详情信息写死在这里或者是通过数据库来存储调取详情信息
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		//配置持久化信息
		clients.jdbc(dataSource);
	}
	/**
	 *  用来配置令牌端点(Token Endpoint)的安全约束
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("isAuthenticated()")
				.checkTokenAccess("isAuthenticated()");
	}
	
}