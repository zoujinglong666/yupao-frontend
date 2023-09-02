package com.zou.mybatis.text;

import com.zou.mybatis.mapper.UserMapper;
import com.zou.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MyBatisTest {

	@Test
	public void testMybatis() throws IOException {
		//读取MyBatis的核心配置文件
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		//获取SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
		//获取sqlSession，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
		//SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		//通过代理模式创建UserMapper接口的代理实现类对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		System.out.println("-----------");
		System.out.println(userMapper);
		//调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
		int result = userMapper.insertUser();
		//提交事务
//		sqlSession.commit();
		System.out.println("result:" + result);

	}


	/*@Test
	public void testUpdate() throws IOException {
		//读取MyBatis的核心配置文件
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		//获取SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
		//获取sqlSession，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
		//SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		//通过代理模式创建UserMapper接口的代理实现类对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
		 userMapper.updateUser();
//		提交事务
		sqlSession.commit();

	}*/


/*	@Test
	public void testCRUD() throws IOException {
		//读取MyBatis的核心配置文件
		InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
		//获取SqlSessionFactoryBuilder对象
		SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
		//通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
		SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
		//获取sqlSession，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
		//SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
		SqlSession sqlSession = sqlSessionFactory.openSession(true);
		//通过代理模式创建UserMapper接口的代理实现类对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句
//		userMapper.updateUser();

//		userMapper.deleteUser();

	*//*	User user=userMapper.getUserById();
		System.out.println(user);*//*

	List<User> userList=userMapper.getAllUser();
		System.out.println(userList);
//		提交事务
		sqlSession.commit();

	}*/
}
