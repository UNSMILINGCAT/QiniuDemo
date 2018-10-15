package com.ycwh.demo.chapter14.mapper;

import com.ycwh.pojo.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleMapper
{
    Role getRole(int id);
}
