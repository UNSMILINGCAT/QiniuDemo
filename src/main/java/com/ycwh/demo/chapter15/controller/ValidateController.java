package com.ycwh.demo.chapter15.controller;

import com.ycwh.demo.chapter15.validator.TradeFormValidator;
import com.ycwh.pojo.TradeForm;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;
import java.lang.reflect.Field;
import java.util.List;

@Controller
public class ValidateController
{
    Logger logger = Logger.getLogger(this.getClass());

    @InitBinder
    public void initBinder(DataBinder binder)
    {
        binder.setValidator(new TradeFormValidator());
    }

    @RequestMapping("/validate")
    public ModelAndView annotationValidate(@Valid TradeForm form, Errors errors)
    {
        ModelAndView mv = new ModelAndView();
        Class cs = form.getClass();
        for (Field field : cs.getDeclaredFields())
        {
            if (field.isAnnotationPresent(Pattern.class))
            {
                Pattern pattern = field.getAnnotation(Pattern.class);
                logger.info(pattern.regexp());
            }
        }
        logger.info(form.getEmail());
        if (errors.hasErrors())
        {
            //获取错误信息
            List<FieldError> errorList = errors.getFieldErrors();
            for (FieldError fieldError : errorList)
            {
                logger.info("fied: " + fieldError.getField() + "\n" +
                        "msg: " + fieldError.getDefaultMessage());
            }
            return null;
        }
        mv.setViewName("index.jsp");
        return mv;
    }
}
