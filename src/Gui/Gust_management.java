/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Database.*;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.List;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
     JDateChooser checkinDate;
     JDateChooser checkoutDate ;
     JCheckBox NearCheckout;
     JList Assign_OtherService;
     JList Otherservice;
     JButton SelectService ;
     JButton Bill ;
     JButton submit;
     JComboBox rooms;
    protected Gust_mangement_data CoustomerData;
         Color c =new Color(0,255,127);   
         String [] array ;
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
        GustTable.addMouseListener(new tableMouseListener());
        GustTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
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
                                checkinDate = new JDateChooser() ;
                                   checkinDate.setBounds(100, 300, 150, 20);
                                  this.add(comming_Date);
                                   this.add(checkinDate);
   //____________________________________________________________________
                                       checkOut = new JLabel("Check Out Date ") ;
                                        checkOut.setBounds(270, 300, 150, 20);
                                       checkoutDate = new JDateChooser() ;
                                        checkoutDate.setBounds(370, 300, 150, 20);
                                 this.add(checkOut);
                                 this.add(checkoutDate);
//______________________________________________________________________

        JLabel assgin_room = new JLabel("Assgined Room");
        assgin_room.setBounds(550, 300, 150, 20);
        this.add(assgin_room);
        
        ArrayList rooms_list =  CoustomerData.RoomNubers();
        String []rooms_array = (String[]) rooms_list.toArray(new String [rooms_list.size()]);
        rooms = new JComboBox(rooms_array);
        rooms.insertItemAt("none", 0);
        rooms.setSelectedIndex(0);
        rooms.setBounds(650, 300, 150, 20);
                
        this.add(rooms);
//______________________________________________________________________

   submit = new JButton("SUBMIT");
   submit.setBounds(925, 250, 80, 50);
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
 
                                ArrayList servicesList = CoustomerData.servicesNames();
                                array = (String[]) servicesList.toArray(new String [servicesList.size()]);
                                Otherservice = new JList(array);
                            Otherservice.setVisibleRowCount(5);
                            Otherservice.setFixedCellHeight(10);
                            Otherservice.setFixedCellWidth(100);
                            Otherservice.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                            JScrollPane S1 =new JScrollPane(Otherservice);
                            S1.setBounds(10, 340, 200, 50);
                            this.add (S1);
                            
                            SelectService = new JButton("Select Other Service -->");
    SelectService.addActionListener(actionButton);
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

    int row;
    private class tableMouseListener extends MouseAdapter{
      @Override
      public void mouseClicked(MouseEvent e) {
            row = GustTable.getSelectedRow();//get mouse-selected row
            //int col = GustTable.columnAtPoint(e.getPoint());//get mouse-selected col
            ArrayList assigned = CoustomerData.getAssignedServices((int)GustTable.getValueAt(row, 0));
            GustTable.setRowSelectionInterval(row, row);
            String[] selectedServices = (String[]) assigned.toArray(new String [assigned.size()]);
            Assign_OtherService.setListData(selectedServices);
            
            checkinDate.setDate((Date) GustTable.getValueAt(row, 3));
            checkoutDate.setDate((Date) GustTable.getValueAt(row, 4));
            rooms.setSelectedItem(GustTable.getValueAt(row, 5).equals("") ? "none": GustTable.getValueAt(row, 5));
        }
    }

    private class nearCheckOut_Action implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            if(ie.getStateChange()== ItemEvent.SELECTED){
                LocalDate today = LocalDate.now();//get the system date
                
                
                CoustomerData.setQuery("select customer.customer_id, first_name, last_name, coming_date, check_out_date, customer_room.Room_number " +
                            "from customer, customer_room " +
                            "where customer.customer_id = customer_room.customer_id and check_out_date >= '"
                        +today.plusDays(2)+"' "+ "and check_out_date <= '"
                        + today.plusDays(4)+"'\n"+ "ORDER BY check_out_date ASC");
            }
            else{
                CoustomerData.setQuery(CoustomerData.DEFAULT_QUERY);
            }
        }
       
            
    }
    
     public class button_action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if(GustTable.getSelectionModel().isSelectionEmpty()){
                    JOptionPane.showMessageDialog(null, "Select any Gust to show or edit his Data", "Missing Selection", JOptionPane.ERROR_MESSAGE);
                }else{
                    if (e.getSource() == submit){
                        String room = rooms.getSelectedItem().equals("none") ? null :  (String) rooms.getSelectedItem();
                        CoustomerData.submit((int) GustTable.getValueAt(row, 0),
                                checkinDate.getDate(), checkoutDate.getDate(), 
                                room );

                        JOptionPane.showMessageDialog(null, "Submited");
                        CoustomerData.setQuery(CoustomerData.DEFAULT_QUERY);
                        }

                    else if (e.getSource() == Bill){
                      JOptionPane.showConfirmDialog(null, "Generate bill");

                  }else if(e.getSource()== SelectService){
                        Assign_OtherService.setListData( Otherservice.getSelectedValues());
                        CoustomerData.assignServices((int) GustTable.getValueAt(row, 0), 
                                (String[]) Otherservice.getSelectedValuesList().toArray(new String[]{}));
                    }
            }
        }
        
    }
}
