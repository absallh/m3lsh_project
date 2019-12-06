package control;

import javax.swing.JOptionPane;

public class employee extends person {
    protected double salary;
    protected String department;
    protected String Date_of_hiring;
    protected double bonus;
    protected double deduction;
    protected String permission;
    protected employee employ;
    
    public employee (){
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDate_of_hiring() {
        return Date_of_hiring;
    }

    public void setDate_of_hiring(String Date_of_hiring) {
        this.Date_of_hiring = Date_of_hiring;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public double getDeduction() {
        return deduction;
    }

    public void setDeduction(double deduction) {
        this.deduction = deduction;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    void add() {
        person_Data.writeEmployee(id, name, email, phone, nationality, age, salary, Date_of_hiring, permission);
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
