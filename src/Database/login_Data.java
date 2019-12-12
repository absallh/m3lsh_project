/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author absal
 */
public class login_Data{
    private String premission;
    private Connection connection = null;
    private Statement statement = null;
    private ResultSet resultSet = null;
    public boolean login (String userName, String password){
        boolean athuntcated = false;
        try {
            // establish connection to database
            connection = DriverManager.getConnection(Data.db_Url);
            
            // create Statement for querying database
            statement = connection.createStatement();
            
            // query database about user name and password
            resultSet = statement.executeQuery("SELECT permition FROM Employee where UserName = '"
                    +userName+"' and user_password = '"+password+"'");
            
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
}