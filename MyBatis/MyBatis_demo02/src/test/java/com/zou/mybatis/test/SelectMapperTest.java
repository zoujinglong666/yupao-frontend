package com.zou.mybatis.test;

import com.zou.mybatis.mapper.ParameterMapper;
import com.zou.mybatis.mapper.SelectMapper;
import com.zou.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public class SelectMapperTest {

	@Test
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
		SelectMapper mapper = sqlSession.getMapper(SelectMapper.class);
//		System.out.println(mapper);
//
//		System.out.println(mapper.getUserById(10));

//		List<User> list=mapper.getAllUser();
//		System.out.println(list);

//		Integer count=mapper.getCount();
//		System.out.println(count);

//		Map<String, Object> map=mapper.getUserByIdToMap(10);
//		System.out.println(map);

		System.out.println(mapper.getAllUserToMap());

		//调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配映射文件中的SQL标签，并执行标签中的SQL语句


//		提交事务
		sqlSession.commit();

	}
}
