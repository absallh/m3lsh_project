/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Database.EmployeeData;
import control.user_model;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
            JLabel Username ;
            JLabel permission ;
            JLabel password ;
            JTextField name ;
            JTextField id ;
            JTextField phone ;
            JComboBox nationality ;
            JComboBox permissionSelection;
            JTextField SetUsername ;
            JPasswordField SetPassword;
            // String of nationality
             String Nation [] ={"Egyption","Chinese","English","French","German","Italian","Japanese"
             ,"Russian","Spanish","American","Saudi Arabian","Australian","Belgian"} ;
             //string of permission
             String [] Permissions={"none", "user_model","room_mangement","other_services"};
             //dimentional array for data coming from database 
             EmployeeData DataEmployee = new EmployeeData();
            //_____________________________________________
            JButton Add ;
            JButton Delete ;
            JButton update;
            JTable EmployeeTable ;
            
            user_model user_control;
    public EmployeePanel(user_model user_control) {
        
        this.user_control = user_control;
        
    Color c = new Color(173,216,230);
    
             this.setLayout(null);
        
        //_______________tables creation..____________________________________
//        tablecreation
        EmployeeTable = new JTable(user_control.getDataEmployee()); 
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
    
   //__________________________________________________________________________
                ImageIcon  ADDIcon= new ImageIcon(getClass().getResource("follower.png"));
                ImageIcon  DeleteIcon= new ImageIcon(getClass().getResource("delete.png"));
                ImageIcon  UpdateIcon= new ImageIcon(getClass().getResource("Update.png"));

  //____________________________________________________________________________
                                        Username = new JLabel("Set Username ") ;
                                        Username.setBounds(270, 50, 150, 20);
                                       SetUsername = new JTextField(10) ;
                                        SetUsername.setBounds(370, 50, 150, 20);
                                 this.add(Username);
                                 this.add(SetUsername);
     //__________________________________________________________
                          EmployeeNationality = new JLabel("Employee Nationality") ;
                          EmployeeNationality.setBounds(550, 10, 150, 20);
                          nationality = new JComboBox(Nation);
                          
                          nationality.setBounds(670, 10, 150, 20);
                                 this.add(EmployeeNationality);
                                 this.add(nationality);
     //__________________________________this is the permission  label and combobox that take data from permissions array_________________________________________-
                                permission = new JLabel("permission");
                                permission.setBounds (10, 50, 150, 20);
                                this.add(permission);
                                permissionSelection= new JComboBox(Permissions);
                                
                                permissionSelection.setBounds(100, 50, 150, 20);
                                this.add(permissionSelection);
     //_____________________________ now set password label and field____________________________
                                password = new JLabel("Set Password");
                                password.setBounds(550, 50, 150, 20);
                                this.add(password);
                                
                                SetPassword = new JPasswordField();
                                SetPassword.setBounds(670, 50, 150, 20);
                                this.add(SetPassword);
                                
                                
                             Add = new JButton (ADDIcon); // add add button && Delete
                         Add.setBounds(10, 330, 100, 70);
                         this.add(Add);
                         Delete = new JButton (DeleteIcon);
                         Delete.setBounds(120, 330, 100, 70);
                         this.add(Delete);
                                 
                           update = new JButton(UpdateIcon);
                           update.setBounds(230, 330, 100, 70);
                           this.add(update);
                                 
                                 buttonAction action = new buttonAction();
                 Add.addActionListener(action);
                 Delete.addActionListener(action);
                 update.addActionListener(action);
                 EmployeeTable.addMouseListener(new tableMouseListener());
                 EmployeeTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                 
                 
                                 this.setVisible(false);
    }                      
    int row;//the selected row index
    private class tableMouseListener extends MouseAdapter{
      @Override
      public void mouseClicked(MouseEvent e) {
            row = EmployeeTable.rowAtPoint(e.getPoint());//get mouse-selected row
            //int col = GustTable.columnAtPoint(e.getPoint());//get mouse-selected col
            id.setText(String.format("%s", EmployeeTable.getValueAt(row, 0)));
            id.setEditable(false);
            name.setText(String.format("%s", EmployeeTable.getValueAt(row, 1)));
            nationality.setSelectedItem(EmployeeTable.getValueAt(row, 2));
            permissionSelection.setSelectedItem(EmployeeTable.getValueAt(row, 3));
            SetUsername.setText(String.format("%s", EmployeeTable.getValueAt(row, 4)));
            SetUsername.setEditable(false);
        }
    }
    
    private class buttonAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == Add){
                if(!EmployeeTable.getSelectionModel().isSelectionEmpty()){
                    id.setText("");
                    id.setEditable(true);
                    name.setText("");
                    nationality.setSelectedIndex(0);
                    permissionSelection.setSelectedIndex(0);
                    SetUsername.setText("");
                    SetUsername.setEditable(true);
                    SetPassword.setText("");
                    EmployeeTable.getSelectionModel().clearSelection();
                }else{
                    if(user_control.addEmployee(Integer.parseInt(id.getText()), name.getText(), 
                            (String)nationality.getSelectedItem(), (String)permissionSelection.getSelectedItem(),
                            SetUsername.getText(), SetPassword.getText()))
                    {
                        JOptionPane.showMessageDialog(null, "Added successfully");
                    }else{
                        JOptionPane.showMessageDialog(null, "can't add exist id or user name","input Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                
            }
            else if (EmployeeTable.getSelectionModel().isSelectionEmpty()){
                JOptionPane.showMessageDialog(null, "select any Employee to edite or delete", "Missing Selection", JOptionPane.INFORMATION_MESSAGE);
            }else{
                if (ae.getSource() == Delete){
                    user_control.deleteEmployee((int) EmployeeTable.getValueAt(row, 0));
                    
                    JOptionPane.showMessageDialog(null, "deleted successfully");
                }
                else if (ae.getSource() == update){
                    user_control.updateEmployee((int) EmployeeTable.getValueAt(row, 0), 
                            name.getText(), (String)nationality.getSelectedItem(), 
                            (String)permissionSelection.getSelectedItem(),
                            SetUsername.getText(), SetPassword.getText());
                    
                    JOptionPane.showMessageDialog(null, "updated successfully");
                }
            }
        }
        
    }
    
}
