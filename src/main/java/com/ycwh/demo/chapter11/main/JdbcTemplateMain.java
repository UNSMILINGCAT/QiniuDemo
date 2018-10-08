package com.ycwh.demo.chapter11.main;

import com.mysql.cj.jdbc.SuspendableXAConnection;
import com.ycwh.demo.chapter11.game.pojo.Role;
import org.apache.ibatis.executor.statement.RoutingStatementHandler;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class JdbcTemplateMain
{
    public static void main(String[] args)
    {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("chapter10/spring-dataSource.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean(JdbcTemplate.class);
        JdbcTemplateMain main = new JdbcTemplateMain();
        List<Role> list = main.findRole(jdbcTemplate);
        System.out.println(list.size());
        for (Role role : list)
        {
            System.out.println(role.getRoleName() + " ");
        }
        Role role = main.getRoleByConnectionCallback(jdbcTemplate);
        System.out.println(role.getRoleName());
    }

    /**
     * 插入角色
     *
     * @param jdbcTemplate
     * @return
     */
    public int insertRole(Role role, JdbcTemplate jdbcTemplate)
    {
        String sql = "insert into t_role(role_name,note) values(?,?)";
        return jdbcTemplate.update(sql, role.getRoleName(), role.getNote());
    }

    /**
     * 删除角色
     *
     * @param roleName
     * @param jdbcTemplate
     * @return
     */
    public int deleteRole(String roleName, JdbcTemplate jdbcTemplate)
    {
        String sql = "delete from t_role where role_name=?";
        return jdbcTemplate.update(sql, roleName);
    }

    /**
     * 更新数据
     *
     * @param role
     * @param jdbcTemplate
     * @return
     */
    public int updateRole(Role role, JdbcTemplate jdbcTemplate)
    {
        String sql = "update t_role set role_name=? ,note=? where id=?";
        return jdbcTemplate.update(sql, role.getRoleName(), role.getNote(), role.getId());
    }

    /**
     * 查询角色列表
     *
     * @param jdbcTemplate
     * @return
     */
    public List<Role> findRole(JdbcTemplate jdbcTemplate)
    {
        String sql = "select * from t_role";
        List<Role> list = jdbcTemplate.query(sql, (resultSet, i) ->
        {
            Role result = new Role();
            result.setRoleName(resultSet.getString("role_name"));
            result.setNote(resultSet.getString("note"));
            return result;
        });
        return list;
    }

    /**
     * 使用connectionCallback接口进行回调
     *
     * @param jdbcTemplate
     * @return
     */
    public Role getRoleByConnectionCallback(JdbcTemplate jdbcTemplate)
    {
        Role role = null;
        role = jdbcTemplate.execute((Connection connection) ->
        {
            Role result = null;
            String sql = "select * from t_role";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                result = new Role();
                result.setRoleName(rs.getString("role_name"));
            }
            return result;
        });
        return role;
    }

    /**
     * 使用StatementCallback接口进行回调
     *
     * @param jdbcTemplate
     * @return
     */
    public Role getRoleByStatementCallback(JdbcTemplate jdbcTemplate)
    {
        Role role = null;
        role = jdbcTemplate.execute((Statement statement) -> {
            Role role1 = null;
            String sql = "select * from t_role";
            ResultSet resultSet = statement.executeQuery(sql);

            return null;
        });
        return null;
    }
}
