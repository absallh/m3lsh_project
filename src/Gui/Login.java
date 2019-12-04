/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.*;
import javax.swing.*;
/**
 *
 * @author HERO
 */
public class Login extends JFrame{
     JLabel lb1;
        JTextField username ;
        JPasswordField password ;
        JLabel Name ;
        JLabel pass ;
        JButton login ;
    public Login() {
//this is the charactaristics  of frame  
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 600);
        this.setLocation(300,100);
        this.setTitle("Login");
        Color c =new Color(51,204,255);
        this.getContentPane().setBackground(c);
        this.getContentPane().getSize(null);
        this.setLayout( new GridBagLayout());
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
        this.add(Name);
        gc.gridx =2;
        gc.gridy = 0 ;
        this.add(username,gc);
        gc.gridx =0;
        gc.gridy = 2 ;
        this.add(pass,gc);
        gc.gridx =2;
        gc.gridy = 2 ;
        this.add(password,gc);
        gc.gridx =0;
        gc.gridy =4;
        gc.gridwidth=50;
        this.add(login,gc);

}
}
