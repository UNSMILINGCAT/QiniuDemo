package com.ycwh.demo.chapter10.annotation.comfig;

import com.ycwh.demo.chapter10.Role;
import com.ycwh.demo.chapter10.annotation.service.RoleDataSourceService;
import com.ycwh.demo.chapter10.annotation.service.RoleDataSourceServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@ComponentScan(basePackages = {"com.ycwh.demo.chapter10.annotation"})
@ImportResource(locations = {"classpath:chapter10/spring-dataSource.xml"})
public class ApplicationConfig
{

    public void testConnection()
    {
        ClassPathXmlApplicationContext cfx = new ClassPathXmlApplicationContext("chapter10/spring-dataSource.xml");
        DataSource dataSource = (DataSource) cfx.getBean("dataSource");
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try
        {
            connection = dataSource.getConnection();
            ps = connection.prepareStatement("select * from t_role");
            rs = ps.executeQuery();
            while (rs.next())
            {
                System.out.println(rs.getString("role_name"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
            try
            {
                rs.close();
                ps.close();
                connection.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void test()
    {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        RoleDataSourceService roleDataSourceService = (RoleDataSourceService) applicationContext.getBean
                ("roleDataSourceServiceImpl");
        Role role = roleDataSourceService.getRole(1);
        System.out.println(role.getRoleName());
    }
}
