package org.example;

public class Main {
    public static void main(String[] args) {

        User user_requests = new User();
        user_requests.registerRequest("Andriy2", "444");

        System.out.println(user_requests.getUsername());

    }
}