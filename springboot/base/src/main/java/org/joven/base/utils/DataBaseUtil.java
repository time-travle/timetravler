/**
 * Project Name: time-travle.github.io
 * File Name: DataBaseUtil
 * Package Name: org.joven.base.utils
 * Date: 2020/5/3 19:03
 * Copyright (c) 2020,All Rights Reserved.
 */
package org.joven.base.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * CreateBy Administrator
 * Date: 2020/5/3 19:03
 * Version:1.0
 * Remark:
 */
public class DataBaseUtil {
    public static Map<String, Connection> conns = new HashMap<String, Connection>();

    public DataBaseUtil() {
    }

    public DataBaseUtil(String dataBaseName, String password, String userName) {
        conns.put(dataBaseName, getConnect(dataBaseName, password, userName));
    }

    public static Connection getConn(String dataBaseName) {
        return conns.get(dataBaseName);
    }

    public static Connection getConnect(String dataBaseName, String password, String userName) {
        Connection conn = null;
        if (conns.get(dataBaseName) != null) {
            return conns.get(dataBaseName);
        }
        try {
            String url = "jdbc:mysql://localhost:3306/+" + dataBaseName +
                    "+?autoReconnect=true&useUnicode=true&createDatabaseIfNotExist=true" +
                    "&characterEncoding=utf8&useSSL=true&serverTimezone=UTC";
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, userName, password);
            conns.put(dataBaseName, conn);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void close(String dataBaseName) {
        if (conns.get(dataBaseName) != null) {
            try {
                conns.get(dataBaseName).close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
