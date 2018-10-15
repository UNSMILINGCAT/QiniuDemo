package com.ycwh.test.demo.chapter12;

import com.ycwh.demo.chapter12.mapper.RoleMapper;
import com.ycwh.pojo.Role;
import com.ycwh.util.BuilderSqlSessionFactory;
import org.apache.log4j.Logger;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test
{
    private Logger logger = Logger.getLogger(Test.class);

    /**
     * 测试spring-bean的value的class：用法
     */
    @org.junit.Test
    public void test()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter10/spring-dataSource.xml");
        BuilderSqlSessionFactory builderSqlSessionFactory = applicationContext.getBean(BuilderSqlSessionFactory.class);
        System.out.println(builderSqlSessionFactory.getConfigLocation());
    }

    /**
     * 测试SqlSessionTemplate
     */
    @org.junit.Test
    public void testSqlSessionTemplate()
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter12/spring-cfx.xml");
        SqlSessionTemplate template = applicationContext.getBean(SqlSessionTemplate.class);
        SqlSessionFactoryBean sqlSessionFactoryBean = applicationContext.getBean(SqlSessionFactoryBean.class);
        RoleMapper roleMapper = applicationContext.getBean(RoleMapper.class);
        Role role = new Role();
        role.setRoleName("贪狼");
        role.setNote
                ("贪狼，为七彩仙尊七魄之黄魄，主气运，常常能获得强大的法器，是王林的福星，所得之物多次被王林夺走。登场时处剑尊凌天候麾下，被派去妖灵之地保护凌天候的弟子。后被送往罗天星域抓捕王林。误进入望月体内，被困于望月排泄处，使得其身上一直有十分难闻的臭味。后王林为躲避姚家追杀进入望月体内，夺走贪狼的古神鼎。\n" +
                        "后机缘巧合下来到太古星辰，再遇王林，被夺走大量宝物，但身上气味也被王林祛除。后被双子大天尊带入仙罡大陆，被当作玩物。");
//        template.insert("com.ycwh.demo.chapter12.mapper.RoleMapper.xml.insertRole", role);
        roleMapper.insertRole(role);
//        template.commit();
    }
}
