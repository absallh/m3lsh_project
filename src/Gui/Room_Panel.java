/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Database.Room_data;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
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
            JLabel RoomNumber ;
            JLabel Roomeprice ;
            JLabel RoomType ;
//            JLabel Number ;
            JComboBox Rnum ;
            JTextField price ;
            JComboBox Type ;
            // create array for type of room
            String [] RoomTypes ={"Single","Double","Triple","Quad","Queen","King","Twin","Mini Suites","Master Suite","Others"};
            public Room_data RoomData = new Room_data();
            //_____________________________________________
            JButton Add ;
            JButton Delete ;
            JTable RoomTable ;
              Color c = new Color(173,216,230);
    public Room_Panel() {
                                // Panel Colore and positions in frame
        this.setLayout(null);
        this.setBackground(c);
          RoomTable= new JTable(RoomData);
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
        
        Rnum = new JComboBox() ;
           for(int i=1;i<101;i++){
               Rnum.addItem(i);
           }
        RoomNumber.setBounds(10, 10, 150, 20);
        this.add(RoomNumber);
        Rnum.setBounds(100, 10, 150, 20);
        this.add(Rnum);

                    RoomType = new JLabel("Room Type") ;
                    RoomType.setBounds(550, 10, 150, 20);
                    
                    Type = new JComboBox() ;
                     for(int i=0;i<RoomTypes.length;i++){
               Type.addItem( RoomTypes[i]);
                        }
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
                ImageIcon  ADDIcon= new ImageIcon("C:\\Users\\HERO\\Desktop\\m3lsh_project\\src\\follower.png");
                ImageIcon  DeleteIcon= new ImageIcon("C:\\Users\\HERO\\Desktop\\m3lsh_project\\src\\delete.png");

                 Add = new JButton (ADDIcon); // add add button && Delete
                         Add.setBounds(10, 330, 100, 70);
                         this.add(Add);
                         Delete = new JButton (DeleteIcon);
                         Delete.setBounds(120, 330, 100, 70);
                         this.add(Delete);
                         
                this.setVisible(true);
    }
    
    
}
