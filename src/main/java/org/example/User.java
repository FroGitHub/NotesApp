package org.example;

interface IRegister{
    abstract void register(String name, String password);
}
interface ILogin{
    abstract User_as_object login(String name, String password);
}

class Register implements IRegister{
    @Override
    public void register(String name, String password){
        UserDB user_db = new UserDB();
        user_db.createUser(name, password);
    }
}
class Login implements ILogin{
    @Override
    public User_as_object login(String name, String password) {
        UserDB user_db = new UserDB();
        User_as_object user = user_db.selectUser(name);


        try {                                           // I add check existing name, bad but is works
            if (user.getPassword().equals(password)) {
                System.out.println("login");
                return user;
            } else {
                System.out.println("not login");
                return null;
            }


        } catch (NullPointerException e) {
            System.out.println("That name does not exist");
            return null;
        }
    }
}


public class User {

    private User_as_object user;
    private boolean authenticated = false;
    Register user_register = new Register();
    Login user_login = new Login();

    public void registerRequest(String name, String password){
        user_register.register(name, password);
        System.out.println("rrs");
    }

    public void loginRequest(String name, String password) {
        this.user = user_login.login(name, password);
        if (this.user != null){
            this.authenticated = true;
        }
    }
    void logoutRequest(){
        this.user = null;
        this.authenticated = false;
        System.out.println("logout");
    }

    // ===========================================================
    public String getUsername(){

        if (this.authenticated){
            return this.user.getUsername();
        }
        return "You can`t do that";
    }
    public boolean get_authenticated(){
        return this.authenticated;
    }

}
