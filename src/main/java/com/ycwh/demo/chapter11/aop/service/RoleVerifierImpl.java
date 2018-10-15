package com.ycwh.demo.chapter11.aop.service;

import com.ycwh.pojo.Role;

public class RoleVerifierImpl implements RoleVerifier
{
    @Override
    public boolean verify(Role role)
    {
        return role != null;
    }
}
