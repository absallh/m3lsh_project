/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.SQLException;

/**
 *
 * @author absal
 */
public class Service_Data extends Data{
    public static final String DEFUALT_QUERY = "SELECT * from Servicee";
            
 public Service_Data (){
        setQuery(DEFUALT_QUERY);
    }
 
 public boolean add (String name, double price, String desc){
        try {
            resultSet = statement.executeQuery("SELECT * from Servicee where service_names = '" + name+"'");
            if (resultSet.next()){
                return false;
            }else{
                statement.executeUpdate("insert into Servicee VALUES ('"
                        +name+"' , '"+desc+"' , "+price+")");
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
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
        }
 }
 public void delete (String name){
     try {
            statement.executeUpdate("delete from Room_services where services_name = '"+name+"'");
            statement.executeUpdate("delete from Servicee where service_names = '"+name+"'");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
 }
}
