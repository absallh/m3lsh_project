package control;

import javax.swing.JOptionPane;
import Gui.Login;

public class login {
    private String user_name;
    private String password;
    private String premssion = "user_model";
    private boolean athuntcated;
    private Data login_Data;
    
    public login (){
        login_Data = new Data();
        athuntcated = false;
    }

    /**
     run method to run the whole program and login
     */
    public void run (){
        
        try{
            Login logForm = new Login();
            user_name = logForm.getUserName_txt();
            password = logForm.getPassword_txt();
            athuntcated = login_Data.login(user_name, password);
            
        }
        catch (NullPointerException e){
        if (athuntcated){
            //employee user = null;
            switch (premssion){
                case "user_model":
                    JOptionPane.showMessageDialog(null, "welcom", "user_model", JOptionPane.PLAIN_MESSAGE);
                    //user = new user_model();
                    break;
                case "room_mangement":
                    JOptionPane.showMessageDialog(null, "welcom", "room_mangement", JOptionPane.PLAIN_MESSAGE);
                    //user = new room_mangement();
                    break;
                case "other_services":
                    JOptionPane.showMessageDialog(null, "welcom", "room_mangement", JOptionPane.PLAIN_MESSAGE);
                    //user = new other_services();
                    break;
                default :
               //     user = new employee();
                    break;
            }//end switch
            //user.work(); //the user will enter to his options
        }//end if (athuntcated)
    }
   }
}
