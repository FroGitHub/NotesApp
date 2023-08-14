package org.example.classesDB;

import org.example.objects.Task_as_object;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TaskDB implements IDB {

    public void createTask(int id_user, String task) {
        String sql = "INSERT INTO task_table (id_user, task) VALUES (?, ?)";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, this.username, this.password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id_user);
            preparedStatement.setString(2, task);

            try {
                preparedStatement.executeUpdate();
                System.out.println("The task is added");
            } catch (SQLException e){
                System.out.println("Something is wrong with creation in db");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Task_as_object> selectTasks(int id_user) {

        List<Task_as_object> taskList = new ArrayList<>();

        String sql = "SELECT id_task, id_user, task FROM task_table WHERE id_user = ?";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, this.username, this.password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) { // connection to MySQL

            preparedStatement.setInt(1, id_user); // WHERE id_user = id_user

            try (ResultSet resultSet = preparedStatement.executeQuery()) { // get object
                while (resultSet.next()) {
                    Task_as_object task = new Task_as_object();
                    task.set_id_task(resultSet.getInt("id_task"));
                    task.set_id_user(resultSet.getInt("id_user"));
                    task.set_task(resultSet.getString("task"));
                    taskList.add(task);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return taskList;
    }

    public void deleteTask(int id_user, int id_task) {
        String sql = "DELETE FROM task_table WHERE id_user = ? and id_task = ?";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, this.username, this.password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, id_user);
            preparedStatement.setInt(2, id_task);

            try {
                preparedStatement.executeUpdate();
                System.out.println("Delete successful");
            } catch (SQLException e){
                System.out.println("Something is wrong with deleting in db");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTask(int id_user, int id_task, String task) {
        String sql = "UPDATE task_table SET task = ? WHERE id_task = ? and id_user = ?";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, this.username, this.password);
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, task);
            preparedStatement.setInt(2, id_task);
            preparedStatement.setInt(3, id_user);

            try {
                preparedStatement.executeUpdate();
                System.out.println("Update successful");
            } catch (SQLException e){
                System.out.println("Something is wrong with update in db");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
