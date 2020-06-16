package cse.capstonedesign.Capstone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import cse.capstonedesign.Capstone.dto.request.SignUpRequestDTO;
import cse.capstonedesign.Capstone.dto.response.DefaultResponse;
import cse.capstonedesign.Capstone.mapper.UserMapper;
import cse.capstonedesign.Capstone.model.Response;
import cse.capstonedesign.Capstone.model.User;

@Service
public class UserService {
	
    @Autowired
    UserMapper userMapper;
    
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public int findIdByEmail(@RequestParam("email") String email) {
    	return userMapper.findIdByEmail(email);
    }
    
    public User findByEmail(@RequestParam("email") String email) {
    	return userMapper.findByEmail(email);
    }

    public ResponseEntity signup(@RequestBody SignUpRequestDTO user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        
        Response response;

		if (userMapper.signup(user) != 0) {
			response = new Response("200", "회원가입 성공", true);
			return DefaultResponse.ok(response);
		} else {
			response = new Response("400", "회원가입 실패", false);
			return DefaultResponse.badRequest(response);
		}
    }
}