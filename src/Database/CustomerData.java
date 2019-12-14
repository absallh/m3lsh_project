/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static Database.Gust_mangement_data.DEFAULT_QUERY;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 *
 * @author absal
 */
public class CustomerData extends Data {
    public final static String DEFUALT_QUERY = "select customer.customer_id, First_name, Last_name, nationality, age, coming_date, check_out_date, Room_number " +
                            "from customer left join customer_room " +
                            "on customer.customer_id = customer_room.customer_id";
    
    public CustomerData (){
        setQuery(DEFUALT_QUERY);
    }
    
    public void add (String frist_name, String lastName, String nationality, 
            int age, String commingDate, String checkOutDate){
        String insertTransaction = "INSERT INTO customer "+
                "(First_name, Last_name, nationality, age, coming_date, check_out_date) "
                +"values ('"+frist_name+"','"+lastName+"','"
                +nationality+"',"+age+",'"+commingDate+"','"+checkOutDate+"')";
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
            int age, String commingDate, String checkOutDate){
        String qury = "update customer\n" +
            "set First_name = '"+frist_name+"', Last_name = '"+lastName+"', nationality = '"+
                nationality+"', age = "+age+", coming_date = '"+commingDate+
                "', check_out_date = '"+checkOutDate+"'\n" +
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
    
    public void showNearcheckout (){
        setQuery("select customer.customer_id, first_name, last_name, coming_date, check_out_date, customer_room.Room_number " +
                            "from customer, customer_room " +
                            "where customer.customer_id = customer_room.customer_id and check_out_date >= '"
                        +LocalDate.now().plusDays(2)+"' "+ "and check_out_date <= '"
                        + LocalDate.now().plusDays(4)+"'\n"+ "ORDER BY check_out_date ASC");
        
    }
    
    public void RoomMangerSubmit (int id, Date comminDate, Date checkout, String roomNuber){
        try {
            //the Date can be converted to Instant 
            //Instant + system default time zone + toLocalDate() = LocalDate
            //there are some error I don't know why but it shifted 2 days to the past
            statement.executeUpdate("update customer\n" +
                    "set coming_date = '"+comminDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(2)+"', check_out_date = '"+
                    checkout.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(2)+"'\n" +"where customer_id = "+ id);
            
            //check if the customer assigned to room or not
            resultSet = statement.executeQuery("select * from customer_room where customer_id ="+id);
            if(resultSet.next()){//if yes update his room
                    if (roomNuber == null){
                        resultSet = statement.executeQuery("select Room_number from customer_room\n"+
                                "where customer_id ="+id);
                        if (resultSet.next()){
                            String room = resultSet.getString("Room_number");
                            statement.executeUpdate("update Room\n" +
                                "set boolean_busy = 'false'\n" +
                                "where Room_number = '"+roomNuber+"'");
                        }
                        statement.executeUpdate("delete customer_room\n"+
                            "where customer_id = "+id);
                    }else{
                        statement.executeUpdate("update customer_room\n"+
                            "set Room_number = '"+roomNuber+"'\n"+
                            "where customer_id = "+id);
                        //update the room state
                        statement.executeUpdate("update Room\n" +
                            "set boolean_busy = 'true'\n" +
                            "where Room_number = '"+roomNuber+"'");
                    }
            }else{//assign the customer to room
                statement.executeQuery("insert into customer_room \n" +
                        "(customer_id, Room_number) values ("+id+", '"+roomNuber+"')");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void showAll (){
        setQuery(DEFAULT_QUERY);
    }
    
    public void submit (int id, Date comminDate, Date checkout, String roomNuber){
        try {
            //the Date can be converted to Instant 
            //Instant + system default time zone + toLocalDate() = LocalDate
            //there are some error I don't know why but it shifted 2 days to the past
            statement.executeUpdate("update customer\n" +
                    "set coming_date = '"+comminDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(2)+"', check_out_date = '"+
                    checkout.toInstant().atZone(ZoneId.systemDefault()).toLocalDate().plusDays(2)+"'\n" +"where customer_id = "+ id);
            
            //check if the customer assigned to room or not
            resultSet = statement.executeQuery("select * from customer_room where customer_id ="+id);
            if(resultSet.next()){//if yes update his room
                    if (roomNuber == null){
                        resultSet = statement.executeQuery("select Room_number from customer_room\n"+
                                "where customer_id ="+id);
                        if (resultSet.next()){
                            String room = resultSet.getString("Room_number");
                            statement.executeUpdate("update Room\n" +
                                "set boolean_busy = 'false'\n" +
                                "where Room_number = '"+roomNuber+"'");
                        }
                        statement.executeUpdate("delete customer_room\n"+
                            "where customer_id = "+id);
                    }else{
                        statement.executeUpdate("update customer_room\n"+
                            "set Room_number = '"+roomNuber+"'\n"+
                            "where customer_id = "+id);
                        //update the room state
                        statement.executeUpdate("update Room\n" +
                            "set boolean_busy = 'true'\n" +
                            "where Room_number = '"+roomNuber+"'");
                    }
            }else{//assign the customer to room
                statement.executeQuery("insert into customer_room \n" +
                        "(customer_id, Room_number) values ("+id+", '"+roomNuber+"')");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            setQuery(DEFAULT_QUERY);
        }
    }
    
    public void assignServices (int id, String []services){
        try{
            statement.executeUpdate("delete customer_service where customer_id = "+id);
            for (String oneService : services){
                statement.executeUpdate("insert into customer_service (customer_id, service_names) values ("+
                        id+", '"+ oneService+"')");
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            setQuery(DEFAULT_QUERY);
        }
    } 

}
