package com.ohyoung;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *  Spring JdbcTemplate使用样例
 * @author ohYoung
 * @date 2020/11/24 22:32
 */
public class JdbcTemplateDemo {

    private static final JdbcTemplate JDBC_TEMPLATE = new JdbcTemplate();


    public static void main(String[] args) {
        init();
        // insertSingleWithUpdate();
        // System.out.println(insertSingleWithKey());
        batchInsert();
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
        JDBC_TEMPLATE.update(sql, "testUserName2", "testPassword2", "13713729113", "vincedavince2@163.com");
    }

    /**
     *  使用update(sql, object[], int[])方式添加数据
     *   object[]: 存储参数值
     *   int[]: 存储参数的类型, 两个数组中的元素要一一对应
     */
    private static void insertSingle() {
        String sql = "insert into user(username, password, phone, email) values(?,?,?,?)";
        JDBC_TEMPLATE.update(sql, new Object[]{"testUserName2", "testPassword2", "13713729113", "vincedavince2@163.com"},
                new int[]{Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR });
    }

    /**
     *  新增返回插入的主键
     */
    private static int insertSingleWithKey() {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        final String sql = "insert into user(username, password, phone, email) values(?,?,?,?)";
        JDBC_TEMPLATE.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                // 此处不加Statement.RETURN_GENERATED_KEYS会报错
                PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setObject(1, "testUserName3");
                preparedStatement.setObject(2, "testPassword3");
                preparedStatement.setObject(3, "13713729114");
                preparedStatement.setObject(4, "vincedavince3@163.com");

                return preparedStatement;
            }
        }, keyHolder);
        return keyHolder.getKey().intValue();
    }

    /**
     *  使用update(sql, Objects... args)方式更新数据
     */
    private static void batchInsert() {
        final List<UserEntity> userEntities = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            UserEntity userEntity = new UserEntity();
            userEntity.setUsername("username--" + i);
            userEntity.setPassword("password--" + i);
            userEntity.setEmail("email--" + i);
            userEntity.setPhone("phone--" + i);
            userEntities.add(userEntity);
        }
        String sql = "insert into user(username, password, phone, email) values(?,?,?,?)";
        int[] ints = JDBC_TEMPLATE.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                // 注入参数
                preparedStatement.setObject(1, userEntities.get(i).getUsername());
                preparedStatement.setObject(2, userEntities.get(i).getPassword());
                preparedStatement.setObject(3, userEntities.get(i).getPhone());
                preparedStatement.setObject(4, userEntities.get(i).getEmail());
            }

            @Override
            public int getBatchSize() {
                // 批量执行的数量
                return userEntities.size();
            }
        });
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     *  使用update(sql, Objects... args)方式更新数据
     */
    private static void updateSingleWithUpdate() {
        String sql = "update user set username = ?, password = ?, phone = ?, email = ? where id = ?";
        JDBC_TEMPLATE.update(sql, "xx", "yy", "13713729112", "zz@163.com", 36);
    }

    /**
     *  queryForObject查询单行多列, 使用rowMapper进行JavaBean和数据库字段之间的映射
     */
    private static void queryForObject() {
        RowMapper<UserEntity> rowMapper = new BeanPropertyRowMapper<>(UserEntity.class);
        String sql = "select * from user";
        UserEntity userEntity = JDBC_TEMPLATE.queryForObject(sql, rowMapper);
        System.out.println(userEntity.toString());
    }

    /**
     *  query查询多行多列, 使用rowMapper进行JavaBean和数据库字段之间的映射
     */
    private static void query() {
        RowMapper<UserEntity> rowMapper = new BeanPropertyRowMapper<>(UserEntity.class);
        String sql = "select * from user";
        List<UserEntity> user = JDBC_TEMPLATE.query(sql, rowMapper);
        for (UserEntity userEntity : user) {
            System.out.println(userEntity.toString());
        }
    }

    /**
     *  query查询多行单列
     */
    private static void queryForList() {
        String sql = "select username from user";
        List<String > usernames = JDBC_TEMPLATE.queryForList(sql, String.class);
        for (String username : usernames) {
            System.out.println(username);
        }
    }

    /**
     *
     */
    private static void query2() {
        String sql = "select * from user where username = ?";
        RowMapper<UserEntity> rowMapper = new BeanPropertyRowMapper<>(UserEntity.class);
        List<UserEntity> users = JDBC_TEMPLATE.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setObject(1, "testUserName2");
            }
        }, rowMapper);
        for (UserEntity user : users) {
            System.out.println(user.toString());
        }
    }



    private static void init() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://127.0.0.1:3306/study_jdbc_template?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8&useSSL=false");
        JDBC_TEMPLATE.setDataSource(dataSource);
    }


}
