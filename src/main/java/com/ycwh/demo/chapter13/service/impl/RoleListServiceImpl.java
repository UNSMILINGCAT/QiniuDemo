package com.ycwh.demo.chapter13.service.impl;

import com.ycwh.demo.chapter13.service.RoleListService;
import com.ycwh.demo.chapter13.service.RoleService;
import com.ycwh.pojo.Role;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleListServiceImpl implements RoleListService
{
    Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private RoleService roleService = null;

    @Transactional(propagation = Propagation.REQUIRES_NEW, isolation = Isolation.READ_COMMITTED)
    @Override
    public int insertRoleList(List<Role> roleList)
    {
        int count = 0;
        for (Role role : roleList)
        {
            try
            {
                count += roleService.insertRole(role);
            } catch (Exception e)
            {
                logger.info(e);
            }
        }
        return count;
    }
}
