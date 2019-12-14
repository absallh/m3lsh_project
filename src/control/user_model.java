package control;

import Database.CustomerData;
import Database.Room_data;
import Database.Service_Data;
import java.util.ArrayList;
import java.util.Date;

public class user_model extends employee {
    private customer customer;
    private room Room;
    private service Service;
    
    public user_model (){
        customer = new customer();
        Room = new room(); 
        Service = new service();
    }
    
    public CustomerData getCustomerData (){
        return customer.getCustomerData();
    }
    
    public String[] getRoomNumbers (){
        ArrayList rooms_list =  Room.RoomNubers();
        String []rooms_array = (String[]) rooms_list.toArray(new String [rooms_list.size()]);
        return rooms_array;
    }
    
    public void add_customer(String frist_name, String lastName, String nationality, 
            int age, Date commingDate, Date checkOutDate) {
        customer.add(frist_name, lastName, nationality, age, commingDate, checkOutDate);
    }

    public void update_customer (int ID, String frist_name, String lastName, String nationality, 
            int age, Date commingDate, Date checkOutDate) {
        customer.update(ID, frist_name, lastName, nationality, age, commingDate, checkOutDate);
    }

    public void delete_customer(int id) {
        customer.delete(id);
    }
    
    public boolean addEmployee (int id, String name, String nationality, 
            String premission, String userName, String Password){
        return add(id, name, nationality, premission, userName, Password);
    }
    
    public void deleteEmployee (int id){
        delete(id);
    }
    
    public void updateEmployee (int id, String name, String nationality, 
            String premission, String userName, String Password){
        update(id, name, nationality, premission, userName, Password);
    }
    
    public Room_data getRoomData(){
        return Room.getRoomData();
    }
    
    public boolean addRoom (String roomNumber, double price, String type){
        return Room.add_room(roomNumber, price, type);
    }
    
    public void deleteRoom (String roomNumber){
        Room.delete_room(roomNumber);
    }
    
    public void updateRoom (String oldRoomNumber,String newRoomNumber, double price, String type){
        Room.update_room(oldRoomNumber, newRoomNumber, price, type);
    }
    
    public Service_Data getServiceData(){
        return Service.getService_Data();
    }
    
    public boolean addService (String name, double price, String desc){
        return Service.add_service(name, price, desc);
    }
    
    public void deleteService (String name){
        Service.delete_service(name);
    }
    
    public void updateService (String oldName, String name, double price, String desc){
        Service.update_service(oldName, name, price, desc);
    }
    
    public void close (){
        customer.close();
        Room.close();
        Service.close();
        disconnect();//inherted from employee class
    }

        
}
