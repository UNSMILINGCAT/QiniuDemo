package com.ycwh.demo.chapter12.main;

import com.ycwh.demo.chapter11.game.pojo.Role;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Main
{
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter10/spring-dataSource.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        int id = 1;
        String sql = "select id,role_name,note from ssm.t_role where id=" + id;
        Role role = jdbcTemplate.queryForObject(sql, (resultSet, rownum) ->
        {
            Role result = new Role();
            result.setId(resultSet.getInt("id"));
            result.setRoleName(resultSet.getString(2));
            result.setNote(resultSet.getString(3));
            return result;

        });
        System.out.println(role.getRoleName());
    }
}
