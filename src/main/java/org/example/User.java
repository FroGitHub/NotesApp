package org.example;

interface IRequest{
    final UserDB user_db = new UserDB();
    abstract User_as_object action(String name, String password);
}

class Register implements IRequest{
    @Override
    public User_as_object action(String name, String password){
        user_db.createUser(name, password);
        return null;
    }
}
class Login implements IRequest{
    @Override
    public User_as_object action(String name, String password) {
        User_as_object user = user_db.selectUser(name);

        try {                                           // I added check existing name, bad but is works
            if (user.getPassword().equals(password)) {
                System.out.println("login is right");
                return user;
            } else {
                System.out.println("not logined due to wrong password");
                return null;
            }


        } catch (NullPointerException e) {
            System.out.println("not logined due to wrong login");
            return null;
        }
    }
}


public class User {

    private User_as_object user;
    private boolean authenticated = false;
    Register userRegisterRequest = new Register();
    Login userLoginRequest = new Login();
// ======================================================================
    public void registerRequest(String name, String password){
        userRegisterRequest.action(name, password);
    }

    public void loginRequest(String name, String password) {
        this.user = userLoginRequest.action(name, password);
        if (this.user != null){
            this.authenticated = true;
            System.out.println("Logined");
        }
    }
    void logoutRequest(){
        this.user = null;
        this.authenticated = false;
        System.out.println("logouted");
    }

// ==============================================================================
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
