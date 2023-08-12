package org.example;

import java.sql.*;


public class UserDB {

        String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/notesappdb"; // URL підключення до бази даних
        private String username = "root"; // Ім'я користувача бази даних
        private String password = "fdpgsp2425SS"; // Пароль бази даних

        public void createUser(String username, String password) {
            String sql = "INSERT INTO user_table (name_user, password_user) VALUES (?, ?)";

            try (Connection connection = DriverManager.getConnection(jdbcUrl, this.username, this.password);
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                preparedStatement.executeUpdate();
                System.out.println("User registered successfully.");

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    public User_as_object selectUser(String name) {
        User_as_object user = new User_as_object();

        String sql = "SELECT name_user, password_user FROM user_table WHERE name_user = ?";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, this.username, this.password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    user.setUsername(resultSet.getString("name_user"));
                    user.setPassword(resultSet.getString("password_user"));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

}
