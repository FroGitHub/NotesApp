package org.example;

import org.example.classesDB.UserDB;
import org.example.objects.Task_as_object;
import org.example.objects.User_as_object;

import java.util.List;

interface IRequest{
    final UserDB user_db = new UserDB();
    abstract User_as_object action(String name, String password);
}

class Register implements IRequest{  // go to UserDB
    @Override
    public User_as_object action(String name, String password){
        user_db.createUser(name, password);
        return null;
    }
}
class Login implements IRequest{  // go to UserDB
    @Override
    public User_as_object action(String name, String password) {
        User_as_object user = user_db.selectUser(name);

        try {                                           // I added check existing name, bad but is works
            if (user.getPassword().equals(password)) {
                System.out.println("login is right");
                return user;
            } else {
                System.out.println("not logined due to wrong password");
                return null;
            }


        } catch (NullPointerException e) {
            System.out.println("not logined due to wrong login");
            return null;
        }
    }
}

public class User {
// =================================================================(Fields)===========
    private User_as_object user;

    List<Task_as_object> usersTasks;
    private boolean authenticated = false;
    Register userRegisterRequest = new Register();
    Login userLoginRequest = new Login();
    Task taskRequest = new Task();
// ====================================================================================
    public void registerRequest(String name, String password){ // go to class Register
        userRegisterRequest.action(name, password);
    }

    public void loginRequest(String name, String password) {  // go to class Login
        this.user = userLoginRequest.action(name, password);
        if (this.user != null){
            this.authenticated = true;
            System.out.println("Logined");
        }
    }
    void logoutRequest(){   // go to ... idk
        this.user = null;
        this.authenticated = false;
        System.out.println("logouted");
    }

// ==============================================================================
    public void getTasks(){  // go to class Task
        if (this.authenticated) {
            this.usersTasks = taskRequest.getTasksFromTable(user.getId());

            for(Task_as_object task : this.usersTasks){
                System.out.println(task.get_id_task() + " - " + task.get_task());
            }
        }
        else {
            System.out.println("You can`t do that");
        }
    }
    public void createTask(String task){  // go to class Task
        if (this.authenticated){
            System.out.println("Creation the task");
            this.taskRequest.createTaskInDB(this.user.getId(), task);
        }
        else {
            System.out.println("You can`t do that");
        }
    }

    public void deleteTask(int id_task){  // go to class Task
        if (this.authenticated){
            System.out.println("Deleting the task");
            this.taskRequest.deleteTaskInDB(this.user.getId(), id_task);
        }
        else {
            System.out.println("You can`t do that");
        }
    }

    public void updateTask(int id_task, String task){  // go to class Task
        if (this.authenticated){
            System.out.println("Deleting the task");
            this.taskRequest.updateTaskInDB(this.user.getId(), id_task, task);
        }
        else {
            System.out.println("You can`t do that");
        }
    }
}
