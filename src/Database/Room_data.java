package Database;

public class Room_data extends Data{
    public final String DEFULT_QUERY = "SELECT * FROM Room";
    
    public Room_data (){
        setQuery(DEFULT_QUERY);
    }
}