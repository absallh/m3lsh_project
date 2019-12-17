package control;

import Database.CustomerData;
import java.util.ArrayList;
import java.util.Date;

public class customer extends person {
    private CustomerData CoustomerData;
    private bill bill;
    
    public customer (){
        CoustomerData = new CustomerData();
        bill = new bill();
    }
    
    public ArrayList showServicesPrices (ArrayList service){
        return bill.showServicesPrices(service);
    }
    
    public CustomerData getCustomerData(){
        return CoustomerData;
    }
    
    void add(String frist_name, String lastName, String nationality, 
            int age, Date commingDate, Date checkOutDate) {
        CoustomerData.add(frist_name, lastName, nationality, age, commingDate, checkOutDate);
    }
    
    void update(int ID, String frist_name, String lastName, String nationality, 
            int age, Date commingDate, Date checkOutDate) {
        CoustomerData.update(ID, frist_name, lastName, nationality, age, commingDate, checkOutDate);
    }

    @Override
    void delete(int id) {
        CoustomerData.delete(id);
    }
    
    public void close(){
        CoustomerData.disconnectFromDatabase();
    }
    
}
