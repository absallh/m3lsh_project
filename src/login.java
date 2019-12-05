import java.util.Scanner;

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
        int timesOfLogin = 0;//count how many time be wrong login
        Scanner scan = new Scanner(System.in);
        
        while(!athuntcated && (timesOfLogin<3)){ //close the program if wrong login 3 times
            timesOfLogin++;
            System.out.print("Enter user name");
            user_name = scan.next();
            System.out.print("Enter password");
            password = scan.next();
            if (login_Data.login(user_name, password)){
                System.out.println("welcome");
                athuntcated = true;
            } //end if
            else if(timesOfLogin == 3)
                System.out.println("you can't login again");
            else{
                System.out.println("Wrong userName or password");
            }
        } //end while
        
        if (athuntcated){
            employee user = null;
            switch (premssion){
                case "user_model":
                    System.out.println("welcome to user model");
                    user = new user_model();
                    break;
                case "room_mangement":
                    System.out.println("welcome to room mangement model");
                    user = new room_mangement();
                    break;
                case "other_services":
                    System.out.println("welcome to other_services model");
                    user = new other_services();
                    break;
                default :
                    user = new employee();
                    break;
            }//end switch
            user.work(); //the user will enter to his options
        }//end if (athuntcated)
    }
    
}
