package control;

import Database.CustomerData;
import Database.Gust_mangement_data;
import java.util.Date;

public class customer extends person {
    private String comming_date;
    private String checkout;
    private bill customer_bill;
    private room customer_room;
    private service customer_service;
    private CustomerData CoustomerData;
    private Gust_mangement_data gustData;
    
    public customer (){
        CoustomerData = new CustomerData();
        gustData = new Gust_mangement_data();
    }
    
    public Gust_mangement_data getGustData() {
        return gustData;
    }
    
    public CustomerData getCustomerData(){
        return CoustomerData;
    }
    
    void add(String frist_name, String lastName, String nationality, 
            int age, String commingDate, String checkOutDate) {
        CoustomerData.add(frist_name, lastName, nationality, age, commingDate, checkOutDate);
    }
    
    void update(int ID, String frist_name, String lastName, String nationality, 
            int age, String commingDate, String checkOutDate) {
        CoustomerData.update(ID, frist_name, lastName, nationality, age, commingDate, checkOutDate);
    }

    @Override
    void delete(int id) {
        CoustomerData.delete(id);
    }
    
    public void showNearCheckout (){
        CoustomerData.showNearcheckout();
    }
    
    public void showAll() {
        CoustomerData.showAll();
    }
    
    public void submit (int id, Date comminDate, Date checkout, String roomNuber){
        CoustomerData.submit(id, comminDate, checkout, roomNuber);
    }
    
    public void assignServices (int id, String []services){
        CoustomerData.assignServices(id, services);
    }
    
    public void close(){
        CoustomerData.disconnectFromDatabase();
    }
}
