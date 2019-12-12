/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Database.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
     JList Assign_OtherService;
     JList Otherservice;
     JButton SelectService ;
     JButton Bill ;
     JButton submit;
    String [] ColumnName={"Customer ID","Customer Name ","Room Number","checkin Date","checkout Date","Services"};
         protected Gust_mangement_data CoustomerData;
         Color c =new Color(0,255,127);   String [] array ={"ahmed","khaled","mohamed","essam","amr"} ;
     JTable GustTable ;
    public Gust_management() {
        CoustomerData = new Gust_mangement_data();
        this.setLayout(null);
        this.setBackground(c);
        this.setBounds(250, 10, 1020, 650);
                //_______________tables creation..____________________________________
        GustTable= new JTable(CoustomerData);
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
        NearCheckout.addItemListener(new nearCheckOut_Action());
        
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

   submit = new JButton("SUBMIT");
   submit.setBounds(870, 330, 80, 50);
   button_action actionButton = new button_action();
   submit.addActionListener(actionButton);
   this.add(submit);
   //______________________________________________________________________
                                 Bill = new JButton("Bill");
                                 Bill.setBounds(10, 400, 1000, 50);
                                // Bill.addActionListener(new help());
                                 this.add(Bill);
                                 JPanel billpanel = new JPanel();
                                 billpanel.setBounds(10, 420, 1000, 200);
   //_______________________________________________________________________________
 
                                             Otherservice = new JList(array);
                            Otherservice.setVisibleRowCount(5);
                            Otherservice.setFixedCellHeight(10);
                            Otherservice.setFixedCellWidth(100);
                            Otherservice.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                            JScrollPane S1 =new JScrollPane(Otherservice);
                            S1.setBounds(10, 340, 200, 50);
                            this.add (S1);
                            
                            SelectService = new JButton("Select Other Service -->");
                            SelectService.addActionListener( new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
               Assign_OtherService.setListData( Otherservice.getSelectedValues());
                    }    

              }
        );
                          SelectService.setBounds(220, 340, 560, 50);
                          this.add(SelectService);
                          Assign_OtherService = new JList();
                          Assign_OtherService.setVisibleRowCount(5);
                          Assign_OtherService.setFixedCellHeight(10);
                          Assign_OtherService.setFixedCellWidth(100);
                          Assign_OtherService.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                          
                          JScrollPane S2 =new JScrollPane(Assign_OtherService);
                           S2.setBounds(800, 340, 200, 50);
                            this.add (S2);
                              
        this.setVisible(true);
    }

    private class tableMouseListener extends MouseAdapter{
      @Override
      public void mouseClicked(MouseEvent e) {
            int row = GustTable.rowAtPoint(e.getPoint());//get mouse-selected row
            //int col = GustTable.columnAtPoint(e.getPoint());//get mouse-selected col
            checkinDate.setText(String.format("%s", CoustomerData.getValueAt(row, 3)));
            checkoutDate.setText(String.format("%s", CoustomerData.getValueAt(row, 4)));
            //assignRoom_txt.setText(String.format("%s", CoustomerData.getValueAt(row, 5)));
            
        }
    }

    private class nearCheckOut_Action implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            if(ie.getStateChange()== ItemEvent.SELECTED){
                LocalDate today = java.time.LocalDate.now();//get the system date
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd LLLL yyyy");//set formate to the date
                today.format(formatter);
//                String today = today.format(formatter);
                
                CoustomerData.setQuery("select customer.customer_id, fname, lname, coming_date, check_out_date, customer_room.Room_number " +
                            "from customer, customer_room " +
                            "where customer.customer_id = customer_room.customer_id and check_out_date >= '"+today+"' "+
                            "and check_out_date >= '"+ today.plusDays(2)+"'");
            }
            else{
                CoustomerData.setQuery(CoustomerData.DEFAULT_QUERY);
            }
        }
       
            
    }
    
     public class button_action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submit){
                JOptionPane.showMessageDialog(null, "Submit");
            }
            else if (e.getSource() == Bill){
              JOptionPane.showConfirmDialog(null, "Generate bill");

          }
        }
        
    }
}
