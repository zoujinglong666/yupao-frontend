package com.zou.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
//封装测试类
public class SqlSessionUtils {

	public static SqlSession getSqlSession(){
		SqlSession sqlSession=null;
		try {
			InputStream is=Resources.getResourceAsStream("mybatis-config.xml");
			SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(is);
			//自动提交事务
			sqlSession =sqlSessionFactory.openSession(true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sqlSession;
	}
}
