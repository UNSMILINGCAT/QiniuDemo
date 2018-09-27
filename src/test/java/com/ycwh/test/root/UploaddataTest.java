package com.ycwh.test.root;

import com.sun.istack.internal.logging.Logger;
import com.ycwh.demo.chapter4.DinosaurMapper;
import com.ycwh.util.BuilderSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class UploaddataTest
{
    //    String localFilePath = "https://img5.bcyimg
    // .com/user/4085439/item/c0jgz/493f9c18372348f19d310e61189387a3.jpg/w650";
    String jiatenghui = "https://img9.bcyimg.com/user/1038928/item/c0jj3/jjodzi3tqwowd0enhaauedulc4atxctt.jpg/w650";

    Logger logger = Logger.getLogger(UploaddataTest.class);

    @Test
    public void testUpdata()
    {
        SqlSessionFactory sqlSessionFactory = BuilderSqlSessionFactory.buildSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DinosaurMapper dinosaurMapper = sqlSession.getMapper(DinosaurMapper.class);
//        Dinosaur dinosaur=dinosaurMapper.selectAll();
//        logger.info(dinosaur.getSex().getSex());
        sqlSession.close();
    }
}
