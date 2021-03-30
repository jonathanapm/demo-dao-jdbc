package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConnection {

    private static Connection conn = null;

    public static Connection getConnection() {

        if (conn == null) {
            try {
                Properties properties = lodProperties();
                String url = properties.getProperty("dburl");

                //Obtendo conexão com o banco e salvando na variável
                conn = DriverManager.getConnection(url, properties);
            } catch (SQLException ex) {
                throw new DbException(ex.getMessage());
            }
        }

        return conn;
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                /**
                 * O SQLException é derivado de exception, ou seja é obrigatório o tratamento,
                 * já a DbException é derivada da RuntimeException, ou seja o programa não é obrigado a sempre
                 * inserir try catch, somente quando necessário
                 */
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeResultSet(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        }catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    private static Properties lodProperties() {
        //Recuperando dados do arquivo db.properties
        try (FileInputStream fs = new FileInputStream("db.properties")) {
            Properties properties = new Properties();
            properties.load(fs);
            return properties;
        } catch (IOException e) {
            throw new DbException(e.getMessage());
        }
    }
}
