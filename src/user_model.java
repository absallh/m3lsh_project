public class user_model extends employee {
    private customer custo;
    
    
    public user_model (){
        int selection ;
        do{
            selection = manue();
            switch (selection) {
                case 1://Enter the customer class
                    System.out.println("Welcome to Customer");
                    custo = new customer();
                    custo.user_meanue();
                    break;
                case 2://Enter the employee class
                    employ = new employee();
                    employ.user_meanu();
                    break;
                case 3://Enter the Rooms
                    break;
                case 4:
                    //to don't enter the default option
                    break;
                default:
                    System.out.println("wrong input");
                    System.out.println("Try again");
                    break;
            }
        }while (selection != 4);
    }
    
    void add_customer() {
        
    }

    void update_customer() {
        
    }

    void delete_customer() {
        
    }
    
    private static int manue(){
        System.out.println();
        System.out.println("Enter:");
        System.out.println("1- for customer");
        System.out.println("2- for employee");
        System.out.println("3- for Room");
        System.out.println("4- for Exit");
        int selection;
        java.util.Scanner scan = new java.util.Scanner(System.in);
        selection = scan.nextInt();
        return selection;
    }
}
