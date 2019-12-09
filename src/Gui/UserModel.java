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
import javax.swing.JPanel;

/**
 *
 * @author HERO
 */
public class UserModel extends Employee{
    
    JFrame userFrame;
    //this is three panel that contain table and form of attribute 1 to customer , 2 to employee and 3 for service
            CustomerPanel CustomerPanel ; 
            EmployeePanel EmployeePanel ;
            Services ServicesPanel ;
   //selction button to select mode
            JButton cust ;
            JButton emp ;
            JButton serv ;
            
            //__________ this is 3 icons to user it with three button _______ customer , employee and services
            ImageIcon CutomerIcon = new ImageIcon("C:\\Users\\HERO\\Desktop\\m3lsh_project\\src\\Office-Customer-Male-Light-icon.png");
            ImageIcon EmployeeIcon = new ImageIcon("C:\\Users\\HERO\\Desktop\\m3lsh_project\\src\\employee.png");
            ImageIcon ServicesIcon = new ImageIcon("C:\\Users\\HERO\\Desktop\\m3lsh_project\\src\\Network_Service_Icon_128.png");
            
    public UserModel() {
        userFrame = new JFrame();
}
    
    
    @Override
    public void work (){
        userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userFrame.setSize(1500, 900);
        userFrame.setLocation(0,0);
        userFrame.setTitle("Login");
        userFrame.getContentPane().setBackground(Color.GRAY);
        userFrame.setLayout(null);
        

  //__________________________________________________________
//   panel describtion
   
        CustomerPanel = new CustomerPanel() ;
        
        EmployeePanel = new EmployeePanel();

        ServicesPanel = new Services();

        CustomerPanel.setBounds(250, 10, 1020, 650);
        EmployeePanel.setBounds(250, 10, 1020, 650);
        ServicesPanel.setBounds(250, 10, 1020, 650);

////______________________________________________________
     // create  Action handling  hand
        myhandler hand = new myhandler ();
        
        cust = new JButton(CutomerIcon);

        cust.addActionListener(hand);
        
        emp = new JButton(EmployeeIcon);
        
        emp.addActionListener(hand);
        
        serv = new JButton(ServicesIcon);
        
        serv.addActionListener(hand);
        
        cust.setBounds(10,10, 200,150);
        emp.setBounds(10, 240, 200, 150);
        serv.setBounds(10,490, 200, 150);
        // add to frame 
        userFrame.add(cust);
        userFrame.add(emp);
        userFrame.add(serv);
        userFrame.add(CustomerPanel);
        userFrame.add(EmployeePanel);
        userFrame.add(ServicesPanel);        
        
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
            }
            else if (ss== emp)
            {
                CustomerPanel.show(false);
                EmployeePanel.show(true);
                ServicesPanel.show(false);
            }
            else if (ss== serv)
            {
                CustomerPanel.show(false);
                EmployeePanel.show(false);
                ServicesPanel.show(true);
                        
            }        
      }
   }      
}

