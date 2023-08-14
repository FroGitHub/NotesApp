package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User user = new User(); // go to class User which has requests

        while(true){    // bad code
            String input = scanner.nextLine();
            if (input.equals("login")){
                System.out.print("Login: ");
                String log = scanner.nextLine();
                System.out.print("Password: ");
                String pass = scanner.nextLine();
                user.loginRequest(log, pass);
            }
            else if(input.equals("logout")){
                user.logoutRequest();
            }
            else if (input.equals("register")){
                System.out.print("Login: ");
                String log = scanner.nextLine();
                System.out.print("Password: ");
                String pass = scanner.nextLine();
                user.registerRequest(log, pass);
            }
            else if (input.equals("add task")){
                System.out.print("Task: ");
                String task = scanner.nextLine();
                user.createTask(task);
            }
            else if (input.equals("show tasks")){
                user.getTasks();
            }
            else if (input.equals("update task")){
                System.out.print("Id task: ");
                int id_task = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Task: ");
                String taskUpdate = scanner.nextLine();
                user.updateTask(id_task, taskUpdate);
            }
            else if (input.equals("delete task")){
                System.out.print("Id task: ");
                int id_task = scanner.nextInt();
                user.deleteTask(id_task);
            }
        }
    }
}