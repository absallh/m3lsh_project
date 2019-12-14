package control;

import Database.Room_data;
import java.util.ArrayList;

public class room {
    private int room_number;
    private String room_type;
    private boolean busy;
    private Room_data RoomData;
   //  private Data room_Data;
    
    public room (){
        RoomData = new Room_data();
    }

    public Room_data getRoomData() {
        return RoomData;
    }
    
    public ArrayList RoomNubers (){
        return RoomData.RoomNubers();
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
    }
}
