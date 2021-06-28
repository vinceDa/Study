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
    private void cs() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.getFirst();

    }

    @Test
    public void test() {
        String json = "{\"children\":[{\"children\":[{\"children\":[{\"name\":\"京汉小学\",\"value\":\"16106068575330.3218\",\"parentId\":\"16106068537660.9558\"}],\"name\":\"江汉区\",\"value\":\"16106068537660.9558\",\"parentId\":\"16106068479100.0186\"},{\"children\":[{\"name\":\"吴昌小学\",\"value\":\"16106068955050.5509\",\"parentId\":\"16106068639990.8087\"}],\"name\":\"武昌区\",\"value\":\"16106068639990.8087\",\"parentId\":\"16106068479100.0186\"},{\"name\":\"黄皮\",\"value\":\"16106068708240.3853\",\"parentId\":\"16106068479100.0186\"}],\"name\":\"武汉市\",\"value\":\"16106068479100.0186\",\"parentId\":\"16106068255980.3450\"}],\"name\":\"湖北省\",\"value\":\"16106068255980.3450\",\"parentId\":\"__vue_devtool_undefined__\"},{\"children\":[{\"children\":[{\"name\":\"乐山市\",\"value\":\"16106069080550.6457\",\"parentId\":\"16106069012500.9335\"},{\"name\":\"成都市\",\"value\":\"16106069117450.0316\",\"parentId\":\"16106069012500.9335\"}],\"name\":\"四川省\",\"value\":\"16106069012500.9335\",\"parentId\":\"16106068312740.1505\"}],\"name\":\"四川省\",\"value\":\"16106068312740.1505\",\"parentId\":\"__vue_devtool_undefined__\"},{\"children\":[{\"name\":\"长沙市\",\"value\":\"16106069151880.7472\",\"parentId\":\"16106068342090.0860\"},{\"children\":[{\"name\":\"岳阳县\",\"value\":\"16106069230180.7436\",\"parentId\":\"16106069184520.0338\"}],\"name\":\"岳阳市\",\"value\":\"16106069184520.0338\",\"parentId\":\"16106068342090.0860\"}],\"name\":\"湖南省\",\"value\":\"16106068342090.0860\",\"parentId\":\"__vue_devtool_undefined__\"},{\"children\":[{\"name\":\"111\",\"value\":\"16106069294760.5381\",\"parentId\":\"16106068380210.4630\"},{\"name\":\"222\",\"value\":\"16106069321660.1689\",\"parentId\":\"16106068380210.4630\"},{\"children\":[{\"name\":\"1\",\"value\":\"16106069363550.1358\",\"parentId\":\"16106069339140.2558\"},{\"name\":\"2\",\"value\":\"16106069400490.2795\",\"parentId\":\"16106069339140.2558\"},{\"children\":[{\"name\":\"4\",\"value\":\"16106069439600.0618\",\"parentId\":\"16106069419720.0134\"},{\"name\":\"5\",\"value\":\"16106069456760.0429\",\"parentId\":\"16106069419720.0134\"},{\"name\":\"6\",\"value\":\"16106069494180.6395\",\"parentId\":\"16106069419720.0134\"}],\"name\":\"3\",\"value\":\"16106069419720.0134\",\"parentId\":\"16106069339140.2558\"}],\"name\":\"333\",\"value\":\"16106069339140.2558\",\"parentId\":\"16106068380210.4630\"}],\"name\":\"江西省\",\"value\":\"16106068380210.4630\",\"parentId\":\"__vue_devtool_undefined__\"}";
        Custom custom = JSONUtil.toBean(JSONUtil.parseObj(json), Custom.class);

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

















































 







































