
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Data {
    
    public boolean login (String userName, String password){
        return (userName.equals("omar") && password.equals("123"));
    }
    
    public void writeEmployee (int id, String name, String email, String phone, 
            String nationality, int age, double salary, String Date_of_hiring, String permission){
        
        File employeeFile = new File("D:\\employee.txt");
        FileWriter fw = null;
        try{
            fw = new FileWriter(employeeFile, true);
        }
        catch (IOException e)
        {
            System.out.println("can't write employee data");
        }
        finally{
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter print = new PrintWriter(bw);
            
            print.printf("%d%10s%10s%10s%10s%10d%10f%10s%10s\n", id,
                    name, email, phone, nationality, age, salary, Date_of_hiring, permission);
            
            print.close();
            try{
                bw.close();
                fw.close();
            }
            catch (IOException e){}
            
        }
    }
    
    public void readEmployee (){
        
    }
    
    public void writeCustomer (String name, String email, String phone, String netionality, int age, String comming_date){
        File customerFile = new File("D:\\customer.txt");
        FileWriter fw = null;
        try{
            fw = new FileWriter(customerFile, true);
        }
        catch (IOException e)
        {
            System.out.println("can't write customer data");
        }
        finally{
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter print = new PrintWriter(bw);
            
            print.printf("%-10s%-10s%-10s%-10s%-10d%s\n", 
                    name, email, phone, netionality, age, comming_date);
            
            print.close();
            try{
                bw.close();
                fw.close();
            }
            catch (IOException e){}
            
        }
        
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
