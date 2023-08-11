package org.example;

interface IRegister{
    abstract void register(String name, String password);
}
interface ILogin{
    abstract boolean login();
}
interface ILogout{
    abstract boolean logout();
}

class Register implements IRegister{
    @Override
    public void register(String name, String password){
        UserDB user_db = new UserDB();
        User_MySQL user = new User_MySQL(name, password);
        user_db.create_user(user);
    }
}
class Login implements ILogin{
    @Override
    public boolean login(){
        System.out.println("login");
        return true;
    }
}
class Logout implements ILogout{
    @Override
    public boolean logout(){
        System.out.println("logout");
        return false;
    }
}


public class User {

    private boolean authenticated = false;
    Register user_register = new Register();
    Login user_login = new Login();
    Logout user_logout = new Logout();

    void register_request(String name, String password){
        user_register.register(name, password);
        System.out.println("rrs");
    }

    void login_request(){
        authenticated = user_login.login();
    }

    void logout_request(){
        authenticated = user_logout.logout();
    }

    public boolean get_authenticated(){
        return this.authenticated;
    }

}
