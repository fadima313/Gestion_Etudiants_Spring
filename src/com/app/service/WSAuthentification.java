package com.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class WSAuthentification {
    // Les détails de connexion à la bd
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/authentification";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "";

    public boolean validate(String login, String password) {
               try (Connection connection = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
                       String sql = "SELECT COUNT(*) FROM T_Users WHERE login = ? AND password = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, login);
                statement.setString(2, password);

               
                try (ResultSet resultSet = statement.executeQuery()) {
                   
                    return resultSet.next() && resultSet.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
