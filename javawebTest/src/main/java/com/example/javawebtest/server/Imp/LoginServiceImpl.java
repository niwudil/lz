package com.example.javawebtest.server.Imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.javawebtest.domain.UserDTO;
import com.example.javawebtest.mapper.LoginMapper;
import com.example.javawebtest.server.LoginService;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl extends ServiceImpl<LoginMapper, UserDTO> implements LoginService {
}
