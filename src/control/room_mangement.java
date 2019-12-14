package control;

import Database.Gust_mangement_data;
import Database.Room_data;
import java.util.ArrayList;
import java.util.Date;


public class room_mangement extends employee {
    customer customer;
    room Room;
    service service;
    
    public room_mangement (){
        customer = new customer();
        Room = new room();
        service = new service();
    }
    
    public Room_data getRoomData (){
        return Room.getRoomData();
    }
    
    public Gust_mangement_data getGustData() {
        return Room.getGustData();
    }
    
    public String[] RoomNumbers (){
        ArrayList rooms_list =  Room.RoomNubers();
        //convert ArrayList to array
        String []rooms_array = (String[]) rooms_list.toArray(new String [rooms_list.size()]);
        return rooms_array;
    }
    
    public String[] servicesNames(){
        ArrayList services_list =  service.servicesNames();
        //convert ArrayList to array
        String []services_array = (String[]) services_list.toArray(new String [services_list.size()]);
        return services_array;
    }
    
    public String[] getAssignedServices (int id){
        ArrayList services_list =  service.getAssignedServices(id);
        String []services_array = (String[]) services_list.toArray(new String [services_list.size()]);
        return services_array;
    }
    
    public void showNearCheckout (){
        Room.showNearCheckout();
    }
    
    public void showAll (){
        Room.showAll();
    }
    
    public void submit(int id, Date comminDate, Date checkout, String roomNuber){
        Room.RoomMangerSubmit(id, comminDate, checkout, roomNuber);
    }
    
    public void assignServices (int id, String []services){
        service.assignServices(id, services);
    }
    
    public void filter (String s){
        Room.filter(s);
    }
    
    public void close (){
        customer.close();
        Room.close();
        service.close();
    }
}
