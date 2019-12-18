package Database;

import java.sql.SQLException;
import java.util.ArrayList;

public class Room_data extends Data{
    private static final String DEFULT_QUERY = "select room_number, price, room_type, boolean_busy from Room";
    
    public Room_data (){
        setQuery(DEFULT_QUERY);
    }
    
    public void filter (String s){
        switch (s){
                 case "None":
                     setQuery(DEFULT_QUERY);
                     break;
                 case "Busy":
                     setQuery("select * from Room where boolean_busy = 'true'");
                     break;
                 case "NotBusy":
                     setQuery("select * from Room where boolean_busy = 'false'");
                     break;
                 case "Single":
                     setQuery("select * from Room where Room_type = 'Single'");
                     break;
                 case "Double":
                     setQuery("select * from Room where Room_type = 'Double'");
                     break;
                 case "Quad":
                    setQuery("select * from Room where Room_type = 'Quad'");
                    break;
                 case "Studio":
                     setQuery("select * from Room where Room_type = 'Studio'");
                     break;
                 case "Suites":
                     setQuery("select * from Room where Room_type = 'Suites'");
                     break;
             }
    }
    
    public ArrayList RoomNubers (){
        
        ArrayList<String> rooms = new ArrayList<>();
        
        try {
            resultSet = statement.executeQuery("Select room_number from Room");
            int i = 0;
            while (resultSet.next()){
                rooms.add(i, resultSet.getString("room_number"));
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            setQuery(DEFULT_QUERY);
            return rooms;
        }
    }
    
    public int roomPrice (String roomNumber){
        int price = 0;
        
        try {
            resultSet = statement.executeQuery("select price from Room where Room_number = '"+
                    roomNumber+"'");
            if (resultSet.next()){
                price = resultSet.getInt("price");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            setQuery(DEFULT_QUERY);
            return price;
        }
    }
    
    public boolean add(String roomNumber, double price, String type){
        try {
            resultSet = statement.executeQuery("select * from Room where room_number = '"+
                    roomNumber+"'");
            if (resultSet.next()){
                setQuery(DEFULT_QUERY);
                return false;
            }else{
                statement.executeUpdate("insert into Room (Room_number, price, Room_type, boolean_busy) values ('"+
                        roomNumber+"', "+price+", '"+type+"', 'false')");
            }
            setQuery(DEFULT_QUERY);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            setQuery(DEFULT_QUERY);
            return false;
        }
    }
    
    public void delete (String roomNumber){
        try {
            statement.executeUpdate("delete from Room where Room_number = '"+roomNumber+"'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            setQuery(DEFULT_QUERY);
        }
    }
    
    public void update (String oldRoomNumber,String newRoomNumber, double price, String type){
        try {
            statement.executeUpdate("update Room \n" +
                    "set Room_number = '"+newRoomNumber+"', price = "+price+
                    ", Room_type = '"+type+"'\n" +
                    "where Room_number = '"+oldRoomNumber+"'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            setQuery(DEFULT_QUERY);
        }
    }
    
}