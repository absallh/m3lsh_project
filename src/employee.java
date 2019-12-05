public class employee extends person {
    protected double salary;
    protected String department;
    protected String Date_of_hiring;
    protected double bonus;
    protected double deduction;
    protected String permission;
    protected employee employ;
    
    public employee (){
    }
    
    public void user_meanu(){
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
                    this.add_meanu();
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
    private void add_meanu(){
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
    
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDate_of_hiring() {
        return Date_of_hiring;
    }

    public void setDate_of_hiring(String Date_of_hiring) {
        this.Date_of_hiring = Date_of_hiring;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getDeduction() {
        return deduction;
    }

    public void setDeduction(double deduction) {
        this.deduction = deduction;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    void add() {
        person_Data.writeEmployee(id, name, email, phone, nationality, age, salary, Date_of_hiring, permission);
    }
    
    

    @Override
    void update() {
        
    }

    @Override
    void delete(int id) {
        
    }
}
