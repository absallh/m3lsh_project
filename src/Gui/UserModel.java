/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import control.user_model;
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
public class UserModel extends Employee{
    
    user_model user_control;
    
    JFrame userFrame;
    //this is three panel that contain table and form of attribute 1 to customer , 2 to employee and 3 for service
            CustomerPanel CustomerPanel ; 
            EmployeePanel EmployeePanel ;
            Services_panel ServicesPanel ;
            Room_Panel RoomPanel;
   //selction button to select mode
            JButton cust ;
            JButton emp ;
            JButton serv ;
            JButton Room ;
            
            //__________ this is 3 icons to user it with three button _______ customer , employee and services
            ImageIcon CutomerIcon = new ImageIcon(getClass().getResource("Office-Customer-Male-Light-icon.png"));
            ImageIcon EmployeeIcon = new ImageIcon(getClass().getResource("employee.png"));
            ImageIcon ServicesIcon = new ImageIcon(getClass().getResource("Network_Service_Icon_128.png"));
            ImageIcon RoomIcon = new ImageIcon(getClass().getResource("icons8-room-64.png"));
            
    public UserModel() {
        userFrame = new JFrame();
}
    
    
    @Override
    public void work (){
        user_control = new user_model();
        
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setSize(1500, 900);
        userFrame.setLocation(0,0);
        userFrame.setTitle("User");
        userFrame.getContentPane().setBackground(Color.GRAY);
        userFrame.setLayout(null);
        

  //__________________________________________________________
//   panel describtion
   
        CustomerPanel = new CustomerPanel(user_control) ;
        
        EmployeePanel = new EmployeePanel(user_control);

        ServicesPanel = new Services_panel(user_control);
        
        RoomPanel = new  Room_Panel (user_control);
        
        CustomerPanel.setBounds(250, 10, 1020, 650);
        EmployeePanel.setBounds(250, 10, 1020, 650);
        ServicesPanel.setBounds(250, 10, 1020, 650);
        RoomPanel.setBounds(250, 10, 1020, 650);
////______________________________________________________
     // create  Action handling  hand
        myhandler hand = new myhandler ();
        
        cust = new JButton(CutomerIcon);

        cust.addActionListener(hand);
        
        emp = new JButton(EmployeeIcon);
        
        emp.addActionListener(hand);
        
        serv = new JButton(ServicesIcon);
        
        serv.addActionListener(hand);
        
        Room = new JButton(RoomIcon);
        Room.addActionListener(hand);
        
        cust.setBounds(10,10, 200,150);
        emp.setBounds(10, 180, 200, 150);
        serv.setBounds(10,360, 200, 150);
        Room.setBounds(10,540, 200, 150);
        // add to frame 
        userFrame.add(cust);
        userFrame.add(emp);
        userFrame.add(serv);
        userFrame.add(Room);
        userFrame.add(CustomerPanel);
        userFrame.add(EmployeePanel);
        userFrame.add(ServicesPanel);        
        userFrame.add(RoomPanel);    
        
        // ensure database connection is closed when user quits application
      userFrame.addWindowListener(      
         new WindowAdapter() 
         {
            // disconnect from database and exit when window has closed
            @Override
            public void windowClosed( WindowEvent event )
            {
               user_control.close();
               System.exit( 0 );
            } // end method windowClosed
         } // end WindowAdapter inner class
      ); // end call to addWindowListener
         
        userFrame.setVisible(true);
    }
    
    
    class myhandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object ss = e.getSource();
            if (ss==cust)
            {
                CustomerPanel.show(true);
                EmployeePanel.show(false);
                ServicesPanel.show(false);
                RoomPanel.show(false);
            }
            else if (ss== emp)
            {
                CustomerPanel.show(false);
                EmployeePanel.show(true);
                ServicesPanel.show(false);
                RoomPanel.show(false);
            }
            else if (ss== serv)
            {
                CustomerPanel.show(false);
                EmployeePanel.show(false);
                ServicesPanel.show(true);
                RoomPanel.show(false);        
            }
            else if (ss== Room)
            {
                 CustomerPanel.show(false);
                 EmployeePanel.show(false);
                 ServicesPanel.show(false);
                 RoomPanel.show(true);    
            }
      }
   }      
}

