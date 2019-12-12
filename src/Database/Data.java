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
    
    protected static final String db_Url = "jdbc:sqlserver://localhost:1433;databaseName=HotelDataBase;user=omar;password=omar";
    protected Connection connection = null;
    protected Statement statement = null;
    protected ResultSet resultSet = null;
    protected ResultSetMetaData metaData;
    protected int numberOfRows;
    
    // keep track of database connection status
   protected static boolean connectedToDatabase = false;
    
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
    
    public void setQuery (String query){
        try {
            // specify query and execute it
            resultSet = statement.executeQuery( query );
            
            // obtain meta data for ResultSet
            metaData = resultSet.getMetaData();
            
            // determine number of rows in ResultSet
            resultSet.last();                   // move to last row
            numberOfRows = resultSet.getRow();  // get row number      

            // notify JTable that model has changed
            fireTableStructureChanged();
        } catch (SQLException ex) {
            ex.printStackTrace();
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
    
        @Override
    public int getColumnCount() {
        // ensure database connection is available
      if (connectedToDatabase )
      {
            // determine number of columns
            try 
            {
               return metaData.getColumnCount(); 
            } // end try
            catch ( SQLException sqlException ) 
            {
               sqlException.printStackTrace();
            } // end catch
      }
      return 0; // if problems occur above, return 0 for number of columns
    }
    
    // get class that represents column type
    @Override
   public Class getColumnClass( int column ) throws IllegalStateException
   {
      // ensure database connection is available
      if ( !connectedToDatabase ) 
         throw new IllegalStateException( "Not Connected to Database" );
      
      
      return Object.class; // if problems occur above, assume type Object
   } // end method getColumnClass
    
   @Override
   public String getColumnName( int column )
   {    
      // ensure database connection is available
      if ( connectedToDatabase ) {

            // determine column name
            try 
            {
               return metaData.getColumnName( column + 1 );  
            } // end try
            catch ( SQLException sqlException ) 
            {
               sqlException.printStackTrace();
            } // end catch
        }
      return ""; // if problems, return empty string for column name
   } // end method getColumnName

   
    @Override
    public int getRowCount() {
        if (connectedToDatabase)
            return numberOfRows;
        
        return 0;
    }

    @Override
    public Object getValueAt(int row, int column) {
        if (connectedToDatabase){
            // obtain a value at specified ResultSet row and column
            try 
            {
               resultSet.absolute( row + 1 );
               return resultSet.getObject( column + 1 );
            } // end try
            catch ( SQLException sqlException ) 
            {
               sqlException.printStackTrace();
            } // end catch
        }
        return "";// if problems, return empty string object
    }

}
