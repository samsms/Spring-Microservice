package com.example.Login.controllers;

import com.example.Login.dto.LoginDto;

import static com.example.Login.dto.Response.error;
import static com.example.Login.dto.Response.ok;
import com.example.Login.dto.UserRegDto;
import com.example.Login.services.UsersService;

import java.util.HashMap;
import java.util.Map;

import com.example.Login.util.JWTUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    UsersService usersService;

    @Autowired
    JWTUtility jwtUtility;
    @PostMapping("auth/register")
    public Object register(@RequestBody UserRegDto userRegDto){
      if(usersService.createUser(userRegDto)){
          return ok("true", "User created successfully",userRegDto);
      }
      else{
           return error("false","created registration failed");
      }
    }
    @PostMapping("auth/login")
    public Object Login(@RequestBody LoginDto loginDto){

       if(usersService.Login(loginDto)){
          String token= jwtUtility.generateToken(usersService.loadUserByUsername(loginDto.getUsername()));

            Map map=new HashMap();
           map.put("token", token);

           return ok("true", "Login Successful",map);
       }
       else{
           return error("false","Login failed! Wrong username or password !");
       }


    }

}
