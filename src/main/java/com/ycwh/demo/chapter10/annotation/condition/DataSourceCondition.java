package com.ycwh.demo.chapter10.annotation.condition;


import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class DataSourceCondition implements Condition
{
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata)
    {
        Environment environment = conditionContext.getEnvironment();
        return environment.containsProperty("jdbc.driver") &&
                environment.containsProperty("jdbc.url") &&
                environment.containsProperty("jdbc.username") &&
                environment.containsProperty("jdbc.password");
    }
}
