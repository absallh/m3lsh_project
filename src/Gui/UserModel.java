/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author HERO
 */
public class UserModel extends JFrame{
    //this is three panel that contain table and form of attribute 1 to customer , 2 to employee and 3 for service
            CustomerPanel p1 ; 
            EmployeePanel p2 ;
            JPanel p3 ;
   //selction button to select mode
            JButton cust ;
            JButton emp ;
            JButton serv ;
            
            
            
              
    public UserModel() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1500, 900);
        this.setLocation(0,0);
        this.setTitle("Login");
        this.getContentPane().setBackground(Color.GRAY);
        this.setLayout(null);
        

  //__________________________________________________________
//   panel describtion
   
        p1 = new CustomerPanel() ;
        
        p2 = new EmployeePanel();

        p3 = new Services();

        p1.setBounds(250, 10, 1020, 650);
        p2.setBounds(250, 10, 1020, 650);
        p3.setBounds(250, 10, 1020, 650);

////______________________________________________________
        cust = new JButton("Customers");
        myhandler hand = new myhandler (); // create  Action handling  hand
        cust.addActionListener(hand);
        
        emp = new JButton("Employees");
        
        emp.addActionListener(hand);
        
        serv = new JButton("Services");
        
        serv.addActionListener(hand);
        
        cust.setBounds(10,10, 200,150);
        emp.setBounds(10, 240, 200, 150);
        serv.setBounds(10,490, 200, 150);

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        // add to frame 
        this.add(cust);
        this.add(emp);
        this.add(serv);
        this.add(p1);
        this.add(p2);
        this.add(p3);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
}
    
    
    
    
    
    class myhandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Object ss = e.getSource();
            if (ss==cust)
            {
                p1.show(true);
                p2.show(false);
                p3.show(false);
            }
            else if (ss== emp)
            {
                p1.show(false);
                p2.show(true);
                p3.show(false);
            }
            else if (ss== serv)
            {
                p1.show(false);
                p2.show(false);
                p3.show(true);
                        
            }        
      }
   }      
}

