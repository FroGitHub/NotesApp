package org.example;

public class Main {
    public static void main(String[] args) {

        User user_requests = new User();
        user_requests.loginRequest("444", "444");

        System.out.println(user_requests.getUsername());

        user_requests.logoutRequest();

        System.out.println(user_requests.getUsername());


    }
}