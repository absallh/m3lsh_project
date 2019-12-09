/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
           Room_management RoomPanel ;

   //selction button to select mode
            JButton Gust ;
            JButton Room ;
            
            //__________ this is 3 icons to user it with three button _______ customer , employee and services
//            ImageIcon CutomerIcon = new ImageIcon("C:\\Users\\HERO\\Desktop\\m3lsh_project\\src\\Office-Customer-Male-Light-icon.png");
//            ImageIcon EmployeeIcon = new ImageIcon("C:\\Users\\HERO\\Desktop\\m3lsh_project\\src\\employee.png");
//            ImageIcon ServicesIcon = new ImageIcon("C:\\Users\\HERO\\Desktop\\m3lsh_project\\src\\Network_Service_Icon_128.png");
//            
    public RoomManagement() {
        RoomFrame = new JFrame();
    }
    
    
    @Override
    public void work (){
        RoomFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RoomFrame.setSize(1500, 900);
        RoomFrame.setLocation(0,0);
        RoomFrame.setTitle("Login");
        RoomFrame.getContentPane().setBackground(Color.GRAY);
        RoomFrame.setLayout(null);
        
        GustPanel = new Gust_management();
//        RoomPanel = new Room_management();
        
        myhandler hand = new myhandler ();
        
        Gust = new JButton("Gust");

        Gust.addActionListener(hand);
        
        Room = new JButton("Room");
        
        Room.addActionListener(hand);
        
        
        
//        
//        GustPanel.setBounds(250, 10, 1020, 650);
//        RoomPanel.setBounds(250, 10, 1020, 650);
        
        Gust.setBounds(10,10, 200,300);
        Room.setBounds(10, 300, 200, 300);
        
        RoomFrame.add(Gust);
        RoomFrame.add(Room);
        RoomFrame.add(GustPanel);
        RoomFrame.add(RoomPanel);
        
        
        RoomFrame.setVisible(true);
        

    
    }
  class myhandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object ss = e.getSource();
            if (ss==Gust)
            {
                GustPanel.show(true);
                RoomPanel.show(false);
            }
            else if (ss== Room)
            {
                GustPanel.show(false);
                RoomPanel.show(true);
            }
        }
     }
  }