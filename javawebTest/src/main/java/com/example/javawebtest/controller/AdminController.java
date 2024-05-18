package com.example.javawebtest.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.javawebtest.domain.UserDTO;
import com.example.javawebtest.domain.UserVO;
import com.example.javawebtest.server.LoginService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AdminController {

    @Resource
    private LoginService loginService;

    @PostMapping("/login")
    public UserVO login(@RequestBody UserDTO userDTO){
        UserDTO one=null;
        if(userDTO.getUsername()!=null && userDTO.getPassword()!=null){
            QueryWrapper<UserDTO> qw = new QueryWrapper<>();
            qw.eq("username", userDTO.getUsername());
            one = loginService.getOne(qw);
            if(one!=null){
                if(!one.getPassword().equals(userDTO.getPassword())){
                    System.out.println("登录失败");
                    return new UserVO(userDTO.getUsername(),201,"密码错误");
                }
                System.out.println("登录成功");
                return new UserVO(userDTO.getUsername(),200,"登录成功");
            }
        }
        System.out.println("登录失败");
        return new UserVO(userDTO.getUsername(),201,"登录失败,用户名不存在");
    }

    @PostMapping("/register")
    public UserVO register(@RequestBody UserDTO userDTO){
        QueryWrapper<UserDTO> qw = new QueryWrapper<>();
        qw.eq("username", userDTO.getUsername());
        UserDTO one = loginService.getOne(qw);
        if(one!=null){
            System.out.println("注册失败");
            return new UserVO(userDTO.getUsername(),201,"注册失败，用户名已存在");
        }


        boolean save = loginService.save(userDTO);
        if(save){
            System.out.println("注册成功");
            return new UserVO(userDTO.getUsername(), 200,"注册成功");
        }
        System.out.println("注册失败");
        return new UserVO(userDTO.getUsername(), 201,"注册失败");
    }
}
