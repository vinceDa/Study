package com.ohyoung.structure;

import cn.hutool.core.convert.Convert;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import org.junit.Test;

import java.util.*;

/**
 * @author ohYoung
 * @date 2020/12/8 11:23
 */
public class IdeaVerification {

    @Test
    public void linkedHashMap() {
        // 10是初始大小，0.75是装载因子，true是表示按照访问时间排序
        Map<Integer, Integer> map = new LinkedHashMap<>(10, 0.75f, true);
        map.put(3, 11);
        map.put(1, 22);
        map.put(5, 33);
        map.put(2, 44);

        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println(entry.getKey());
        }

        map.put(3, 55);
        map.get(5);

        entries = map.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            System.out.println(entry.getKey());
        }
    }

    @Test
    public void cs() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.getFirst();

    }

    @Test
    public void test() {
        int a = 1;
        int b = 2;
        reverse(a, b);
    }

    private void reverse(int a, int b) {
        int t = -1;
        t = a;
        a = b;
        b = t;
        System.out.println(a + "  " + b);
    }

    private void getPath(Custom custom, String path) {

    }

    class Custom{
        private String name;

        private String value;

        private List<Custom> children;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public List<Custom> getChildren() {
            return children;
        }

        public void setChildren(List<Custom> children) {
            this.children = children;
        }
    }

}

















































 







































