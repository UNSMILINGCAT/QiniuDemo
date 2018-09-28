package com.ycwh.test.demo.chapter10;

import com.ycwh.demo.chapter10.Role;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.ArrayList;
import java.util.List;

public class ExpressionTest
{
    @Value("#{T(Math).random()}")
    private double random;

    @Test
    public void test()
    {
        Role role = new Role("王林", "???");
        ExpressionParser parser = new SpelExpressionParser();
        Expression expression = parser.parseExpression("note");
        String note = (String) expression.getValue(role);
        System.out.println(note);
        EvaluationContext ctx = new StandardEvaluationContext(role);
        parser.parseExpression("note").setValue(role, "new_note");
        note = parser.parseExpression("note").getValue(ctx, String.class);
        System.out.println(note);
        String roleName = parser.parseExpression("roleName").getValue(role, String.class);
        System.out.println(roleName);
        List<String> list = new ArrayList<String>();
        list.add("value1");
        list.add("value2");
        ctx.setVariable("list", list);
        parser.parseExpression("#list[1]").setValue(ctx, "update_value2");
        System.out.println(parser.parseExpression("#list[1]").getValue(ctx));
        System.out.println(random);
    }
}
