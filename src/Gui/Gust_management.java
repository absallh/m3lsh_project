/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import control.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author HERO
 */
public class Gust_management extends JPanel {
     JLabel comming_Date ;
     JLabel checkOut ;
     JTextField checkinDate ;
     JTextField checkoutDate ;
     JCheckBox NearCheckout;
     JButton Bill ;
    String [] ColumnName={"Customer ID","Customer Name ","Room Number","checkin Date"," Near checkout","Services",};
            Data[][]CoustomerData= new Data[200][200];
            
     JTable GustTable ;
    public Gust_management() {
        this.setLayout(null);
        this.setBackground(Color.LIGHT_GRAY);
        this.setBounds(250, 10, 1020, 650);
                //_______________tables creation..____________________________________
        GustTable= new JTable(CoustomerData,ColumnName);
        JScrollPane sc = new JScrollPane(GustTable);
        sc.setBounds(220, 400,1000, 200);
        this.add(sc);
        //_______Table charactaristics_________________________________
        GustTable.setBackground(Color.WHITE);
        
        sc.setBounds(10, 50,1000, 200);
        this.add(sc);
        //__________________checkBox to choice near check out___________________-

        NearCheckout = new JCheckBox ("NearCheckOut");
        NearCheckout.setBounds(850, 30, 120, 20);
        this.add(NearCheckout);
        
        //_____________________________________________________________
            comming_Date = new JLabel("Check In Date") ;
                                    comming_Date.setBounds(10, 300, 150, 20);
                                checkinDate = new JTextField(10) ;
                                   checkinDate.setBounds(100, 300, 150, 20);
                                  this.add(comming_Date);
                                   this.add(checkinDate);
   //____________________________________________________________________
                                       checkOut = new JLabel("Check Out Date ") ;
                                        checkOut.setBounds(270, 300, 150, 20);
                                       checkoutDate = new JTextField(10) ;
                                        checkoutDate.setBounds(370, 300, 150, 20);
                                 this.add(checkOut);
                                 this.add(checkoutDate);
   //______________________________________________________________________
                                 Bill = new JButton("Bill");
                                 Bill.setBounds(10, 400, 1000, 50);
                                 Bill.addActionListener(new help());
                                 this.add(Bill);
                                 JPanel billpanel = new JPanel();
                                 billpanel.setBounds(10, 420, 1000, 200);
   //_______________________________________________________________________________
                              
        this.setVisible(true);
    }
    
     public class help implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
          Object check = e.getSource();
          if (check == Bill){
              JOptionPane.showConfirmDialog(null, "Generate bill");

          }
        }
        
    }
}
