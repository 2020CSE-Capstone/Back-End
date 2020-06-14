package cse.capstonedesign.Capstone.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private UserDetailsService userDetailsService;

    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public WebSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder) {
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
//        	.withUser("admin").password(bCryptPasswordEncoder.encode("1234")).roles("ADMIN")
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
        http
//        		.cors().and()
//        		.csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//        		.authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/api/user/signup").permitAll()
//                .antMatchers(HttpMethod.POST, "/login").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                
        .cors().and()
        .authorizeRequests()
        .antMatchers(HttpMethod.POST, "/login").permitAll()
        .antMatchers(HttpMethod.POST, "/api/user/signup").permitAll()
//        
//        .antMatchers("/index.html").permitAll() // antMatchers( ) : 해당 location과 일치하는 resource에 대한 접근 허용유무를 정의합니다.
//			// permitAll( ) : 모든 임의의 사용자들의 접근을 허용합니다. 로그인하지 않은 사용자도 접근할 수 있습니다.
		.antMatchers("/profile/**").authenticated() // authenticated( ) : 로그인한 모든 사용자의 접근을 허용합니다.
		.antMatchers("/admin/**").hasRole("ADMIN") // hasRole( ) : 로그인한 사용자 중 해당 ROLE을 가진 사용자만 접근을 허용합니다.
		.antMatchers("/api/public/users").hasRole("ADMIN")
		.antMatchers("/manager/**").hasAnyRole("ADMIN","MANAGER") // hasAnyRole( ) : 로그인한 사용자 중 선언된 ROLE 중 하나이상의 ROLE을 가지고 있는 사용자만 접근을 허용합니다.
        
        .anyRequest().authenticated()
        .and()
                .addFilter(new JWTLoginFilter(authenticationManager()))
                .addFilter(new JWTAuthenticationFilter2(authenticationManager()))
//                .exceptionHandling()
//                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED))
   
        		.csrf().disable()
        		.httpBasic();
    }

}