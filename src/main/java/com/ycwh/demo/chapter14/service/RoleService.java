package com.ycwh.demo.chapter14.service;

import com.ycwh.demo.chapter14.mapper.RoleMapper;
import com.ycwh.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService
{
    @Autowired()
    RoleMapper roleMapper = null;

    public Role getRole(int id)
    {
        return roleMapper.getRole(id);
    }

    public List<Role> findRoles(Role role)
    {
        return roleMapper.findRoles(role);
    }

    public int insertRoles(List<Role> roleList)
    {
        int count = 0;
        for (Role role : roleList)
        {
            count += roleMapper.insert(role);
        }
        return count;
    }

    public int insertRole(Role role)
    {
        return roleMapper.insert(role);
    }
}
