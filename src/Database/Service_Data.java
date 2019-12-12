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
 public Service_Data (){
        try {
            // specify query and execute it
            resultSet = statement.executeQuery( "SELECT * FROM servicee" );
            
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
