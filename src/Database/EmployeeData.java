package Database;

import java.sql.SQLException;

public class EmployeeData extends Data{
    public EmployeeData (){
        try {
            // specify query and execute it
            resultSet = statement.executeQuery( "SELECT * FROM employee" );
            
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
