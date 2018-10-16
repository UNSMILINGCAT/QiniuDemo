package com.ycwh.demo.chapter14.mapper;

import com.ycwh.pojo.Role;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper
{
    int insert(Role role);

    Role getRole(int id);

    List<Role> findRoles(Role role);
}
