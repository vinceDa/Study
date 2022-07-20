package com.ohyoung;

import org.springframework.expression.EvaluationContext;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.common.TemplateParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ouyb01
 * @date 2022/6/29 10:24
 */
public class CustomFunctionExample {

    public static void main(String[] args) throws NoSuchMethodException {
        ExpressionParser parser = new SpelExpressionParser();
        Inventor inventor = new Inventor("1", null, "2");
        StandardEvaluationContext context = new StandardEvaluationContext(inventor);
        System.out.println("test: " + parser.parseExpression("name").getValue(context));
        Map<String, Object> map = new HashMap<>();
        map.put("id", "id1");
        map.put("name", "name1");
        context = new StandardEvaluationContext(map);
        System.out.println("test: " + parser.parseExpression("map['name']").getValue(context));
    }

}
