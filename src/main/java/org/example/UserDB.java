package org.example;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import javax.persistence.*;

@Entity
@Table(name = "user_table")
class User_MySQL {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int id;

    @Column(name = "name_user")
    private String username;

    @Column(name = "password_user")
    private String password;

    User_MySQL(String username, String password){
        this.username = username;
        this.password = password;
    }

}
public class UserDB {

    private SessionFactory factory;

    public UserDB() {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(UserDB.class)
                .buildSessionFactory();
    }

    public void create_user(User_MySQL user) {
        Session session = factory.getCurrentSession();
        try {
            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();
            System.out.println("cu_db_s");
        } finally {
            factory.close();
        }
    }

}
