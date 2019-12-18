/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import control.user_model;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author HERO
 */
public class Room_Panel extends JPanel {
    
    user_model user_control;
            JLabel RoomNumber ;
            JLabel Roomeprice ;
            JLabel RoomType ;
//            JLabel Number ;
            JTextField Rnum ;
            JTextField price ;
            JComboBox Type ;
            // create array for type of room
            String [] RoomTypes ={"Single","Double","Triple","Quad","Queen","King","Twin","Mini Suites","Master Suite","Others"};
            //_____________________________________________
            JButton Add ;
            JButton Delete ;
            JButton update;
            JTable RoomTable ;
              Color c = new Color(173,216,230);
    public Room_Panel(user_model user_control) {
        this.user_control = user_control;
        
                                // Panel Colore and positions in frame
        this.setLayout(null);
        this.setBackground(c);
          RoomTable= new JTable(user_control.getRoomData());
        JScrollPane sc = new JScrollPane(RoomTable, 
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sc.setBounds(10, 400,1000, 200);
        this.add(sc);
       //_______Table charactaristics_________________________________
        RoomTable.setBackground(Color.WHITE);
        
        sc.setBounds(10, 400,1000, 200);
        
        this.setBounds(250, 10, 1020, 650);
             this.add(sc);
           RoomNumber = new JLabel("Room Number") ;
        RoomNumber.setBounds(10, 10, 150, 20);
        this.add(RoomNumber);
        Rnum = new JTextField();
        Rnum.setBounds(100, 10, 150, 20);
        this.add(Rnum);

                    RoomType = new JLabel("Room Type") ;
                    RoomType.setBounds(550, 10, 150, 20);
                    
                    Type = new JComboBox(RoomTypes) ;
                     
                    Type.setBounds(670, 10, 150, 20);
                         this.add(RoomType);
                         this.add(Type);
     //_____________________________________________________
              Roomeprice = new JLabel("Roome price") ;
              Roomeprice.setBounds(270, 10, 150, 20);
              price = new JTextField(10) ;
              price.setBounds(370, 10, 150, 20);
               this.add(Roomeprice);
               this.add(price);
    //___________________________________________________________________
   //__________________________________________________________________________
                          // icons ADD &Delete
                ImageIcon  ADDIcon= new ImageIcon(getClass().getResource("follower.png"));
                ImageIcon  DeleteIcon= new ImageIcon(getClass().getResource("delete.png"));
                ImageIcon  UpdateIcon= new ImageIcon(getClass().getResource("Update.png"));


                 Add = new JButton (ADDIcon); // add add button && Delete
                         Add.setBounds(10, 330, 100, 70);
                         this.add(Add);
                         Delete = new JButton (DeleteIcon);
                         Delete.setBounds(120, 330, 100, 70);
                         this.add(Delete);
                update = new JButton(UpdateIcon);
                update.setBounds(230, 330, 100, 70);
                this.add(update);
                
                RoomTable.addMouseListener(new tableMouseListener());
                buttonAction action = new buttonAction();
                Add.addActionListener(action);
                Delete.addActionListener(action);
                update.addActionListener(action);
                
                this.setVisible(false);
    }
    
    int row;
    private class tableMouseListener extends MouseAdapter{
      @Override
      public void mouseClicked(MouseEvent e) {
            row = RoomTable.rowAtPoint(e.getPoint());//get mouse-selected row
            //int col = GustTable.columnAtPoint(e.getPoint());//get mouse-selected col
            Rnum.setText(String.format("%s", RoomTable.getValueAt(row, 0)));
            price.setText(String.format("%s", RoomTable.getValueAt(row, 1)));
            Type.setSelectedItem(String.format("%s", RoomTable.getValueAt(row, 2)));
        }
    }
    
    private class buttonAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == Add){
                if (!RoomTable.getSelectionModel().isSelectionEmpty()){
                    Rnum.setText("");
                    price.setText("");
                    Type.setSelectedIndex(0);
                    RoomTable.getSelectionModel().clearSelection();//clear the selection from the table
                }else{
                    if (user_control.addRoom(Rnum.getText(), Double.parseDouble(price.getText()),
                            (String) Type.getSelectedItem())){
                        JOptionPane.showMessageDialog(null, "Added successfully");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Can't Add a room with exist number", "Input Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
            else if (RoomTable.getSelectionModel().isSelectionEmpty()){
                JOptionPane.showMessageDialog(null, "select any Room to edite or delete", "Missing Selection", JOptionPane.INFORMATION_MESSAGE);
            }else if (ae.getSource() == Delete){
               user_control.deleteRoom(String.format("%s", RoomTable.getValueAt(row, 0)));
                JOptionPane.showMessageDialog(null, "Deleted successfully");
            }
            else if (ae.getSource() == update){
                user_control.updateRoom(String.format("%s", RoomTable.getValueAt(row, 0)), 
                        Rnum.getText(), Double.parseDouble(price.getText()),
                        (String) Type.getSelectedItem());
                JOptionPane.showMessageDialog(null, "updated successfully");
            }
        }
        
    }
    
}
