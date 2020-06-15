package cse.capstonedesign.Capstone.filter;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

//@Order(SecurityProperties.DEFAULT_FILTER_ORDER)
@Slf4j
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
		auth/* .authenticationProvider(authenticationProvider()) */
				.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//			.and()
//        	.inMemoryAuthentication() // inMemoryAuthentication( ) : user와 password 정보를 h2와 같은 in memory에 저장합니다.
//        	// dndrl1515 user의 password를 minholee93으로 설정하고, 해당 1234를 password encoder로 encode합니다. 또한, dndrl1515의 ROLE을 ADMIN으로 설정합니다.
//        	.withUser("admin").password(bCryptPasswordEncoder.encode("1234")).roles("ADMIN");
//        	.and()
//			.withUser("manager").password(bCryptPasswordEncoder.encode("1234")).roles("MANAGER")
//			.and();
	}

//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
//    }

//    @Override
//    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
//    }

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and()
		.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//        		.csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//        		.authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/api/user/signup").permitAll()
//                .antMatchers(HttpMethod.POST, "/login").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                
				.and()
//				.addFilter(new JWTLoginFilter(authenticationManager()))
				.addFilterAt(getAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
				.addFilter(new JWTAuthenticationFilter2(authenticationManager()))

				.authorizeRequests()
				.antMatchers("/api/login").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers(HttpMethod.POST, "/api/user/signup").permitAll()
//        
//        .antMatchers("/index.html").permitAll() // antMatchers( ) : 해당 location과 일치하는 resource에 대한 접근 허용유무를 정의합니다.
//			// permitAll( ) : 모든 임의의 사용자들의 접근을 허용합니다. 로그인하지 않은 사용자도 접근할 수 있습니다.
				.antMatchers("/profile/**").authenticated() // authenticated( ) : 로그인한 모든 사용자의 접근을 허용합니다.
				.antMatchers("/admin/**").hasRole("ADMIN") // hasRole( ) : 로그인한 사용자 중 해당 ROLE을 가진 사용자만 접근을 허용합니다.
				.antMatchers("/api/public/users").hasRole("ADMIN").antMatchers("/manager/**")
				.hasAnyRole("ADMIN", "MANAGER") // hasAnyRole( ) : 로그인한 사용자 중 선언된 ROLE 중 하나이상의 ROLE을 가지고 있는 사용자만 접근을
												// 허용합니다.

				.anyRequest().authenticated().and()
//                .addFilter(new JWTLoginFilter(authenticationManager()))
//                .addFilter(new JWTAuthenticationFilter2(authenticationManager()))
//                .exceptionHandling()
//                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
//                .httpBasic()
				.formLogin().disable()
//        .and()
//        .formLogin()
//        .loginProcessingUrl("/login") //the URL on which the clients should post the login information
//        .usernameParameter("login") //the username parameter in the queryString, default is 'username'
//        .passwordParameter("password") //the password parameter in the queryString, default is 'password'
//        .successHandler(this::loginSuccessHandler)
//        .failureHandler(this::loginFailureHandler)
//
//        .and()
//        .logout()
//        .logoutUrl("/logout") //the URL on which the clients should post if they want to logout
//        .logoutSuccessHandler(this::logoutSuccessHandler)
//        .invalidateHttpSession(true)
//
//        .and()
//        .exceptionHandling() //default response if the client wants to get a resource unauthorized
//        .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))

//        		.and()
;
	}

	protected CustomUserPasswordAuthenticationFilter getAuthenticationFilter() {
    	CustomUserPasswordAuthenticationFilter authFilter = new CustomUserPasswordAuthenticationFilter();
    	
    	try {
    		authFilter.setFilterProcessesUrl("/api/login");
    		authFilter.setAuthenticationManager(this.authenticationManagerBean());
    		authFilter.setUsernameParameter("email");
    		authFilter.setPasswordParameter("password");
//    		authFilter.setAuthenticationSuccessHandler("");
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	
    	return authFilter;
    }

	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(userDetailsService);
		authProvider.setPasswordEncoder(bCryptPasswordEncoder);
		return authProvider;
	}

	private void loginSuccessHandler(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {

		response.setStatus(HttpStatus.OK.value());
		objectMapper.writeValue(response.getWriter(), "Login Successed");
	}

	private void loginFailureHandler(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException e) throws IOException {

		response.setStatus(HttpStatus.UNAUTHORIZED.value());
		objectMapper.writeValue(response.getWriter(), "Login Failured");
	}

	private void logoutSuccessHandler(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException {

		response.setStatus(HttpStatus.OK.value());
		objectMapper.writeValue(response.getWriter(), "Bye!");
	}

//    @Bean
//    public CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//
//        configuration.addAllowedOrigin("http://localhost:8080");
//        configuration.addAllowedHeader("*");
//        configuration.addAllowedMethod("*");
//        configuration.setAllowCredentials(true);
//
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return (CorsConfigurationSource) source;
//    }

//    @Bean
//    CorsConfigurationSource corsConfigurationSource() {
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.setAllowedOrigins(Arrays.asList("*"));
//        configuration.setAllowedMethods(Arrays.asList("*"));
//        configuration.setAllowedHeaders(Arrays.asList("*"));
//        configuration.setAllowCredentials(true);
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//        source.registerCorsConfiguration("/**", configuration);
//        return source;
//    }
}