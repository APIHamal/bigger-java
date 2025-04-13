package com.lizhengpeng.bigger.java;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStreamReader;

public class DebugMain {
    public static void main(String[] args) throws Exception {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(new InputStreamReader(DebugMain.class.getClassLoader().getResourceAsStream("mybatis-config-datasource.xml")));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        User user = userDao.queryUserInfoById(1l);
        System.out.println(user);
        sqlSession.close();
    }
}
