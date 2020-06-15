package cse.capstonedesign.Capstone.filter;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import cse.capstonedesign.Capstone.dto.request.UserPrincipal;
import cse.capstonedesign.Capstone.properties.JwtProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.entity.ContentType;

@Slf4j
public class CustomUserPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	private boolean postOnly = true;
	private HashMap<String, String> jsonRequest;

	@Override
	protected String obtainPassword(HttpServletRequest request) {
		String passwordParameter = super.getPasswordParameter();
		if (request.getHeader("Content-type").equals(ContentType.APPLICATION_JSON.getMimeType())) {
			return jsonRequest.get(passwordParameter);
		}
		return request.getParameter(passwordParameter);
	}

	@Override
	protected String obtainUsername(HttpServletRequest request) {
		String usernameParameter = super.getUsernameParameter();
		if (request.getHeader("Content-Type").equals(ContentType.APPLICATION_JSON.getMimeType())) {
			return jsonRequest.get(usernameParameter);
		}
		return request.getParameter(usernameParameter);
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		if (postOnly && !request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("Authentication method not supported " + request.getMethod());
		}

		if (request.getHeader("Content-Type").equals(ContentType.APPLICATION_JSON.getMimeType())) {
			ObjectMapper mapper = new ObjectMapper();
			try {
				this.jsonRequest = mapper.readValue(request.getReader().lines().collect(Collectors.joining()),
						new TypeReference<HashMap<String, String>>() {
						});
			} catch (IOException e) {
				e.printStackTrace();
				throw new AuthenticationServiceException("Request Content-Type(application/json) Parsing Error");
			}
		}

		String username = obtainUsername(request);
		String password = obtainPassword(request);

		log.info("[LOGIN_REQUEST] email : {}, password: ***** ", username);

		if (username == null) {
			username = "";
		}

		if (password == null) {
			password = "";
		}

		username = username.trim();

		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username, password);
		setDetails(request, authRequest);

		return this.getAuthenticationManager().authenticate(authRequest);
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest req, HttpServletResponse res, FilterChain chain,
			Authentication auth) throws IOException, ServletException {
		String email = ((UserPrincipal) auth.getPrincipal()).getUsername();
		int id = ((UserPrincipal) auth.getPrincipal()).getUserId();
		System.out.println(email+ ", id : "+ id);

		System.out.println("succesfulAuthen 진입 : 로그인 성공");
		String token = JWT.create()
				.withSubject(((UserPrincipal) auth.getPrincipal()).getUsername())
				.withClaim("id", ((UserPrincipal) auth.getPrincipal()).getUserId())
				.withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
				.sign(Algorithm.HMAC512(JwtProperties.SECRET.getBytes()));
		res.addHeader(JwtProperties.HEADER_STRING, JwtProperties.TOKEN_PREFIX + token);
	}

	@Override
	public void setPostOnly(boolean postOnly) {
		this.postOnly = postOnly;
	}
}
