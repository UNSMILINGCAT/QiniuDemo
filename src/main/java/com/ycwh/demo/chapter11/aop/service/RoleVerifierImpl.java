package com.ycwh.demo.chapter11.aop.service;

import com.ycwh.demo.chapter11.game.pojo.Role;

public class RoleVerifierImpl implements RoleVerifier
{
    @Override
    public boolean verify(Role role)
    {
        return role != null;
    }
}
