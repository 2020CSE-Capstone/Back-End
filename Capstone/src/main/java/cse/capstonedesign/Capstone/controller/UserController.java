package cse.capstonedesign.Capstone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse.capstonedesign.Capstone.dto.request.SignUpRequestDTO;
import cse.capstonedesign.Capstone.model.User;
import cse.capstonedesign.Capstone.service.UserService;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/signup")
    public SignUpRequestDTO signup(@RequestBody SignUpRequestDTO user) {
        user = userService.signup(user);
        return user;
    }
}