package com.ycwh.demo.chapter14.controller;

import com.sun.istack.internal.logging.Logger;
import com.ycwh.demo.chapter14.service.RoleService;
import com.ycwh.pojo.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.List;


//注解@Controller表示它是一个控制器
@Controller("myController")
@RequestMapping("/")
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

    @RequestMapping("/role/{id}")
    public ModelAndView getRole(@PathVariable("id") int id)
    {
        Role role = roleService.getRole(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("role", role);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("param")
    public ModelAndView getParam(Role role)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("param.jsp");
        logger.info(role.getRoleName());
        logger.info(role.getNote());
        return mv;
    }

    @RequestMapping("/findRoles")
    public ModelAndView findRoles(@RequestBody Role role)
    {
        List<Role> roleList = roleService.findRoles(role);
        ModelAndView mv = new ModelAndView();
        mv.addObject(roleList);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("/addRoles")
    public ModelAndView addRoles(@RequestBody List<Role> roleList)
    {
        ModelAndView mv = new ModelAndView();
        //添加角色
        int total = roleService.insertRoles(roleList);
        mv.addObject("total", total);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("/commonParamPojo2")
    public ModelAndView commonParamPojo2(String roleName, String note)
    {
        logger.info("roleName =>" + roleName);
        logger.info("note =>" + note);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index.jsp");
        return mv;
    }

    @RequestMapping("/showRoleJsonInfo")
    public ModelAndView showRoleJsonInfo(int id, String roleName, String note)
    {
        ModelAndView mv = new ModelAndView();
        mv.addObject("id", id);
        mv.addObject("roleName", roleName);
        mv.addObject("note", note);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("/addRole")
    public String addRole(Model model, String roleName, String note)
    {
        Role role = new Role();
        role.setRoleName(roleName);
        role.setNote(note);
        //插入角色后，会回填角色编号
        roleService.insertRole(role);
        //绑定重定向数据模型
        model.addAttribute("roleName", roleName);
        model.addAttribute("note", note);
        model.addAttribute("id", role.getId());
        return "redirect:/showRoleJsonInfo.do";
    }

    @RequestMapping("/requestAttribute")
    public ModelAndView requestAttr(@RequestAttribute(value = "id", required = false) int id)
    {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.getRole(id);
        mv.addObject("role", role);
        mv.setView(new MappingJackson2JsonView());
        return mv;
    }

    @RequestMapping("/sessionAttribute")
    public ModelAndView sessionAttribute(@SessionAttribute("id") int id)
    {
        ModelAndView mv = new ModelAndView();
        Role role = roleService.getRole(id);
        mv.addObject("role", role);
        mv.addObject("id", id);
        mv.setViewName("sessionAttribute.jsp");
        return mv;
    }

    @RequestMapping("/getRoleByModelMap")
    public ModelAndView getRoleByModelMap(@RequestParam("id") int id, ModelMap modelMap)
    {
        Role role=roleService.getRole(id);
        ModelAndView mv=new ModelAndView();
        mv.setView(new MappingJackson2JsonView());
        modelMap.addAttribute("role",role);
        return mv;
    }
}
