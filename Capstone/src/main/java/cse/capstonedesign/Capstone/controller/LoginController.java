package cse.capstonedesign.Capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse.capstonedesign.Capstone.dto.request.LoginRequestDTO;
import cse.capstonedesign.Capstone.dto.request.SignUpRequestDTO;
import cse.capstonedesign.Capstone.service.UserPrincipalDetailsService;
import cse.capstonedesign.Capstone.service.UserService;

@RestController
@RequestMapping("login")
public class LoginController{

    @Autowired
    UserPrincipalDetailsService userPrincipalDetailsService;
//
//    @PostMapping(value = "/")
//    public LoginRequestDTO login(@RequestBody LoginRequestDTO login) {
//        user = userPrincipalDetailsService.loadUserByUsername(login.getEmail());
//        return user;
//    }
}