/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import control.Data;
import control.room;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author HERO
 */
public class Room_management extends JPanel{
      JLabel Filter ;
      JComboBox filterrooms ;
      String [] ColumnName={"Room Name","Room Number ","Room Price","Busy OR Not"};
      Data[][]RoomData= new Data[100][100];
      JTable ROOMTable ;
      String []filter ={"None , Busy , NotBusy , Type"};
      JComboBox AssignRoom ;
      JLabel Assign_Room ;
      String []roomData = {"Room number", "Type"};

    public Room_management() {
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.setBounds(250, 10, 1020, 650);
                //_______________tables creation..____________________________________
        ROOMTable= new JTable(RoomData,ColumnName);
                //_______Table charactaristics________
        JScrollPane sc = new JScrollPane(ROOMTable);
        sc.setBounds(220, 400,1000, 200);
           ROOMTable.setBackground(Color.WHITE);
        this.add(sc);
     //________________________________ filter room with combobox_________________________________________
             Filter = new JLabel("Filter ") ;
                          Filter.setBounds(650, 30, 120, 20);
                          filterrooms = new JComboBox();
                          for (int i =0 ;i<filter.length;i++){
                              
                          filterrooms.addItem(filter[i]);     
                          
                          }
                          filterrooms.setBounds(850, 30, 120, 20);
                                 this.add(Filter);
                                 this.add(filterrooms);
      //_____________________________________________________________________________
                      Assign_Room =new JLabel("Assign Room to the Gust");
                      Assign_Room.setBounds(500, 100, 150, 150);
                      this.add(Assign_Room);
                      AssignRoom = new JComboBox();
                      for(int i =0;i<roomData.length;i++){
                        AssignRoom.addItem(roomData[i]);
                      }
                      Assign_Room.setBounds(500, 150, 150, 150);
                      this.add(Assign_Room);
                      
                                 
                                 
        
        this.setVisible(true);
    }
    
}
