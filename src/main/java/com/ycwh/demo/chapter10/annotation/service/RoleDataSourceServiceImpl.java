package com.ycwh.demo.chapter10.annotation.service;

import com.ycwh.demo.chapter10.Role;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class RoleDataSourceServiceImpl implements RoleDataSourceService
{
    @Autowired
    @Qualifier(value = "dataSource")
    DataSource dataSource = null;

    @Override
    public Role getRole(int id)
    {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Role role = null;
        try
        {
            conn = dataSource.getConnection();

            ps = conn.prepareStatement("select id,role_name,note from t_role where id=?");
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next())
            {
                role = new Role();
                role.setId(rs.getInt("id"));
                role.setRoleName(rs.getString("role_name"));

                role.setNote(rs.getString("note"));
            }
        } catch (SQLException e)
        {
            e.printStackTrace();
        } finally
        {
        }

        return role;
    }
}
