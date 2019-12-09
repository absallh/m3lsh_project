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
import control.login;
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
    
    private login loginControl;
    private int times_of_login;
    
    private String userName_txt;
    private String password_txt;
    public Login() {
        loginControl = new login();
        times_of_login = 1;
    }
    
        /**
     run method to run the whole program and login
     */
    public void run(){
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
    
    //private inner class to add event handling to the button
    private class JButtonHandler implements ActionListener{

        @Override
        @SuppressWarnings("the password can't be displayed")
        public void actionPerformed(ActionEvent ae) {
            
            //get the username and the password that the user entred and check it
            if (loginControl.athuntcated(username.getText(), password.getText())){
                frame.dispose();//to close the whole frame
                loginControl.enterTheProgram();//let the user enter the program
            }
            //check if the user try to login more than 5 times
            else if (times_of_login == 5){
                username.setEditable(false);
                password.setEditable(false);
                JOptionPane.showMessageDialog(null, "you can't login again", "Error in login", JOptionPane.ERROR_MESSAGE);
            }
            //out put error in login
            else{
                times_of_login++;
                JOptionPane.showMessageDialog(null, "Can't enter", "error", JOptionPane.ERROR_MESSAGE);
            }
        }
    
    }
        
}
