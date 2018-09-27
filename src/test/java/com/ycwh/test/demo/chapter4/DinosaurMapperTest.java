package com.ycwh.test.demo.chapter4;

import com.sun.istack.internal.logging.Logger;
import com.ycwh.demo.chapter4.DinosaurMapper;
import com.ycwh.demo.chapter4.POJO.Dinosaur;
import com.ycwh.util.BuilderSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DinosaurMapperTest
{
    SqlSessionFactory sqlSessionFactory = BuilderSqlSessionFactory.buildSqlSessionFactory();
    Logger logger = Logger.getLogger(DinosaurMapperTest.class);

    @Test
    public void testSelectAll()
    {
        SimpleDateFormat df = new SimpleDateFormat("yyMMddHHmm");
        System.out.println(df.format(new Date()));
    }

    @Test
    public void testInsert()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        DinosaurMapper dinosaurMapper = sqlSession.getMapper(DinosaurMapper.class);
        List<Dinosaur> dinosaurs = new ArrayList<>();
        Dinosaur dinosaur = new Dinosaur();
//        dinosaur.setDinosaurName("风神翼龙");
//        dinosaur.setSex(SexEnum.MALE);
//        dinosaur.setLv(11);
        dinosaurs = dinosaurMapper.selectAll();
//        sqlSession.commit();
        logger.info(dinosaurs.get(1).getDinosaurName() + " " + dinosaurs.get(1).getSex().getSex());
        sqlSession.close();
    }
}
