package cse.capstonedesign.Capstone.controller;

import java.util.Date;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import cse.capstonedesign.Capstone.dto.request.LoginRequestDTO;
import cse.capstonedesign.Capstone.dto.request.SignUpRequestDTO;
import cse.capstonedesign.Capstone.dto.response.DefaultResponse;
import cse.capstonedesign.Capstone.model.Response;
import cse.capstonedesign.Capstone.properties.JwtProperties;
import cse.capstonedesign.Capstone.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserService userService;

	@PostMapping("/login")
	public ResponseEntity login(@RequestBody LoginRequestDTO login) {
		String email = login.getEmail();
		String password = login.getPassword();

		// 처음에 email과 password를 통해 UsernamePasswordAuthenticationToken을 만듭니다.
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(email, password);
		 // 다음은 AuthenticationManager의 authenticate 메소드에 위에서 만든 token을 파라미터로 하여 인증을 진행합니다. 이 때 SpringSecurity 설정한 인증이 적용됩니다.
		Authentication authentication = authenticationManager.authenticate(authenticationToken); 
		// 인증받은 결과를 SecurityContextHolder에서 getContext()를 통해 context를 받아온 후, 이 context에 인증 결과를 set 해줍니다. 이로써 서버의 SecurityContext에는 인증값이 설정됩니다.
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		// email로 id 가져오기. 토큰에 넣을 거임
		int user_id = userService.findIdByEmail(email);
//		System.out.println(user_id);

		// 토큰 생성
		String token = JWT.create()
				.withSubject(email)
				.withClaim("id", user_id)
				.withExpiresAt(new Date(System.currentTimeMillis() + JwtProperties.EXPIRATION_TIME))
				.sign(Algorithm.HMAC512(JwtProperties.SECRET.getBytes()));
		
//		res.setHeader("Authorization", JwtProperties.TOKEN_PREFIX + token);
//		System.out.println(JwtProperties.TOKEN_PREFIX + token);
//		return JwtProperties.TOKEN_PREFIX + token;
		return DefaultResponse.ok(new Response("200", "로그인 성공", JwtProperties.TOKEN_PREFIX + token));
	}
	
	@PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignUpRequestDTO user) {
        return userService.signup(user);
    }
	
	@GetMapping("/email/{email}")
    public ResponseEntity isEmailOverlapCheck(@PathVariable("email") String email) {
        return userService.isEmailOverlapCheck(email);
    }
	
	@GetMapping("/nickname/{nickname}")
    public ResponseEntity isNicknameOverlapCheck(@PathVariable("nickname") String nickname) {
        return userService.isNicknameOverlapCheck(nickname);
    }
}