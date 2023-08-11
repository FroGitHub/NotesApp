package org.example;

import org.hibernate.cfg.Configuration;

public class HibernateConfig extends Configuration {
    public HibernateConfig() {
        this.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/notesappdb");
        this.setProperty("hibernate.connection.username", "username");
        this.setProperty("hibernate.connection.password", "password");
        this.addAnnotatedClass(UserDB.class);
    }
}
