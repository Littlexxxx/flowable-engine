package cn.hxh.demo111.core.adapter.application.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: xinhao.hu
 * @date: 2022/4/8 10:02 上午
 * @description:
 **/
public class MybatisTest {
    public static void main(String[] args) throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFacory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        /******************************分割线******************************/
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //获取Mapper
        DemoMapper mapper = sqlSession.getMapper(DemoMapper.class);
        int id = 123;
        System.out.println(mapper.selectAll(id));
        sqlSession.close();
        sqlSession.commit();
    }
}
