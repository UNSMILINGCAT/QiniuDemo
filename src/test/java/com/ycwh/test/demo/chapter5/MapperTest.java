package com.ycwh.test.demo.chapter5;

import com.ycwh.demo.chapter5.POJO.Employee;
import com.ycwh.demo.chapter5.SexEnum;
import com.ycwh.demo.chapter5.mapper.EmployeeMapper;
import com.ycwh.util.BuilderSqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class MapperTest
{
    Logger logger = Logger.getLogger(MapperTest.class);
    SqlSessionFactory sqlSessionFactory = BuilderSqlSessionFactory.buildSqlSessionFactory();

    @Test
    public void test()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = new ArrayList<>();
        Employee employee = new Employee();
        employee.setRealName("王林");
        employee.setSexEnum(SexEnum.Male);
        employees.add(employee);

        employee = new Employee();
        employee.setRealName("李慕婉");
        employee.setSexEnum(SexEnum.Female);
        employees.add(employee);

        employee = new Employee();
        employee.setRealName("木冰眉");
        employee.setSexEnum(SexEnum.Female);
        employees.add(employee);

        employee = new Employee();
        employee.setRealName("李倩梅");
        employee.setSexEnum(SexEnum.Female);
        employees.add(employee);

        employee = new Employee();
        employee.setRealName("司徒南");
        employee.setSexEnum(SexEnum.Male);
        employees.add(employee);

        employee = new Employee();
        employee.setRealName("清水");
        employee.setSexEnum(SexEnum.Male);
        employees.add(employee);

        employee = new Employee();
        employee.setRealName("周茹");
        employee.setSexEnum(SexEnum.Female);
        employees.add(employee);
        for (Employee employee1 : employees)
        {
            employeeMapper.insert(employee1);
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void select()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        EmployeeMapper employeeMapper1 = sqlSession1.getMapper(EmployeeMapper.class);
        Employee employee = employeeMapper.getEmployee(1);
        logger.info(employee.getRealName());
        sqlSession.commit();
        logger.info(employeeMapper1.getEmployee(1).getRealName());
//        if (!employee.getEmployeeTaskList().isEmpty())
//        {
//            EmployeeTask employeeTask = employee.getEmployeeTaskList().get(0);
//            System.out.println(employeeTask.getTaskName());
//        } else
//        {
//            logger.info("没有任务表");
//        }
//        if (((MaleEmployee) employee).getMaleHealthForm() != null)
//            logger.info(((MaleEmployee) employee).getMaleHealthForm().getProstate());
//        else
//        {
//            logger.info("没有健康体检表");
//        }
    }
}
