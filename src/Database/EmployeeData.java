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
}
