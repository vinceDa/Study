package com.ohyoung.structure;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

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
        int[] a = new int[]{1, 2, 3, 4, 5};
        int[] b = new int[3];
        System.arraycopy(a, 0 ,  a,2, 2);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void custom() {
        System.out.println(0.1 + 0.2 == 0.3);
    }

    @Test
    public void test() {
        List<UUID> a = new ArrayList<>();
        a.add(null);
        System.out.println(a.isEmpty());
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

















































 







































