package com.ycwh.demo.chapter14.controller;

import com.sun.istack.internal.logging.Logger;
import com.ycwh.demo.chapter14.service.RoleService;
import com.ycwh.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;


//注解@Controller表示它是一个控制器
@Controller("myController")
//表明当请求的URI在/my下的时候才有该控制器响应
@RequestMapping("/")
//@ComponentScan(basePackages = {"com.ycwh.demo.chapter14.*"})
public class MyController
{
    Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private RoleService roleService = null;
    //表明URI是/index的时候该方法才请求
    @RequestMapping(value = "/index")
    public ModelAndView index()
    {
//        logger.info(userName+"");
        //模型和视图
        ModelAndView mv = new ModelAndView();
        //视图逻辑名称为index
        mv.setViewName("index.jsp");
        return mv;
    }

    @RequestMapping("/game")
    public ModelAndView game()
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("/2048.html");
        return mv;
    }

    @RequestMapping("/role")
    public ModelAndView getRole()
    {
        Role role = roleService.getRole(1);
        logger.info(role.getRoleName());
        ModelAndView mv = new ModelAndView();
        mv.addObject("role", role);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }
}
