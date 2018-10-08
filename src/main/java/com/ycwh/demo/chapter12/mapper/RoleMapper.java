package com.ycwh.demo.chapter12.mapper;

import com.ycwh.demo.chapter12.pojo.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper
{
    public void insertRole(Role role);
}
