package com.lizhengpeng.bigger.java;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStreamReader;
import java.util.List;

public class DebugMain {
    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                .build(new InputStreamReader(DebugMain.class.getClassLoader().getResourceAsStream("mybatis-config-datasource.xml")));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        // 添加分页逻辑
        PageHelper.startPage(1, 10);
        List<User> users = userDao.fetchAll();
        PageInfo<User> pageInfo = new PageInfo<>(users);
        System.out.println(objectMapper.writeValueAsString(pageInfo));
        sqlSession.close();

    }
}
