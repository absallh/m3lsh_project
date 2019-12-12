/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author HERO
 */
public class RoomManagement extends Employee {
     JFrame RoomFrame;
    //this is two panel that contain table and form of attribute 1 to gust and anothr for room
           Gust_management GustPanel  ; 
           Room_management_panel RoomPanel ;

   //selction button to select mode
            JButton Gust ;
            JButton Room ;
            
            //__________ this is 2 icons to user it with three button _______ room   gust 
          ImageIcon GustIcon = 
                  new ImageIcon("C:\\Users\\HERO\\Desktop\\m3lsh_project\\src\\guest-list.png");
          ImageIcon RoomIcon = 
                  new ImageIcon("C:\\Users\\HERO\\Desktop\\m3lsh_project\\src\\key-card.png");
    
          public RoomManagement() {
            RoomFrame = new JFrame();
          }
    
    
    @Override
    public void work (){
        Color c =new Color(0,191,255);
        RoomFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RoomFrame.setSize(1500, 900);
        RoomFrame.setLocation(0,0);
        RoomFrame.setTitle("Room mangement");
        RoomFrame.getContentPane().setBackground(c);
        RoomFrame.setLayout(null);
        
        GustPanel = new Gust_management();
        RoomPanel = new Room_management_panel();
        
        myhandler hand = new myhandler ();
        
        Gust = new JButton(GustIcon);

        Gust.addActionListener(hand);
        
        Room = new JButton(RoomIcon);
        
        Room.addActionListener(hand);
        
        
        
        
        GustPanel.setBounds(250, 10, 1020, 650);
        RoomPanel.setBounds(250, 10, 1020, 650);
        
        Gust.setBounds(10,10, 200,300);
        Room.setBounds(10, 350, 200, 300);
        
        RoomFrame.add(Gust);
        RoomFrame.add(Room);
        RoomFrame.add(GustPanel);
        RoomFrame.add(RoomPanel);
        
        // ensure database connection is closed when user quits application
      RoomFrame.addWindowListener(      
         new WindowAdapter() 
         {
            // disconnect from database and exit when window has closed
            @Override
            public void windowClosed( WindowEvent event )
            {
               GustPanel.CoustomerData.disconnectFromDatabase();
               RoomPanel.RoomData.disconnectFromDatabase();
               System.exit( 0 );
            } // end method windowClosed
         } // end WindowAdapter inner class
      ); // end call to addWindowListener
        RoomFrame.setVisible(true);
    }
  class myhandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object ss = e.getSource();
            if (ss==Gust)
            {
                GustPanel.setVisible(true);
                RoomPanel.setVisible(false);
            }
            else if (ss== Room)
            {
                GustPanel.setVisible(false);
                RoomPanel.setVisible(true);
            }
        }
     }
  }