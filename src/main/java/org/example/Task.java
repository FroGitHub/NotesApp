package org.example;

import org.example.classesDB.TaskDB;
import org.example.objects.Task_as_object;

import java.util.List;


public class Task {
    TaskDB taskDB = new TaskDB();
    public List<Task_as_object> getTasksFromTable(int id_user){ // go to taskDB
        //select * from task_table
        System.out.println("Getting from db");
        return taskDB.selectTasks(id_user);

    }
    public void createTaskInDB(int id_user, String task){ // go to taskDB
        this.taskDB.createTask(id_user, task);
        System.out.println("Task is created successfully");
    }

    public void deleteTaskInDB(int id_user, int id_task){ // go to taskDB
        this.taskDB.deleteTask(id_user, id_task);
        System.out.println("Task is deleted successfully");
    }

    public void updateTaskInDB(int id_user, int id_task, String task){ // go to taskDB
        this.taskDB.updateTask(id_user, id_task, task);
        System.out.println("Task is updated successfully");
    }
}
