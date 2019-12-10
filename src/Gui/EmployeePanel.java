/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Database.EmployeeData;
import java.awt.*;
import javafx.scene.control.*;
import javax.swing.*;

/**
 *
 * @author HERO
 */
class EmployeePanel extends JPanel{

           TableColumn  Employee = new TableColumn("EmployeeTable") ;
        // Form
            JLabel EmployeeName ;
            JLabel EmployeeId ;
            JLabel EmployeePhone ;
            JLabel EmployeeNationality ;
            JLabel department ;
            JLabel Username ;
            JLabel permission ;
            JLabel password ;
            JTextField name ;
            JTextField id ;
            JTextField phone ;
            JComboBox nationality ;
            JComboBox permissionSelection;
            JTextField departmentField ;
            JTextField SetUsername ;
            JPasswordField SetPassword;
            // String of nationality
             String Nation [] ={"Egyption","Chinese","English","French","German","Italian","Japanese"
             ,"Russian","Spanish","American","Saudi Arabian","Australian","Belgian"} ;
             //string of permission
             String [] Permissions={"user_model","room_mangement","other_services"};
             //dimentional array for data coming from database 
             EmployeeData DataEmployee = new EmployeeData();
             //String of table column name can easily change
            String ColumnName[]={ "id","name","email","nationality","permission"};
            //_____________________________________________
            JButton Add ;
            JButton Delete ;
            JTable EmployeeTable ;
    public EmployeePanel() {
    Color c = new Color(173,216,230);
    
             this.setLayout(null);
        
        //_______________tables creation..____________________________________
//        tablecreation
        EmployeeTable = new JTable(DataEmployee); 
        JScrollPane scroll = new JScrollPane(EmployeeTable);//scroll 
        EmployeeTable.setToolTipText("Employee");
        
  //_______Table charactaristics_________________________________
        scroll.setBackground(Color.LIGHT_GRAY);
  //__________________________________________________________
//   panel describtion
   
        this.setBackground(c);
        this.setLayout(null);
        scroll.setBounds(10, 400,1000, 200);
        this.setBounds(250, 10, 1020, 650);

        this.add(scroll);
         EmployeeName = new JLabel("Employee Name") ;
        name = new JTextField(20) ;
        EmployeeName.setBounds(10, 10, 150, 20);
        this.add(EmployeeName);
        name.setBounds(100, 10, 150, 20);
        this.add(name);
     //_____________________________________________________
              EmployeeId = new JLabel("Employee ID") ;
              EmployeeId.setBounds(270, 10, 150, 20);
              id = new JTextField(10) ;
              id.setBounds(370, 10, 150, 20);
               this.add(EmployeeId);
               this.add(id);
    //___________________________________________________________________
                    EmployeePhone = new JLabel("Employee Phone") ;
                    EmployeePhone.setBounds(550, 10, 150, 20);
                    phone = new JTextField(20) ;
                    phone.setBounds(670, 10, 150, 20);
                         this.add(EmployeePhone);
                         this.add(phone);
   //__________________________________________________________________________
                ImageIcon  ADDIcon= new ImageIcon("C:\\Users\\HERO\\Desktop\\m3lsh_project\\src\\follower.png");
                ImageIcon  DeleteIcon= new ImageIcon("C:\\Users\\HERO\\Desktop\\m3lsh_project\\src\\delete.png");
  //____________________________________________________________________________
                                department = new JLabel("department") ;
                                    department.setBounds(10, 50, 150, 20);
                                departmentField = new JTextField(10) ;
                                   departmentField.setBounds(100, 50, 150, 20);
                                  this.add(department);
                                   this.add(departmentField);
   //_________________________________________________________
                                       Username = new JLabel("Set Username ") ;
                                        Username.setBounds(270, 50, 150, 20);
                                       SetUsername = new JTextField(10) ;
                                        SetUsername.setBounds(370, 50, 150, 20);
                                 this.add(Username);
                                 this.add(SetUsername);
     //__________________________________________________________
                          EmployeeNationality = new JLabel("Cutomer Nationality") ;
                          EmployeeNationality.setBounds(550, 50, 150, 20);
                          nationality = new JComboBox();
                          for (int i=0;i<Nation.length;i++){
                              nationality.addItem(Nation[i]);
                          }
                          
                          nationality.setBounds(670, 50, 150, 20);
                                 this.add(EmployeeNationality);
                                 this.add(nationality);
     //__________________________________this is the permission  label and combobox that take data from permissions array_________________________________________-
                                permission = new JLabel("permission");
                                permission.setBounds(10, 100, 150, 20);
                                this.add(permission);
                                permissionSelection= new JComboBox();
                                for (int i=0;i<Permissions.length;i++){
                                permissionSelection.addItem(Permissions[i]);
                                }
                                permissionSelection.setBounds(100, 100, 150, 20);
                                this.add(permissionSelection);
     //_____________________________ now set password label and field____________________________
                                password = new JLabel("Set Password");
                                password.setBounds(270, 100, 150, 20);
                                this.add(password);
                                
                                SetPassword = new JPasswordField();
                                SetPassword.setBounds(370, 100, 150, 20);
                                this.add(SetPassword);
                                
                                
                             Add = new JButton (ADDIcon); // add add button && Delete
                         Add.setBounds(10, 330, 100, 70);
                         this.add(Add);
                         Delete = new JButton (DeleteIcon);
                         Delete.setBounds(120, 330, 100, 70);
                         this.add(Delete);
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 this.setVisible(true);
    }                      
                     
}
