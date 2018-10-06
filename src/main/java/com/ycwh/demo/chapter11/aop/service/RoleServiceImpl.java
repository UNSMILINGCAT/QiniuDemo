package com.ycwh.demo.chapter11.aop.service;

import com.ycwh.demo.chapter11.game.pojo.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleServiceImpl implements RoleService
{
    @Override
    public void printRole(Role role)
    {
        System.out.println("{id: " + role.getId() + "，role_name: " + role.getRoleName() + "，note: " + role.getNote()
                + "}");
    }
}
