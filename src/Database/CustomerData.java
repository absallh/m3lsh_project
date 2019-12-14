/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;


import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author absal
 */
public class CustomerData extends Data {
    private final static String DEFUALT_QUERY = "select customer.customer_id, First_name, Last_name, nationality, age, coming_date, check_out_date, Room_number " +
                            "from customer left join customer_room " +
                            "on customer.customer_id = customer_room.customer_id";
    
    public CustomerData (){
        setQuery(DEFUALT_QUERY);
    }
    
    public void add (String frist_name, String lastName, String nationality, 
            int age, Date commingDate, Date checkOutDate){
        //to convert date to localdate 
        //1- convert date to Instant
        //2- Instant + system default time zone + toLocalDateTime() = LocalDateTime
        
        String insertTransaction = "INSERT INTO customer "+
                "(First_name, Last_name, nationality, age, coming_date, check_out_date) "
                +"values ('"+frist_name+"','"+lastName+"','"
                +nationality+"',"+age+",'"+
                commingDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(2)+
                "', '"+checkOutDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(2)+"')";
        try {
            statement.executeUpdate(insertTransaction);//insert into the DB
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            setQuery(DEFUALT_QUERY);
        }
    }

    
    public void delete (int ID){
        try {
            String deleteStatment = "delete from customer_room where customer_id = "+ID+"\n" +
                                    "delete from customer_service where customer_id = "+ID+"\n" +
                                    "delete from customer where customer_id = "+ID;
            statement.executeUpdate(deleteStatment);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            setQuery(DEFUALT_QUERY);
        }
    }
    
    public void update (int ID, String frist_name, String lastName, String nationality, 
            int age, Date commingDate, Date checkOutDate){
        //to convert date to localdate 
        //1- convert date to Instant
        //2- Instant + system default time zone + toLocalDateTime() = LocalDateTime
        String qury = "update customer\n" +
            "set First_name = '"+frist_name+"', Last_name = '"+lastName+"', nationality = '"+
            nationality+"', age = "+age+", coming_date = '"
            +commingDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(2)+
            "', check_out_date = '"+checkOutDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(2)+"'\n" +
            "where customer_id = "+ID;
        try {
            statement.executeUpdate(qury);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            setQuery(DEFUALT_QUERY);
        }
    }
}
