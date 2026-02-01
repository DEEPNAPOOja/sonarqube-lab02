package com.example; 


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    // Use environment variables for credentials
    private String dbUser = System.getenv("DB_USER");
    private String dbPassword = System.getenv("DB_PASSWORD");

    // Use PreparedStatement to prevent SQL Injection
    public void findUser(String username) throws SQLException {

        // Explicitly list columns instead of SELECT *
        String query = "SELECT id, name, email, phone FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db", dbUser, dbPassword);
             PreparedStatement st = conn.prepareStatement(query)) {

            st.setString(1, username);

            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");

                    logger.info("Found user: id={}, name={}, email={}, phone={}", id, name, email, phone);
                }
            }

        } catch (SQLException e) {
            logger.error("Error finding user: {}", username, e);
            throw e; // propagate specific exception
        }
    }
}
