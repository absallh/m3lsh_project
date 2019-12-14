/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author absal
 */
public class Gust_mangement_data extends Data {
    public static final String DEFAULT_QUERY = "select customer.customer_id, first_name, last_name, coming_date, check_out_date, customer_room.Room_number" +
                    " from customer left join customer_room" +
                    " on customer.customer_id = customer_room.customer_id";
    public Gust_mangement_data (){
        setQuery(DEFAULT_QUERY);
    }
    
     public ArrayList servicesNames (){
         ArrayList <String> services = new ArrayList<>();
        try {
            resultSet = statement.executeQuery("select service_names from Servicee");
            int i = 0;
            while (resultSet.next()){
                services.add(i, resultSet.getString("service_names"));
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            setQuery(DEFAULT_QUERY);
            return services;
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
     
    public ArrayList getAssignedServices(int id){
        ArrayList<String> services = new ArrayList<>();
         
        try {
            resultSet = statement.executeQuery("select service_names from customer_service where customer_id = "+id);
            int i = 0;
            while (resultSet.next()){
                services.add(i, resultSet.getString("service_names"));
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            setQuery(DEFAULT_QUERY);
            return services;
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
            setQuery(DEFAULT_QUERY);
            return rooms;
        }
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
        }finally {
            setQuery(DEFAULT_QUERY);
        }
    }
    
    public void showNearcheckout (){
        setQuery("select customer.customer_id, first_name, last_name, coming_date, check_out_date, customer_room.Room_number " +
                            "from customer, customer_room " +
                            "where customer.customer_id = customer_room.customer_id and check_out_date >= '"
                        +LocalDate.now().plusDays(2)+"' "+ "and check_out_date <= '"
                        + LocalDate.now().plusDays(4)+"'\n"+ "ORDER BY check_out_date ASC");
        
    }
    
    public void showAll (){
        setQuery(DEFAULT_QUERY);
    }
}
