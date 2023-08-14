package org.example.objects;

public class User_as_object {
    private int id;
    private String username;
    private String password;

    public void setId(int id) { this.id = id; }
    public void setUsername(String name) {
        this.username = name;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }

    public int getId() {
        return this.id;
    }
    public String getPassword() {
        return this.password;
    }
    public String getUsername() {
        return this.username;
    }
}
