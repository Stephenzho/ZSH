package io.stephen.test.jdbc;


import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * JDBC链接测试
 *
 * @author 10447
 * @since 2018/2/24
 */
public class jdbc {
    static BasicDataSource bds = null;

    static final String create = "create table UserConnection (userId varchar(255) not null,\n" +
            "\tproviderId varchar(255) not null,\n" +
            "\tproviderUserId varchar(255),\n" +
            "\trank int not null,\n" +
            "\tdisplayName varchar(255),\n" +
            "\tprofileUrl varchar(512),\n" +
            "\timageUrl varchar(512),\n" +
            "\taccessToken varchar(512) not null,\n" +
            "\tsecret varchar(512),\n" +
            "\trefreshToken varchar(512),\n" +
            "\texpireTime bigint,\n" +
            "\tprimary key (userId, providerId, providerUserId));";

    static final String inset = "insert into UserConnection  (userId ,providerId, providerUserId, accessToken,rank) " +
            "values (?,?,?,?,?)";



    public static void init() {
        bds = new BasicDataSource();
        bds.setUrl("jdbc:mysql://180.76.237.201:3306/zsh?useUnicode=true&characterEncoding=utf8");
        bds.setUsername("root");
        bds.setPassword("zhou@104477");
        bds.setInitialSize(1);
        bds.setMaxActive(2);
    }


    public static void main(String[] args) throws SQLException {
        init();

        Connection connection = bds.getConnection();
        connection.setAutoCommit(false);

        try {


            String select = "select * from UserConnection ";

            PreparedStatement ps = connection.prepareStatement(select);

            ResultSet result = ps.executeQuery();


            while (result.next()) {

                System.out.println(result.getInt("userId"));

            }


            connection.commit();
            connection.setAutoCommit(true);
        } catch (Exception e) {

            connection.rollback();

        } finally {
            connection.close();
        }

    }
}
