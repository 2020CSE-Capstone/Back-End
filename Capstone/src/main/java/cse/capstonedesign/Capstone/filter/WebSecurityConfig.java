package cse.capstonedesign.Capstone.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final UserDetailsService userDetailsService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final ObjectMapper objectMapper;

	public WebSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder,
			ObjectMapper objectMapper) {
		this.objectMapper = new ObjectMapper();
		this.userDetailsService = userDetailsService;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
				.and()
					.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) 
				.and()
					.authorizeRequests()
					.antMatchers("/api/user/**").permitAll()
					.antMatchers("/login").permitAll()
					.antMatchers("/profile/**").authenticated() // authenticated( ) : 로그인한 모든 사용자의 접근을 허용합니다.
					.antMatchers("/admin/**").hasRole("ADMIN") // hasRole( ) : 로그인한 사용자 중 해당 ROLE을 가진 사용자만 접근을 허용합니다.
					.antMatchers("/api/public/users").hasRole("ADMIN").antMatchers("/manager/**")
					.hasAnyRole("ADMIN", "MANAGER") // hasAnyRole( ) : 로그인한 사용자 중 선언된 ROLE 중 하나이상의 ROLE을 가지고 있는 사용자만 접근을 허용합니다.
					.anyRequest().authenticated()
				.and()
					.addFilter(new JWTLoginFilter(authenticationManager()))
					.addFilter(new JWTAuthenticationFilter2(authenticationManager()));
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}