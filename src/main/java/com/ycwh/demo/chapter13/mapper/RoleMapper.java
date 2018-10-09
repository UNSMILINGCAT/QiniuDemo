package com.ycwh.demo.chapter13.mapper;

import com.ycwh.demo.chapter13.pojo.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper
{
    public int insertRole(Role role);
}
