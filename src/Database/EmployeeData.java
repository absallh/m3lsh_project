package Database;

import java.sql.SQLException;

public class EmployeeData extends Data{
    public static final String DEFUALT_QUERY = "select id, employee_name, "+
            "nationality, permition, UserName from Employee";
    
    public EmployeeData (){
        setQuery(DEFUALT_QUERY);
    }
    
    public boolean add(int id, String name, String nationality, 
            String premission, String userName, String Password){
        
        String insertTransaction = "INSERT INTO Employee "
                +"values ("+id+",'"+name+"','"+nationality+"','"
                +premission+"','"+userName+"','"+Password+"')";
        try {
            resultSet = statement.executeQuery("select id from Employee where id = "+
                    id+" or UserName = '"+userName+"'");
            if (resultSet.next()){//check if the id exist or not
                setQuery(DEFUALT_QUERY);
                return false;
            }else{
                statement.executeUpdate(insertTransaction);//insert into the DB
                setQuery(DEFUALT_QUERY);
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            setQuery(DEFUALT_QUERY);
            return false;
        }
    }
    
    public void delete (int ID){
        try {
            String deleteStatment = "delete from Employee where id = "+ID;
            statement.executeUpdate(deleteStatment);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally{
            setQuery(DEFUALT_QUERY);
        }
    }
    
    public void update (int id, String name, String nationality, 
            String premission, String userName, String Password){
        String qury = "update Employee\n" +"set id = "+id+
                ", employee_name = '"+name+"', nationality = '"+nationality+
                "', permition = '"+premission+"', UserName = '"+userName+
                "', user_password = '"+Password+"' \n" +
                "where id = "+id;
        try {
            statement.executeUpdate(qury);
        }catch (SQLException e)
        {
            e.printStackTrace();
        }finally{
            setQuery(DEFUALT_QUERY);
        }
    }

}
