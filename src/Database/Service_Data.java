/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import static Database.Gust_mangement_data.DEFAULT_QUERY;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author absal
 */
public class Service_Data extends Data{
    private static final String DEFUALT_QUERY = "SELECT * from Servicee";
            
 public Service_Data (){
        setQuery(DEFUALT_QUERY);
    }
 
 public boolean add (String name, double price, String desc){
        try {
            resultSet = statement.executeQuery("SELECT * from Servicee where service_names = '" + name+"'");
            if (resultSet.next()){
                setQuery(DEFUALT_QUERY);
                return false;
            }else{
                statement.executeUpdate("insert into Servicee VALUES ('"
                        +name+"' , '"+desc+"' , "+price+")");
                setQuery(DEFUALT_QUERY);
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            setQuery(DEFUALT_QUERY);
            return false;
        }
 }
 public void update (String oldName, String name, double price, String desc){
     try {
            statement.executeUpdate("update Servicee\n"+
                    "set service_names = '"+ name+"', service_price = "+price+
                    ", service_description = '"+desc+"'\n"+
                    "where service_names = '"+oldName+"'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
         setQuery(DEFUALT_QUERY);
     }
 }
 public void delete (String name){
     try {
            statement.executeUpdate("delete from customer_service where service_names = '"+name+"'");
            statement.executeUpdate("delete from Room_services where services_name = '"+name+"'");
            statement.executeUpdate("delete from Servicee where service_names = '"+name+"'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
         setQuery(DEFUALT_QUERY);
     }
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
 
 public ArrayList getServicesPrice (String[] service){
     ArrayList<Double> prices = new ArrayList<>();
     
        try {
            for (int i = 0; i < service.length; i++){
                resultSet = statement.executeQuery("select service_price from Servicee where service_names = '"+
                        service[i]+"'");
                if (resultSet.next())
                    prices.add((double) resultSet.getInt("service_price"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            return prices;
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
 
 public void assignServices (int id, String []services){
        try{
            for (String oneService : services){
                statement.executeUpdate("insert into customer_service (customer_id, service_names, use_time) values ("+
                        id+", '"+ oneService+"', '"+LocalDate.now()+"')");
            }
        }catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            setQuery(DEFAULT_QUERY);
        }
    }

    ArrayList getServicesPrice(ArrayList service) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
