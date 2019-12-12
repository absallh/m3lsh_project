/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author absal
 */
public class CustomerData extends Data {
    public final static String DEFUALT_QUERY = "select customer.customer_id, Fname, Lname, nationality, age, coming_date, check_out_date, Room_number " +
                            "from customer left join customer_room " +
                            "on customer.customer_id = customer_room.customer_id";
    public String DEFAULT_QUERY;
    
    public CustomerData (){
        setQuery(DEFUALT_QUERY);
    }
    
    public void write (String frist_name, String lastName, String nationality, 
            int age, String commingDate, String checkOutDate){
        String insertTransaction = "INSERT INTO customer (Fname, Lname, nationality, age, coming_date, check_out_date)"
                +"values ('"+frist_name+"','"+lastName+"','"
                +nationality+"',"+age+",'"+commingDate+"','"+checkOutDate+"')";
        try {
            statement.executeUpdate(insertTransaction);//insert into the DB
        } catch (SQLException ex) {
            ex.printStackTrace();
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
        }
    }
    
    public void update (int ID, String frist_name, String lastName, String nationality, 
            int age, String commingDate, String checkOutDate){
        String qury = "update customer\n" +
            "set Fname = '"+frist_name+"', Lname = '"+lastName+"', nationality = '"+
                nationality+"', age = "+age+", coming_date = '"+commingDate+
                "', check_out_date = '"+checkOutDate+"'\n" +
            "where customer_id = "+ID;
        try {
            statement.executeUpdate(qury);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }
    }

}
