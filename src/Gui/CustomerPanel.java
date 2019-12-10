/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import control.Data;
import control.room;
import control.service;
import java.awt.*;
import java.util.ArrayList;
import javafx.scene.control.*;
import javax.swing.*;

/**
 *
 * @author HERO
 */
class CustomerPanel extends JPanel {

          TableColumn  Customer_Name = new TableColumn("name") ;
        // Form
            JLabel CustomerName ;
            JLabel CustomerId ;
            JLabel CustomerPhone ;
            JLabel CustomerNationality ;
            JLabel commingDate ;
            JLabel ccheckOut ;
            JLabel RoomChoice;
            JLabel ServicesChoice ;
            JTextField name ;
            JTextField id ;
            JTextField phone ;
            JComboBox nationality ;
            JTextField checkin ;
            JTextField checkout ;
            // Deficult m3lesh tell me what i do because i dont know
            JList selectservice ;
            JComboBox selectroom ;
            //SOME ARRAY OF STRING FIRST FOR TABLE COLUMN NAME AND SECPND FOR NATIONALITY
            String [] ColumnName={"id","name","nationality","checkin Date","checkout","Services","AssginedRoom","Phone"};
            Data[][]CoustomerData= new Data[200][200];
             String Nation [] ={"Egyption","Chinese","English","French","German","Italian","Japanese"
             ,"Russian","Spanish","American","Saudi Arabian","Australian","Belgian"} ;
             ArrayList<room> SelctionRoom  = new ArrayList<>();
             service [] serviceSelection ;
//             this is array list from room type
            //_____________________________________________
            JButton Add ;
            JButton Delete ;
            JTable CustomerTable ;
                Color c = new Color(173,216,230);

    public CustomerPanel() {
                            // Panel Colore and positions in frame
        this.setLayout(null);
        this.setBackground(c);
        //_______________tables creation..____________________________________
        CustomerTable= new JTable(CoustomerData,ColumnName);
        JScrollPane sc = new JScrollPane(CustomerTable);
//        sc.setBounds(10, 400,1000, 200);
//        this.add(sc);
        //_______Table charactaristics_________________________________
        CustomerTable.setBackground(Color.WHITE);
        
        sc.setBounds(10, 400,1000, 200);
        
        this.setBounds(250, 10, 1020, 650);
             this.add(sc);
 //______________________________________________________________________
   
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
                          // icons ADD &Delete
                ImageIcon  ADDIcon= new ImageIcon("C:\\Users\\HERO\\Desktop\\m3lsh_project\\src\\follower.png");
                ImageIcon  DeleteIcon= new ImageIcon("C:\\Users\\HERO\\Desktop\\m3lsh_project\\src\\delete.png");


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
                          for (int i =0 ;i<Nation.length;i++){
                              
                          nationality.addItem(Nation[i]);     
                          
                          }
                          nationality.setBounds(670, 50, 150, 20);
                                 this.add(CustomerNationality);
                                 this.add(nationality);
      //______________________________Combo box to select room ________________________
                                 RoomChoice = new JLabel("RoomChoice");
                                 RoomChoice.setBounds(10, 100, 150, 20);
                                 this.add(RoomChoice);
                               selectroom = new JComboBox();
                               int i=0;
                               while (! SelctionRoom.isEmpty()){
                               selectroom.addItem(SelctionRoom.get(i));
                               i++;
                               }
                               selectroom.setBounds(100, 100, 150, 20);
                               this.add(selectroom);
     //__________________________________________________________________________________________________
                              String data[]={"ahmed","abdalah","mohamed","ahmed","abdalah","mohamed","ahmed","abdalah","mohamed"
                                  
                              };
                               ServicesChoice = new JLabel("ServiceChoice");
                               ServicesChoice.setBounds(270, 100, 150, 20);
                               this.add(ServicesChoice);
                               selectservice = new JList(data);
                               JScrollPane scrollList = new JScrollPane(selectservice);
                               scrollList.setBounds(370, 100, 150, 50);
                               this.add(scrollList);
                               
      //____________________________________________________________________________________________                       
                         Add = new JButton (ADDIcon); // add add button && Delete
                         Add.setBounds(10, 330, 100, 70);
                         this.add(Add);
                         Delete = new JButton (DeleteIcon);
                         Delete.setBounds(120, 330, 100, 70);
                         this.add(Delete);
                         
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 
                                 this.setVisible(true);
    }                      
                     
    
}
