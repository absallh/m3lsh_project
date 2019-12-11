/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author absal
 */
public abstract class Data extends AbstractTableModel{
    
    protected static final String db_Url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDataBase;user=log;password=123";
    protected Connection connection = null;
    protected Statement statement = null;
    protected ResultSet resultSet = null;
    protected ResultSetMetaData metaData;
    protected int numberOfRows;
    
    // keep track of database connection status
   protected boolean connectedToDatabase = false;
    
    public Data (){
        try{
            // connect to database
            connection = DriverManager.getConnection(db_Url);
            
            // create Statement to query database
            statement = connection.createStatement( 
               ResultSet.TYPE_SCROLL_INSENSITIVE,
               ResultSet.CONCUR_READ_ONLY );
            
            connectedToDatabase = true;
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Can't connect with Data Base", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
    
    public void disconnectFromDatabase()            
   {              
      if ( connectedToDatabase )                  
      {
         // close Statement and Connection            
         try                                          
         {                                            
            resultSet.close();                        
            statement.close();                        
            connection.close();                       
         } // end try                                 
         catch ( SQLException sqlException )          
         {                                            
            sqlException.printStackTrace();           
         } // end catch                               
         finally  // update database connection status
         {                                            
            connectedToDatabase = false;              
         } // end finally                             
      } // end if
   } // end method disconnectFromDatabase
    
}
