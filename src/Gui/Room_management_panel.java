/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import Database.Room_data;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author HERO
 */
public class Room_management_panel extends JPanel{
      JLabel Filter ;
      JComboBox filterrooms ;
      String [] ColumnName={"Room Name","Room Number ","Room Price","Busy OR Not"};
      protected Room_data RoomData= new Room_data();
      JTable ROOMTable ;
      String []filter ={"None" , "Busy", "NotBusy" , "Single", "Double", "Quad", "Studio", "Suites"};
      JComboBox AssignRoom ;
      JLabel Assign_Room ;
      String []roomData = {"Room number", "Type"};
      Color c =new Color(0,255,127);
    public Room_management_panel() {
        this.setLayout(null);
        this.setBackground(c);
        this.setBounds(250, 10, 1020, 650);
                //_______________tables creation..____________________________________
        ROOMTable= new JTable(RoomData);
                //_______Table charactaristics________
        JScrollPane sc = new JScrollPane(ROOMTable);
        sc.setBounds(10, 50,1000, 200);
           ROOMTable.setBackground(Color.WHITE);
        this.add(sc);
     //________________________________ filter room with combobox_________________________________________
             Filter = new JLabel("Filter ") ;
                          Filter.setBounds(750, 30, 100, 20);
                          filterrooms = new JComboBox(filter);
                          
                          filterrooms.setBounds(850, 30, 120, 20);
                                 this.add(Filter);
                                 this.add(filterrooms);
      //_____________________________________________________________________________
                      Assign_Room =new JLabel("Assign Room to the Gust");
                      Assign_Room.setBounds(210, 350, 200, 150);
                      this.add(Assign_Room);
                      AssignRoom = new JComboBox(roomData);
                      AssignRoom.setBounds(200, 450, 150, 20);
                      this.add(AssignRoom);        
        
        this.setVisible(true);
    }
    
     private class filterAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            //String []filter ={"None" , "Busy", "NotBusy" , "Single", "Double", "Quad", "Studio", "Suites"};
             String s = (String) filterrooms.getSelectedItem();//get the selected item
             switch (s){
                 case "None":
                     RoomData.setQuery(RoomData.DEFULT_QUERY);
                     break;
                 case "Busy":
                     RoomData.setQuery("select * from Room where boolean_busy = 'true'");
                     break;
                 case "NotBusy":
                     RoomData.setQuery("select * from Room where boolean_busy = 'false'");
                     break;
                 case "Single":
                     RoomData.setQuery("select * from Room where Room_type = 'Single'");
                     break;
                 case "Double":
                     RoomData.setQuery("select * from Room where Room_type = 'Double'");
                     break;
                 case "Quad":
                     RoomData.setQuery("select * from Room where Room_type = 'Quad'");
                    break;
                 case "Studio":
                     RoomData.setQuery("select * from Room where Room_type = 'Studio'");
                     break;
                 case "Suites":
                     RoomData.setQuery("select * from Room where Room_type = 'Suites'");
                     break;
             }
        }
    }
    
    
}
