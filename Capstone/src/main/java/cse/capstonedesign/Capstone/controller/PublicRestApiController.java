package cse.capstonedesign.Capstone.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cse.capstonedesign.Capstone.mapper.UserMapper;
import cse.capstonedesign.Capstone.model.User;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/public")
@RequiredArgsConstructor
public class PublicRestApiController {

    private final UserMapper userMapper;

    @GetMapping("test1")
    public String test1(){
        return "API Test 1";
    }

    @GetMapping("test2")
    public String test2(){
        return "API Test 2";
    }

    @GetMapping("users")
    public List<User> getAllUsers(){
        return this.userMapper.getAllUsers();
    }
}