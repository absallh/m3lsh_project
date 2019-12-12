package Database;

import java.sql.SQLException;

public class Room_data extends Data{
    public static final String DEFULT_QUERY = "select room_number, price, room_type from Room";
    
    public Room_data (){
        setQuery(DEFULT_QUERY);
    }
    
    public boolean add(String roomNumber, double price, String type){
        try {
            resultSet = statement.executeQuery("select * from Room where room_number = '"+
                    roomNumber+"'");
            if (resultSet.next()){
                return false;
            }else{
                statement.executeUpdate("insert into Room (Room_number, price, Room_type, boolean_busy) values ('"+
                        roomNumber+"', "+price+", '"+type+"', 'false')");
            }
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
    
    public void delete (String roomNumber){
        try {
            statement.executeUpdate("delete from Room where Room_number = '"+roomNumber+"'");
        } catch (SQLException ex) {
            ex.printStackTrace();
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
        }
    }
    
}