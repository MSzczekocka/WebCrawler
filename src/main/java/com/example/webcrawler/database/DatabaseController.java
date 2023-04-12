package com.example.webcrawler.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseController {
    protected static final String URL = "org.h2.Driver";
    protected static final String USER = "";
    protected static final String PASS = "";
    public static String DB_URL = "jdbc:h2:file:./src/db";

    public static void createDB() throws Exception {
        Connection connection = getConnection();
        Statement statement = connection.createStatement();
        statement.execute("CREATE TABLE IF NOT EXISTS VISITEDURL(ID_VISITEDURL INT AUTO_INCREMENT NOT NULL UNIQUE PRIMARY KEY, URL_NAME VARCHAR(400) UNIQUE NOT NULL)");
        statement.close();
        connection.close();
    }

    public static Connection getConnection() throws Exception {
        Connection connection = DriverManager.getConnection(DB_URL, USER, PASS);
        connection.setAutoCommit(true);
        return connection;
    }
}
