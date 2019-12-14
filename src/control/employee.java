package control;

import Database.EmployeeData;
import javax.swing.JOptionPane;

public class employee extends person {
    protected String permission;
    protected String Username ;
    protected String password ;
    private EmployeeData DataEmployee;
    
    public employee (){
        DataEmployee = new EmployeeData();
    }
    
    public void work(){
        JOptionPane.showMessageDialog(null, "Call the admin to set your permission");
    }
    
    public EmployeeData getDataEmployee (){
        return DataEmployee;
    }

    @Override
    public void delete(int id) {
        DataEmployee.delete(id);
    }
    
    public void update (int id, String name, String nationality, 
            String premission, String userName, String Password){
        DataEmployee.update(id, name, nationality, premission, userName, Password);
    }
    
    public boolean add (int id, String name, String nationality, 
            String premission, String userName, String Password){
        return DataEmployee.add(id, name, nationality, premission, userName, Password);
    }
    
    public void disconnect (){
        DataEmployee.disconnectFromDatabase();
    }
}
