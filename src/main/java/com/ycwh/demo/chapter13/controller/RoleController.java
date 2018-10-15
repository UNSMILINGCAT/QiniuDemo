package com.ycwh.demo.chapter13.controller;

import com.ycwh.demo.chapter13.service.RoleListService;
import com.ycwh.demo.chapter13.service.RoleService;
import com.ycwh.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RoleController
{
    @Autowired
    private RoleService roleService = null;
    @Autowired
    private RoleListService roleListService = null;

    public void errerUserService()
    {
        Role role1 = new Role();
        role1.setRoleName("role_name_1");
        role1.setNote("role_note_1");
        roleService.insertRole(role1);
        Role role2 = new Role();
        role2.setRoleName("role_name_2");
        role2.setNote("role_note_2");
        roleService.insertRole(role2);
    }
}
