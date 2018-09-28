package com.ycwh.demo.chapter10.el;

import com.ycwh.demo.chapter10.Role;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "elBean")
public class ELBean
{
    //通过beanName获取bean，然后注入
    @Value("#{role}")
    private Role role;

    //获取bean的属性id
    @Value("#{role.id}")
    private int id;

    //调用bean的getNote方法，获取角色名称
    @Value("#{role.getNote()?.toString()}")
    private String roleName;

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getRoleName()
    {
        return roleName;
    }

    public void setRoleName(String roleName)
    {
        this.roleName = roleName;
    }
}
