package com.amazon.db;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.slf4j.Logger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Connections {
    private static HikariDataSource dataSource;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/logsdb");
        config.setUsername("root");
        config.setPassword("");
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");

        config.setMaximumPoolSize(10);
        config.setMinimumIdle(5);
        config.setConnectionTimeout(30000);
        config.setIdleTimeout(600000);
        config.setMaxLifetime(1800000);

        dataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // Método que lee los valores de una columna específica
    public static List<String> leerValoresDeColumna() {
        String sql = "SELECT busqueda FROM busquedas";
        List<String> valores = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String value = resultSet.getString("busqueda");
                valores.add(value);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return valores;
    }

    public static void logToBD(String level, Logger logge, String message, String thread) {
        try (Connection connection = dataSource.getConnection()) {
            String sql = "INSERT INTO logs (level, logger, message, thread) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {

                statement.setString(1, level);
                statement.setString(2, logge.getName());
                statement.setString(3, message);
                statement.setString(4, thread);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


