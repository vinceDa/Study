package com.ohyoung;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *  Spring JdbcTemplate使用样例
 * @author ohYoung
 * @date 2020/11/24 22:32
 */
public class JdbcTemplateDemo {

    private static final JdbcTemplate JDBC_TEMPLATE = new JdbcTemplate();


    public static void main(String[] args) {
        init();
        updateSingleWithUpdate();
        /*JDBC_TEMPLATE.execute();
        JDBC_TEMPLATE.query();
        JDBC_TEMPLATE.batchUpdate();
        JDBC_TEMPLATE.batchUpdate();
        JDBC_TEMPLATE.call();*/
    }

    /**
     *  使用update(sql, Objects... args)方式添加数据
     */
    private static void insertSingleWithUpdate() {
        String sql = "insert into user(username, password, phone, email) values(?,?,?,?)";
        JDBC_TEMPLATE.update(sql, "testUserName1", "testPassword1", "13713729112", "vincedavince1@163.com");
    }

    /**
     *  使用update(sql, Objects... args)方式更新数据
     */
    private static void updateSingleWithUpdate() {
        String sql = "update user set username = ?, password = ?, phone = ?, email = ? where id = ?";
        JDBC_TEMPLATE.update(sql, "xx", "yy", "13713729112", "zz@163.com", 36);
    }



    private static void init() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/study_jdbc_template?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false");
        JDBC_TEMPLATE.setDataSource(dataSource);
    }


}
