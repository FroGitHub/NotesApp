package org.example;

public class Main {
    public static void main(String[] args) {


        User user_requests = new User();
        user_requests.register_request();
        user_requests.login_request();
        System.out.println(user_requests.get_authenticated());
        user_requests.logout_request();
        System.out.println(user_requests.get_authenticated());


    }
}