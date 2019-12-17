/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author absal
 */
public class bill_Data extends Data {
    Service_Data services;
    public bill_Data(){
        services = new Service_Data();
    }
    
    public ArrayList showServices (int id){
        return services.getAssignedServices(id);
    }
    
    public ArrayList showServicesPrices (ArrayList service){
        return services.getServicesPrice(service);
    }
    
    public void pay (int id){
        try {
            statement.executeUpdate("insert into bill (customerID, boolean_paied) values ("+id+",'true')");
            
            resultSet = statement.executeQuery("select MAX(bill_id) from bill");
            int billID = resultSet.getInt(0);
            
            ArrayList<String> services = showServices(billID);
            for (int i = 0; i < services.size(); i++){
                statement.executeUpdate("insert into bill_service (service_names, bill_id) values ('"
                        +services.get(i)+"', "+billID+")");
            }
            statement.executeUpdate("delete from customer_service where customer_id ="+id);
            
            String room = customerRoom(id);
            statement.executeUpdate("insert into bill_room (bill_id, room_number) values ("+
                    billID+", '"+room+"')");
            statement.executeUpdate("delete from customer_room where customer_id ="+id);
            statement.executeUpdate("update Room\n" +
                        "set boolean_busy = 'false'\n"+"where Room_number = '"+room+"'");
        } catch (SQLException ex) {
            Logger.getLogger(bill_Data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String customerRoom (int id){
        String roomNumber = "";
        try {
            resultSet = statement.executeQuery("select Room_number from customer_room where customer_id = "+id);
            roomNumber = resultSet.getString(0);
        } catch (SQLException ex) {
            Logger.getLogger(bill_Data.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return roomNumber;
        }
    }
    
    public double roomPrice (String roomNumber){
        double price = 0;
        try {
            resultSet = statement.executeQuery("select price from Room where Room_number = '"+roomNumber+"'");
            price = resultSet.getDouble("price");
        } catch (SQLException ex) {
            Logger.getLogger(bill_Data.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return price;
        }
    }
    
    public Date customerCommingDate (int id){
        Date comming = null;
        try {
            resultSet = statement.executeQuery("select coming_date from customer where customer_id = "+id);
            comming = resultSet.getDate("coming_date");
        } catch (SQLException ex) {
            Logger.getLogger(bill_Data.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return comming;
        }
    }
    
    public Date customerCheckoutDate (int id){
        Date checkout = null;
        
        try {
            resultSet = statement.executeQuery("select check_out_date from customer where customer_id = "+id);
            checkout = resultSet.getDate("check_out_date");
        } catch (SQLException ex) {
            Logger.getLogger(bill_Data.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            return checkout;
        }
    }
}
