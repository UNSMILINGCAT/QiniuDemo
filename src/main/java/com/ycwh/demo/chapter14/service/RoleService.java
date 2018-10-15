package com.ycwh.demo.chapter14.service;

import com.ycwh.demo.chapter14.mapper.RoleMapper;
import com.ycwh.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService
{
    @Autowired()
    RoleMapper roleMapper = null;

    public Role getRole(int id)
    {
        return roleMapper.getRole(id);
    }
}
