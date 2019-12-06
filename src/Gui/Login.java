/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author HERO
 */
public class Login extends JFrame{
    JFrame frame;
    JLabel lb1;
    JTextField username ;
    JPasswordField password ;
    JLabel Name ;
    JLabel pass ;
    JButton login ;
    
    private String userName_txt;
    private String password_txt;
    public Login() {
        frame = new JFrame();
//this is the charactaristics  of frame  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 600);
        frame.setLocation(300,100);
        frame.setTitle("Login");
        Color c =new Color(51,204,255);
        frame.getContentPane().setBackground(c);
        frame.getContentPane().getSize(null);
        frame.setLayout( new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.insets = new Insets(10,10,10,10);
//and this is the component of login frame 
        username = new JTextField(20);
        password = new JPasswordField(20);
        Name = new JLabel("UserName :");
        pass = new JLabel("password :");
        login = new JButton ("login");     
        gc.gridx =0;
        gc.gridy = 0 ;
        frame.add(Name);
        gc.gridx =2;
        gc.gridy = 0 ;
        frame.add(username,gc);
        gc.gridx =0;
        gc.gridy = 2 ;
        frame.add(pass,gc);
        gc.gridx =2;
        gc.gridy = 2 ;
        frame.add(password,gc);
        gc.gridx =0;
        gc.gridy =4;
        gc.gridwidth=50;
        frame.add(login,gc);
      
        //add the event handler
       JButtonHandler handler = new JButtonHandler();
       login.addActionListener( handler );//add event handling to the button
       
       frame.setVisible(true);//make the frame visable
      
    }
    
    //private class to add event handling to the button
    private class JButtonHandler implements ActionListener{

        @Override
        @SuppressWarnings("the password can't be displayed")
        public void actionPerformed(ActionEvent ae) {
            userName_txt = String.format(username.getText());//to get user name from the text box
            password_txt = String.format(password.getText());//to get password
            frame.dispose();//to close the whole frame
        }
    
    }
    
    

    public String getUserName_txt() {
        return userName_txt;
    }

    public String getPassword_txt() {
        return password_txt;
    }
        
}
