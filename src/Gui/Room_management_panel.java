/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import control.room_mangement;
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
    room_mangement roomMange;  
    
    JLabel Filter ;
      JComboBox filterrooms ;
      JTable ROOMTable ;
      String []filter ={"None" , "Busy", "NotBusy" , "Single", "Double", "Quad", "Studio", "Suites"};
      String []roomData = {"Room number", "Type"};
      Color c =new Color(0,255,127);
    public Room_management_panel(room_mangement roomMange) {
        this.roomMange = roomMange;
        
        this.setLayout(null);
        this.setBackground(c);
        this.setBounds(250, 10, 1020, 650);
                //_______________tables creation..____________________________________
        ROOMTable= new JTable(roomMange.getRoomData());
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
                          filterrooms.addActionListener(new filterAction());
                                 this.add(Filter);
                                 this.add(filterrooms);
      //_____________________________________________________________________________
                      
        this.setVisible(true);
    }
    
     private class filterAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            //String []filter ={"None" , "Busy", "NotBusy" , "Single", "Double", "Quad", "Studio", "Suites"};
             roomMange.filter((String) filterrooms.getSelectedItem());
        }
    }
    
    
}
