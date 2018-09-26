package com.ycwh.demo.chapter9;

import com.ycwh.demo.chapter9.pojo.JuiceMaker2;
import com.ycwh.demo.chapter9.pojo.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackageClasses = {JuiceMaker2.class})
public class Test
{
//    @Autowired
//    @Qualifier("juiceMaker2")
//    JuiceMaker2 juiceMaker2 = null;

    public void test()
    {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Test.class);
        JuiceMaker2 juiceMaker2 = (JuiceMaker2) ctx.getBean("juiceMaker2");
        System.out.println(juiceMaker2.makeJuice());
        if (juiceMaker2 != null)
        {
            System.out.println(juiceMaker2.getSource().getFruit());
        } else
        {
            System.out.println("NULL");
        }
    }

    @Bean(name = "juiceMaker2", initMethod = "init", destroyMethod = "destroy")
    public JuiceMaker2 initJuiceMaker2()
    {
        JuiceMaker2 juiceMaker2 = new JuiceMaker2();
        juiceMaker2.setBeverageShop("贡茶");
        Source source = new Source();
        source.setFruit("橙子");
        source.setSize("大杯");
        source.setSugar("少糖");
        juiceMaker2.setSource(source);
        return juiceMaker2;
    }

//    public JuiceMaker2 getJuiceMaker2()
//    {
//        return juiceMaker2;
//    }
}
