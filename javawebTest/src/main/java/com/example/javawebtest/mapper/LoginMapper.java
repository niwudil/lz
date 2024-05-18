package com.example.javawebtest.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.javawebtest.domain.UserDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper extends BaseMapper<UserDTO> {
}
