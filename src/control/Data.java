package control;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Data {
    private static final String db_Url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDataBase;user=omar;password=omar";
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    private String premission;
    
    public boolean login (String userName, String password){
        boolean athuntcated = false;
        try {
            // establish connection to database
            connection = DriverManager.getConnection(db_Url);
            
            // create Statement for querying database
            statement = connection.createStatement();
            
            // query database about user name and password
            resultSet = statement.executeQuery("SELECT permition FROM Employee where UserName = '"+userName+"' and user_password = '"+password+"'");
            
            if (athuntcated = resultSet.next())//if return a result that mean the user athuntcated
                premission = (String) resultSet.getObject(1);//get his premission
            
            //to close the conection with the db
            resultSet.close();
            statement.close();
            connection.close();
        }catch (SQLException e){//error message
            JOptionPane.showMessageDialog(null, "Can't connect with the database!", 
                                    "Error", JOptionPane.ERROR_MESSAGE);
        }finally{
            return athuntcated;
        }
    }
    
    public String getEmployeePremission(){
        return premission;
    }
    
    public void writeEmployee (int id, String name, String nationality, String premission, String userName, String password){
        
    }
    
    public void readEmployee (){
        
    }
    
    public void writeCustomer (String name, String email, String phone, String netionality, int age, String comming_date){
        
    }
    
    public void readCustomer (){
        
    }
    
    public void writeRoom (){
        
    }
    
    public void readRoom (){
        
    }
    
    public void writeService (){
        
    }
    
    public void readService (){
        
    }
}
