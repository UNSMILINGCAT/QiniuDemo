package com.ycwh.test.root;

import com.ycwh.demo.chapter4.FileMapper;
import com.ycwh.demo.chapter4.POJO.TestFile;
import com.ycwh.util.BuilderSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

public class FileMapperTest
{
    @Test
    public void testInsert()
    {
        SqlSessionFactory sqlSessionFactory = BuilderSqlSessionFactory.buildSqlSessionFactory();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        FileMapper fileMapper = sqlSession.getMapper(FileMapper.class);
        TestFile testFile = new TestFile();
        testFile.setContent(new byte[]{1, 2, 3});
        fileMapper.insert(testFile);
        sqlSession.commit();
        sqlSession.close();
    }
}
