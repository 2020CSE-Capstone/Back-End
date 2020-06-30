package cse.capstonedesign.Capstone.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;

import cse.capstonedesign.Capstone.dto.request.LoginRequestDTO;
import cse.capstonedesign.Capstone.dto.request.UserPrincipal;
import cse.capstonedesign.Capstone.mapper.UserMapper;
import cse.capstonedesign.Capstone.model.User;
import cse.capstonedesign.Capstone.properties.JwtProperties;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

	private AuthenticationManager authenticationManager;

	public JWTLoginFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse res)
			throws AuthenticationException {
		
		log.info("----------------------------");
		LoginRequestDTO credentials = null;
        try {
            credentials = new ObjectMapper().readValue(request.getInputStream(), LoginRequestDTO.class);
    		log.info("[attemptAuthentication] email : {}, password: **** ", credentials.getEmail());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create login token
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                credentials.getEmail(),
                credentials.getPassword(),
                new ArrayList<>()
        );

        // Authenticate user
        Authentication auth = authenticationManager.authenticate(authenticationToken);
        
        return auth;
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		String email = ((UserPrincipal) auth.getPrincipal()).getUsername();
		int id = ((UserPrincipal) auth.getPrincipal()).getUserId();
		log.info("[successfulAuthentication] email : {}, password: **** ", ((UserPrincipal) auth.getPrincipal()).getUsername());

		String token = JWT.create()
				.withSubject(((UserPrincipal) auth.getPrincipal()).getUsername())
				.withClaim("id", ((UserPrincipal) auth.getPrincipal()).getUserId())
				.withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
				.sign(Algorithm.HMAC512(JwtProperties.SECRET.getBytes()));
		res.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + token);
	}

}