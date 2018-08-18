package com.huyinsong;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
//@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	/*@Autowired
	DataSource dataSource;

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().authorizeRequests().antMatchers("/login").permitAll().anyRequest().authenticated().and().formLogin().and().logout().logoutUrl("/signout")
				.logoutSuccessUrl("/login").logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler()).and()
				.exceptionHandling().authenticationEntryPoint(new Http403ForbiddenEntryPoint())
				.accessDeniedHandler(new AccessDeniedHandlerImpl()).and().httpBasic().disable();
	}

	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.jdbcAuthentication().dataSource(dataSource)
				.passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
	}
	
	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Arrays.asList("*"));
		configuration.setAllowedMethods(Arrays.asList("GET","POST"));
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}*/
}
