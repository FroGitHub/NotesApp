package org.example.classesDB;

import org.example.objects.User_as_object;

import java.sql.*;

public class UserDB implements IDB {

        public void createUser(String username, String password) {
            String sql = "INSERT INTO user_table (name_user, password_user) VALUES (?, ?)";

            try (Connection connection = DriverManager.getConnection(jdbcUrl, this.username, this.password);
                 PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);

                try {
                    preparedStatement.executeUpdate();
                    System.out.println("User registered successfully");
                } catch (SQLException e){
                    System.out.println("This name already exists");
                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    public User_as_object selectUser(String name) {
        User_as_object user = new User_as_object();

        String sql = "SELECT id_user, name_user, password_user FROM user_table WHERE name_user = ?";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, this.username, this.password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) { // connection to MySQL

            preparedStatement.setString(1, name); // WHERE name_user = name

            try (ResultSet resultSet = preparedStatement.executeQuery()) { // get object
                if (resultSet.next()) {
                    user.setId(resultSet.getInt("id_user"));
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

