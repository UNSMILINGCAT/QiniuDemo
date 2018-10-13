package com.ycwh.demo.chapter14.controller;

import com.sun.istack.internal.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


//注解@Controller表示它是一个控制器
@Controller("myController")
//表明当请求的URI在/my下的时候才有该控制器响应
@RequestMapping("/")
public class MyController
{
    Logger logger=Logger.getLogger(this.getClass());
    //表明URI是/index的时候该方法才请求
    @RequestMapping(value = "/index")
    public ModelAndView index(@RequestParam(value = "id",defaultValue = "") Long id)
    {
        logger.info(id+"");
        //模型和视图
        ModelAndView mv = new ModelAndView();
        //视图逻辑名称为index
        mv.setViewName("index");
        return mv;
    }
}
