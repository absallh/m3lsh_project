/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import control.room_mangement;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 *
 * @author HERO
 */
public class Gust_management extends JPanel {
    private room_mangement roomMange;
    
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
         Color c =new Color(0,255,127);   
         String [] array ;
     JTable GustTable ;
    public Gust_management(room_mangement roomMange) {
        this.roomMange = roomMange;
        
        this.setLayout(null);
        this.setBackground(c);
        this.setBounds(250, 10, 1020, 650);
                //_______________tables creation..____________________________________
        GustTable= new JTable(roomMange.getGustData());
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
        rooms = new JComboBox(roomMange.RoomNumbers());
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

                                Otherservice = new JList(roomMange.servicesNames());
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
            GustTable.setRowSelectionInterval(row, row);
            
            Assign_OtherService.setListData(roomMange.getAssignedServices((int)GustTable.getValueAt(row, 0)));
            
            checkinDate.setDate((Date) GustTable.getValueAt(row, 3));
            checkoutDate.setDate((Date) GustTable.getValueAt(row, 4));
            rooms.setSelectedItem(GustTable.getValueAt(row, 5).equals("") ? "none": GustTable.getValueAt(row, 5));
        }
    }

    private class nearCheckOut_Action implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent ie) {
            if(ie.getStateChange()== ItemEvent.SELECTED){
                roomMange.showNearCheckout();
            }
            else{
                roomMange.showAll();
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
                        roomMange.submit((int) GustTable.getValueAt(row, 0),
                                checkinDate.getDate(), checkoutDate.getDate(), room );

                        JOptionPane.showMessageDialog(null, "Submited");
                        }

                    else if (e.getSource() == Bill){
                      JOptionPane.showConfirmDialog(null, "Generate bill");

                  }else if(e.getSource()== SelectService){
                        Assign_OtherService.setListData( Otherservice.getSelectedValues());
                        roomMange.assignServices((int) GustTable.getValueAt(row, 0), 
                                (String[]) Otherservice.getSelectedValuesList().toArray(new String[]{}));
                    }
            }
        }
        
    }
}
