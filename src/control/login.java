package control;

import Gui.*;

public class login {
    private String premssion;
    private boolean athuntcated;
    private Data login_Data;
    private String user_name;
    private String password;
    private Employee user;
    
    public login (){
        login_Data = new Data();
        athuntcated = false;
    }
    
    public boolean athuntcated (String user_name, String password){
        athuntcated = login_Data.login(user_name, password);//connect to the db and check if athuntcated
        if (athuntcated)
        {
            this.user_name = user_name;
            this.password = password;
        }
        return athuntcated;
    }
    
    public void enterTheProgram (){
        //get user premission from db
        premssion = login_Data.getEmployeePremission(user_name, password);
        
        switch (premssion){//we will change all of that to run the Gui
            case "user_model":
                user = new UserModel();
                break;
            case "room_mangement":
                //user = new room_mangement();
                break;
            case "other_services":
                //user = new other_services();
                break;
        }
        
        user.work();//the user can do his prmission
    }
}
