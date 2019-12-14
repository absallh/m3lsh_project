package control;

import Database.Gust_mangement_data;
import Database.Room_data;
import java.util.ArrayList;
import java.util.Date;

public class room {

    private Room_data RoomData;
    private Gust_mangement_data gustData;
    
    public room (){
        RoomData = new Room_data();
        gustData = new Gust_mangement_data();
    }

    public Gust_mangement_data getGustData() {
        return gustData;
    }
    
    public void RoomMangerSubmit (int id, Date comminDate, Date checkout, String roomNuber){
        gustData.submit(id, comminDate, checkout, roomNuber);
    }

    public Room_data getRoomData() {
        return RoomData;
    }
    
    public void showNearCheckout (){
        gustData.showNearcheckout();
    }
    
    public void showAll (){
        gustData.showAll();
    }
    
    public ArrayList RoomNubers (){
        return gustData.RoomNubers();
    }
    
    public boolean add_room (String roomNumber, double price, String type)
    {
        return RoomData.add(roomNumber, price, type);
    }
    
    public void delete_room (String roomNumber)
    {
        RoomData.delete(roomNumber);
    }
    
    public void update_room(String oldRoomNumber,String newRoomNumber, double price, String type)
    {
        RoomData.update(oldRoomNumber, newRoomNumber, price, type);
    }
    
    public void filter (String s){
        RoomData.filter(s);
    }

    void close() {
        RoomData.disconnectFromDatabase();
        gustData.disconnectFromDatabase();
    }
}
