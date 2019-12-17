/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author HERO
 */
public class Bill extends JFrame{ 
    
    public Bill() {
        this.setLocation(200, 10);
        this.setSize(300, 1000);
        this.setVisible(false);
    }
    void showBill (int customer_id, String customer_name, String roomNumber ,int time,
            int roomPrice, String [] serviceName, Double [] servicePrice)
 {
        this.setLayout(null);
        JLabel  Name = new JLabel("Senior "+" "+customer_name+"  "+"id Number "+"  "+customer_id);
        Name.setSize(500, 50);
        Name.setBounds(10, 10, 500, 50);
        this.add(Name);

        JLabel  Room = new JLabel("Room number "+roomNumber);
        Room.setBounds(200, 10, 500, 50);
        this.add(Room);
        JLabel  price = new JLabel("Room price ="+ "time "+time+"X"+roomPrice+"="+time*roomPrice);
        price.setBounds(10, 50, 1000, 50);
        this.add(price);
        int sum =0;
        JLabel services ;
        for (int i=0;i<serviceName.length;i++){
            services=new JLabel(serviceName[i]+"\t"+"price ="+servicePrice [i]);
            services.setBounds(10, 100+i*20, 200, 50);
            this.add(services);
            sum+=servicePrice[i];
        }
        JOptionPane.showMessageDialog(null, sum);
        int total_price = (int) (sum + time*roomPrice);
        JLabel Total = new JLabel("Total price"+" = "+total_price);
        Total.setBounds(20, 500, 200, 200);
        Total.setForeground(Color.red);
        this.add(Total);
        
        this.setVisible(true);
        }
}
