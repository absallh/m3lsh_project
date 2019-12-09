package control;

import javax.swing.JOptionPane;

public class employee extends person {
    protected String department;
    protected String permission;
    protected employee employ;
    protected String Username ;
    protected String password ;
    
    public employee (){
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    
    public void work(){
        JOptionPane.showMessageDialog(null, "Ask the admin to sit your premissions", "Alert", JOptionPane.WARNING_MESSAGE);
    }

    @Override
    void update() {
        
    }

    @Override
    void delete(int id) {
        
    }
}
