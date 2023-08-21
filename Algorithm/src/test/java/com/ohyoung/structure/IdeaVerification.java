package com.ohyoung.structure;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Serializable;
import java.text.MessageFormat;
import java.util.*;

/**
 * @author ohYoung
 * @date 2020/12/8 11:23
 */
public class IdeaVerification implements Serializable{

    private static final Long serialVersionUID = 1L;

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
        String str = "{0}:{1}:{2}:{3}:{4}";
        String pattern = "\\:\\{[^}]*\\}";
        String format = MessageFormat.format(str, "a", "b", "c");

        System.out.println(format);
        System.out.println(format.replaceAll(pattern, ""));
    }

    @Test
    public void custom() {
        String meterNo = "663超长的仪表表号123超长的仪表表号123超长的仪表表号123超长的仪表表号123超长的仪表表号123超长的仪表表号123超长的仪表表号123超长的仪表表号123超长的仪表表号663超长的仪表表号123超长的仪表表号123超长的仪表表号123超长的仪表表号123超长的仪表表号123超长的仪表表号123超长的仪表表号123超长的仪表表号123超长的仪表表号";
        System.out.println(meterNo.length());
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

    class Custom implements Serializable{

        private static final long serialVersionUID = 1L;

        public Custom() {

        }
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

    @Test
    void testOOM() {
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("Max memory: " + maxMemory / 1024 / 1024 + "MB");


        List<byte[]> list = new ArrayList<>();
        int index = 0;
        try {
            while (true) {
                System.out.println(index++);;
                list.add(new byte[1024 * 1024 * 1024]); // 每次添加1GB的byte数组
            }
        } catch (OutOfMemoryError e) {
            System.out.println("Caught OutOfMemoryError: " + e.getMessage());
        }
    }

    @Test
    void ObjectSize()  throws IOException {
        Integer x = null;
        System.out.println(x == 1);
    }

}

















































 







































