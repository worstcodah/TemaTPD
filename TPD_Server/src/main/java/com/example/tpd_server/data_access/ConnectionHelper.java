package com.example.tpd_server.data_access;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionHelper {
    private static final String url = "jdbc:postgresql://34.116.151.224:5432/tema-orm:europe-central2:tema-orm-db/postgres";
    private static final String user = "postgres";
    private static final String password = "postgres";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(ConnectionHelper.url, ConnectionHelper.user, ConnectionHelper.password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
