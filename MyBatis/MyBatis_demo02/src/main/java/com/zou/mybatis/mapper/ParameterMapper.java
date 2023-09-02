package com.zou.mybatis.mapper;

import com.zou.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {

//查询所有员工信息
	List<User> getAllUser();

//根据用户名查询用户信息
	User getUserByUsername(String username);

	User checkLogin(String username,String password);

	User checkLoginByMap(Map<String, Object> map);
	int insertUser(User user);

//	验证登录

	User checkLoginByParams(@Param("username") String username,@Param("password") String password);

}
