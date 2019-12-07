/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.*;
import javafx.scene.control.*;
import javax.swing.*;

/**
 *
 * @author HERO
 */
class EmployeePanel extends JPanel{

           TableColumn  Customer_Name = new TableColumn("name") ;
        // Form
            JLabel CustomerName ;
            JLabel CustomerId ;
            JLabel CustomerPhone ;
            JLabel CustomerNationality ;
            JLabel commingDate ;
            JLabel ccheckOut ;
            JTextField name ;
            JTextField id ;
            JTextField phone ;
            JComboBox nationality ;
            JTextField checkin ;
            JTextField checkout ;
            // Deficult m3lesh tell me what i do because i dont know
            JRadioButton selectservice ;
            JRadioButton selectroom ;
            //_____________________________________________
            JButton generateBill ;
            JButton Add ;
            JButton Delete ;
            JTable t1 ;
    public EmployeePanel() {
    
    
             this.setLayout(null);
        
        //_______________tables creation..____________________________________
        t1 = new JTable(15,10);
        String aColumn = "Customer";
        t1.setToolTipText(aColumn);
        
        //_______Table charactaristics_________________________________
        t1.setBackground(Color.WHITE);
  //__________________________________________________________
//   panel describtion
   
        this.setBackground(Color.LIGHT_GRAY);
        this.setLayout(null);
        t1.setBounds(10, 400,1000, 200);
        this.setBounds(250, 10, 1020, 650);

        this.add(t1);
         CustomerName = new JLabel("Cutomer Name") ;
        name = new JTextField(20) ;
        CustomerName.setBounds(10, 10, 150, 20);
        this.add(CustomerName);
        name.setBounds(100, 10, 150, 20);
        this.add(name);
     //_____________________________________________________
              CustomerId = new JLabel("Cutomer ID") ;
              CustomerId.setBounds(270, 10, 150, 20);
              id = new JTextField(10) ;
              id.setBounds(370, 10, 150, 20);
               this.add(CustomerId);
               this.add(id);
    //___________________________________________________________________
                    CustomerPhone = new JLabel("Cutomer Phone") ;
                    CustomerPhone.setBounds(550, 10, 150, 20);
                    phone = new JTextField(20) ;
                    phone.setBounds(670, 10, 150, 20);
                         this.add(CustomerPhone);
                         this.add(phone);
   //__________________________________________________________________________
                          
  //____________________________________________________________________________
                                commingDate = new JLabel("Check In Date") ;
                                    commingDate.setBounds(10, 50, 150, 20);
                                checkin = new JTextField(10) ;
                                   checkin.setBounds(100, 50, 150, 20);
                                  this.add(commingDate);
                                   this.add(checkin);
   //_________________________________________________________
                                       ccheckOut = new JLabel("Check Out Date ") ;
                                        ccheckOut.setBounds(270, 50, 150, 20);
                                       checkout = new JTextField(10) ;
                                        checkout.setBounds(370, 50, 150, 20);
                                 this.add(ccheckOut);
                                 this.add(checkout);
     //__________________________________________________________
                          CustomerNationality = new JLabel("Cutomer Nationality") ;
                          CustomerNationality.setBounds(550, 50, 150, 20);
                          nationality = new JComboBox();
                          nationality.addItem("Egyption");
                          nationality.addItem("Chinese");
                          nationality.addItem("English");
                          nationality.addItem("French");
                          nationality.addItem("German");
                          nationality.addItem("Italian");
                          nationality.addItem("Japanese");        
                          nationality.addItem("Russian");
                          nationality.addItem("Spanish");
                          nationality.addItem("American");
                          nationality.addItem("Saudi Arabian");
                          nationality.addItem("Australian");
                          nationality.addItem("Belgian");  
                          
                          nationality.setBounds(670, 50, 150, 20);
                                 this.add(CustomerNationality);
                                 this.add(nationality);
                         generateBill = new JButton ("Bill");
                         generateBill.setBounds(250, 250, 100, 50);
                         this.add(generateBill);
                         Add = new JButton ("ADD");
                         Add.setBounds(350, 250, 100, 50);
                         this.add(Add);
                         Delete = new JButton ("Delete");
                         Delete.setBounds(450, 250, 100, 50);
                         this.add(Delete);
     
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 this.setVisible(true);
    }                      
                     
}
