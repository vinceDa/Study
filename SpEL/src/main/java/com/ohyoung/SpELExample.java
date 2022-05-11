package com.ohyoung;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author ohYoung
 * @date 2022/1/30 14:51
 */
public class SpELExample {

    public static void main(String[] args) {
        ExpressionParser parser = new SpelExpressionParser();
        // 基本用法
        Expression expression = parser.parseExpression("'Hello World'");
        System.out.println(expression.getValue());

        // 可以使用Java方法
        expression = parser.parseExpression("'Hello World'.concat('!')");
        System.out.println(expression.getValue());

        // 调用JavaBean的属性, 例如String的属性'Bytes'
        expression = parser.parseExpression("'Hello world'.bytes");
        byte[] value = (byte[]) expression.getValue();
        System.out.println("value: " + value);

        // 使用标准的.符号调用属性, 例如i.e.prop1.prop2.prop3
        expression = parser.parseExpression("'Hello world'.bytes.length");
        System.out.println(expression.getValue());

        expression = parser.parseExpression("new String ('hello world').toUpperCase()");
        System.out.println(expression.getValue());

        // 获取对象中的属性, 方式1: 通过EvaluationContext的方式
        GregorianCalendar c = new GregorianCalendar();
        c.set(1856, 7, 9);
        Inventor inventor = new Inventor("Nikola Tesla", c.getTime(), "Serbian");
        EvaluationContext context = new StandardEvaluationContext(inventor);
        expression = parser.parseExpression("name");
        System.out.println("nameByContext: " + expression.getValue(context));

        // 获取对象中的属性, 方式1: 直接设置对象
        System.out.println("nameByObject: " + expression.getValue(inventor));

        System.out.println("获取对象的属性值: " + parser.parseExpression("name").getValue(inventor));
        // 使用对象中的属性做比对
        expression = parser.parseExpression("name == 'Nikola Tesla'");
        System.out.println(expression.getValue(inventor, Boolean.class));


        Simple simple = new Simple();
        simple.booleanList.add(true);
        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext(simple);
        parser.parseExpression("booleanList[0]").setValue(standardEvaluationContext, "false");
        System.out.println(simple.booleanList.get(0));

        System.out.println(parser.parseExpression("Birthdate.getYear() + 1900").getValue(context));

        // 需要被SpEl解析的模板前缀和后缀 {{ expression  }}
        TemplateParserContext fix = new TemplateParserContext("{{", "}}");
        StandardEvaluationContext fixContext = new StandardEvaluationContext();
        fixContext.setVariable("inventor", inventor);
        System.out.println("fix: " + parser.parseExpression("#inventor.name, haha", fix).getValue(fixContext));;

    }

    private static String customerFun(String string) {
        return "customerFun" + string;
    }

}
