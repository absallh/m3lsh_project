package control;

public class Data {
    
    public boolean login (String userName, String password){
        return (userName.equals("omar") && password.equals("123"));
    }
    
    public String getEmployeePremission(String user_name, String password){
        return "other_services";
    }
    
    public void writeEmployee (int id, String name, String email, String phone, 
            String nationality, int age, double salary, String Date_of_hiring, String permission){
        
    }
    
    public void readEmployee (){
        
    }
    
    public void writeCustomer (String name, String email, String phone, String netionality, int age, String comming_date){
        
    }
    
    public void readCustomer (){
        
    }
    
    public void writeRoom (){
        
    }
    
    public void readRoom (){
        
    }
    
    public void writeService (){
        
    }
    
    public void readService (){
        
    }
}
