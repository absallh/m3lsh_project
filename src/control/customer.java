package control;

public class customer extends person {
    private String comming_date;
    private String checkout;
    private bill customer_bill;
    private room customer_room;
    private service customer_service;
    
    public void user_meanue(){
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
                    this.addmeanu();
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

    public String getComming_date() {
        return comming_date;
    }

    public void setComming_date(String comming_date) {
        this.comming_date = comming_date;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
    
    @Override
    void add() {
        person_Data.writeCustomer(name, email, phone, nationality, age, comming_date);
    }
    
    public void addmeanu(){
        System.out.println("Enter customer name");
        java.util.Scanner scan = new java.util.Scanner(System.in);
        name = scan.next();
        System.out.println("Enter customer Email");
        email = scan.next();
        System.out.println("Enter customer phone");
        phone = scan.next();
        System.out.println("Enter Nationality");
        nationality = scan.next();
        System.out.println("Enter Age");
        age = scan.nextInt();
        System.out.println("Enter comming date");
        comming_date = scan.nextLine();
        this.add();
    }

    @Override
    void update() {
    }

    @Override
    void delete(int id) {
    }
    
}
