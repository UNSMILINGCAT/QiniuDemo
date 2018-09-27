package com.ycwh.test.demo.chapter4;

import com.ycwh.demo.chapter4.ArkDinosaurMapper;
import com.ycwh.demo.chapter4.POJO.ArkDinosaur;
import com.ycwh.demo.chapter4.POJO.ArkDinosaurColumn;
import com.ycwh.util.AutoGenerateId;
import com.ycwh.util.BuilderSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.util.List;


public class ArkDinosaurTest
{
    SqlSessionFactory sqlSessionFactory = BuilderSqlSessionFactory.buildSqlSessionFactory();
    SqlSession sqlSession;

    @Test
    public void test()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try
        {
            ArkDinosaurMapper arkDinosaurMapper = sqlSession.getMapper(ArkDinosaurMapper.class);
            ArkDinosaur arkDinosaur = new ArkDinosaur();
            arkDinosaur.setName("安康鱼");
            arkDinosaur.setFeeds(new String[]{"远古企鹅蛋饲料", "羊肉"});
            arkDinosaurMapper.insert(arkDinosaur);
            sqlSession.commit();
        } catch (Exception ex)
        {
            System.err.println("名字已存在");
        } finally
        {

            sqlSession.close();
        }
    }

    @Test
    public void testSelect() throws InterruptedException
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ArkDinosaurMapper arkDinosaurMapper = sqlSession.getMapper(ArkDinosaurMapper.class);
        List<ArkDinosaur> arkDinosaurList = arkDinosaurMapper.select();
        for (ArkDinosaur arkDinosaur : arkDinosaurList)
        {
            arkDinosaur.setId(AutoGenerateId.getAutoGenerateId());
            arkDinosaurMapper.upDate(arkDinosaur);
            sqlSession.commit();
            Thread.sleep(1000L);
        }
    }

    @Test
    public void testSelectColumn()
    {
        sqlSession = sqlSessionFactory.openSession();
        ArkDinosaurMapper arkDinosaurMapper = sqlSession.getMapper(ArkDinosaurMapper.class);
        ArkDinosaurColumn arkDinosaurColumn = new ArkDinosaurColumn();
        arkDinosaurColumn.setName("name");
        ArkDinosaur[] arkDinosaur = arkDinosaurMapper.selectColumn("南方巨兽龙");
        System.out.println(arkDinosaur[0].getName());
    }
}
