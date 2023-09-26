package com.example.springboot.mapper;

import com.example.springboot.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM CITY WHERE state = #{state}")
    User findByState(@Param("state") String state);
}
