package com.ycwh.test.demo.chapter5;

import com.ycwh.demo.chapter5.POJO.PdCountRoleParams;
import com.ycwh.demo.chapter5.mapper.PdCountRoleParamsMapper;
import com.ycwh.util.BuilderSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;

public class PdCountRoleParamsMapperTest
{
    SqlSessionFactory sqlSessionFactory = BuilderSqlSessionFactory.buildSqlSessionFactory();
    SqlSession sqlSession;
    Logger logger = Logger.getLogger(PdCountRoleParamsMapperTest.class);

    @Test
    public void countRole()
    {
        sqlSession = sqlSessionFactory.openSession();
        PdCountRoleParamsMapper pdCountRoleParamsMapper = sqlSession.getMapper(PdCountRoleParamsMapper.class);
        PdCountRoleParams pdCountRoleParams = new PdCountRoleParams();
        pdCountRoleParams.setRoleName("王林");
        pdCountRoleParamsMapper.countRole(pdCountRoleParams);
        logger.info(pdCountRoleParams.getTotal());
        logger.info(pdCountRoleParams.getExecDate());
    }
}
