package com.zou.mybatis.test;

import com.zou.mybatis.mapper.ParameterMapper;
import com.zou.mybatis.pojo.User;
import com.zou.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;


public class ParameterMapperTest {
	private ParameterMapper parameterMapper;
	/*
	 * MyBatis获取参数值的两种方式
	 *
	 * ${}--实际就是字符串拼接
	 * #{}   实际就是占位符赋值
	 *1.mapper接口方法的参数为单个的字面量类型
	 * 可以通过${}和#{}以任意的字符串获取参数值，但是需要注意${}的单引号问题
	 *
	 * 2.mapper接口方法的参数为多个是
	 * 此时MyBatis会将这些参数放入一个map集合当中，以两种方式进行存储
	 * arg0，arg1... params1  params2....
	 *
	 * 3.*/

	@Test
	public void testGetAllUser() {
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
		List<User> userList = parameterMapper.getAllUser();
		userList.forEach(user-> System.out.println(user));


	}
	@Test
	public void testGetUserByUsername(){
		SqlSession sqlSession = SqlSessionUtils.getSqlSession();
		ParameterMapper parameterMapper = sqlSession.getMapper(ParameterMapper.class);
		User user=parameterMapper.getUserByUsername("admin1");
		System.out.println(user);
	}


	/*@Test
	public void testJDBC() throws Exception{
		String username="admin";
		Class.forName("");
		Connection connection = DriverManager.getConnection("", "", "");
		//会出现sql注入
//		connection.prepareStatement("select * from t_user where username='"+username+"'")
		PreparedStatement preparedStatement = connection.prepareStatement("select * from t_user where username=?");
		preparedStatement.setString(1,username);


	}*/



}
