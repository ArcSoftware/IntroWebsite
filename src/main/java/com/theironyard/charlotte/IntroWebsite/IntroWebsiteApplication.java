package com.theironyard.charlotte.IntroWebsite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class IntroWebsiteApplication {
//	@Autowired
//	PasswordEncoder encoder;

	public static void main(String[] args) {
		SpringApplication.run(IntroWebsiteApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
//
//	@Bean
//	public PasswordEncoder encoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//				.authorizeRequests()
//				.antMatchers("/chatroom", "/adminchat").authenticated()
//				.anyRequest().permitAll()
//				.and()
//				.formLogin()
//				.loginPage("/login")
//				.permitAll()
//				.and()
//				.logout()
//				.logoutUrl("/logout")
//				.permitAll()
//				.and()
//				.csrf().disable();
//	}
//	@Autowired
//	public void configureAuth(AuthenticationManagerBuilder auth, DataSource dataSource) throws Exception {
//		auth.jdbcAuthentication()
//				.passwordEncoder(encoder)
//				.dataSource(dataSource)
//				.usersByUsernameQuery("select username, password, enabled from users where username = ?")
//				.authoritiesByUsernameQuery("select users.username, authorities.role_name from users inner join authorities on users.id = authorities.user_id where users.username = ?");
//	}
}
