public class user_model extends employee {
    private customer custo;
    
    public user_model(){
    }
    
    private static void select_what(){//select from add or delete or update
        int selction;
        java.util.Scanner scan = new java.util.Scanner(System.in);
        do{
            System.out.println("Enter your selction");
            System.out.println("1- for add");
            System.out.println("2- for delete");
            System.out.println("3- for update");
            System.out.println("4- for cancel");
            selction = scan.nextInt();
            
            switch (selction){
                case 1://for add
                    user_model addEmployee = new user_model();
                    addEmployee.add_meanu();
                    break;
                case 2://for delete
                    break;
                case 3://for update
                    break;
                case 4://to not enter the defaut option
                    break;
                default :
                    System.out.println("wrong input");
                    System.out.println("Try agin");
                    break;
            }
        }while(selction != 4);
    }
    
    @SuppressWarnings("fallthrough")
     public void add_meanu(){
        java.util.Scanner scan = new java.util.Scanner(System.in);
        System.out.println("Enter employee id");
        id = scan.nextInt();
        System.out.println("Enter employee name");
        name = scan.next();
        System.out.println("Enter employee email");
        email = scan.next();
        System.out.println("Enter employee phone");
        phone = scan.next();
        System.out.println("Enter employee nationality");
        nationality = scan.next();
        System.out.println("Enter Employee age");
        age = scan.nextInt();
        System.out.println("Enter Salary");
        salary = scan.nextDouble();
        System.out.println("Enter date of hiring");
        Date_of_hiring = scan.next();
        System.out.println("Choice his permission");
        System.out.println("1- for user_model");
        System.out.println("2- for room_mangement");
        System.out.println("3- for other_service");
        int choice = scan.nextInt();
        switch (choice){
            case 1: 
                permission = "user_model";
                break;
            case 2:
                permission = "room_mangement";
                break;
            case 3:
                permission = "other_services";
            default :
                System.out.println("wrong input\ntry again");
                break;
        }
        
        this.add();
    }
    
    void add_customer() {
        
    }

    void update_customer() {
        
    }

    void delete_customer() {
        
    }
    
    @Override//choice among customer or employee or Rooms
    public void work(){
        int selection;
        do{
            System.out.println();
            System.out.println("Enter:");
            System.out.println("1- for customer");
            System.out.println("2- for employee");
            System.out.println("3- for Room");
            System.out.println("4- for Exit");
            
            java.util.Scanner scan = new java.util.Scanner(System.in);
            selection = scan.nextInt();
            
            switch(selection){
                case 1://enter to customer
                    custo = new customer();
                    custo.user_meanue();
                    break;
                case 2://enter to employee
                    select_what();
                    break;
                case 3://enter to room
                    break;
                case 4://to not enter the default option
                    break;
                default :
                    break;
            }
        }while (selection != 4);
        
    }
}
