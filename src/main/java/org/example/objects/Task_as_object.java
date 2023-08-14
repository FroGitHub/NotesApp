package org.example.objects;

public class Task_as_object {

    private int id_task;
    private int id_user;
    private String task;

    public void set_id_task(int id){
        this.id_task = id;
    }

    public void set_id_user(int id){
        this.id_user = id;
    }

    public void set_task(String task){
        this.task = task;
    }
    public int get_id_task(){
        return this.id_task;
    }
    public int get_id_user(){
        return this.id_user;
    }

    public String get_task(){
        return this.task;
    }

}
