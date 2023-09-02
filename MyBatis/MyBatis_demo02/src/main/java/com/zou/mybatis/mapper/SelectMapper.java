package com.zou.mybatis.mapper;

import com.zou.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {


	//	User getUserById(@Param("id") Integer id);
//	获取一条数据也可以使用List
	List<User> getUserById(@Param("id") Integer id);

	/*
	 * 查询所用用户信息*/

	List<User> getAllUser();

	//查询用户的总记录数
	Integer getCount();

//根据id查询用户信息为一个map集合

	Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

	//查询用户所有信息

//	List<Map<String, Object>> getAllUserToMap();
//	id是唯一的
	@MapKey("id")
	Map<String, Object> getAllUserToMap();
}
