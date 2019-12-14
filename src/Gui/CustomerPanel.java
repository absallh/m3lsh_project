/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import control.user_model;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javafx.scene.control.*;
import javax.swing.*;

/**
 *
 * @author HERO
 */
class CustomerPanel extends JPanel {

    user_model user_control;
          TableColumn  Customer_Name = new TableColumn("name") ;
        // Form
            JLabel CustomerName ;
            JLabel age ;
            JLabel lastName ;
            JLabel CustomerNationality ;
            JLabel commingDate ;
            JLabel ccheckOut ;
            JLabel RoomChoice;
            JLabel ServicesChoice ;
            JTextField name ;
            JTextField age_txt ;
            JTextField lastName_txt ;
            JComboBox nationality ;
            JTextField checkin ;
            JTextField checkout ;
            // Deficult m3lesh tell me what i do because i dont know
            JButton Click;
            JComboBox selectroom ;
             JScrollPane S1 ;
            //SOME ARRAY OF STRING FIRST FOR TABLE COLUMN NAME AND SECPND FOR NATIONALITY
//                                       String [] ColumnName={"id","name","nationality","checkin Date","checkout","Services","AssginedRoom","Phone"};
            
             String Nation [] ={"Egyption","Chinese","English","French","German","Italian","Japanese"
             ,"Russian","Spanish","American","Saudi Arabian","Australian","Belgian"} ;
             //             this is array list from room type
            //_____________________________________________
            JButton Add ;
            JButton Delete ;
            JButton update;
            JTable CustomerTable ;
                Color c = new Color(173,216,230);

    public CustomerPanel(user_model user_control) {
                            // Panel Colore and positions in frame
                        this.user_control = user_control;
        this.setLayout(null);
        this.setBackground(c);
        //_______________tables creation..____________________________________
        CustomerTable= new JTable(user_control.getCustomerData());
        JScrollPane sc = new JScrollPane(CustomerTable, 
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sc.setBounds(10, 400,1000, 200);
        this.add(sc);
        //_______Table charactaristics_________________________________
        CustomerTable.setBackground(Color.WHITE);
        
        sc.setBounds(10, 400,1000, 200);
        
        this.setBounds(250, 10, 1020, 650);
             this.add(sc);
 //______________________________________________________________________
   
         CustomerName = new JLabel("first Name") ;
        name = new JTextField(20) ;
        CustomerName.setBounds(10, 10, 150, 20);
        this.add(CustomerName);
        name.setBounds(100, 10, 150, 20);
        this.add(name);
     //_____________________________________________________
              age = new JLabel("Cutomer age") ;
              age.setBounds(270, 10, 150, 20);
              age_txt = new JTextField(10) ;
              age_txt.setBounds(370, 10, 150, 20);
               this.add(age);
               this.add(age_txt);
    //___________________________________________________________________
                    lastName = new JLabel(" last name") ;
                    lastName.setBounds(550, 10, 150, 20);
                    lastName_txt = new JTextField(20) ;
                    lastName_txt.setBounds(670, 10, 150, 20);
                         this.add(lastName);
                         this.add(lastName_txt);
   //__________________________________________________________________________
                          // icons ADD &Delete
                ImageIcon  ADDIcon= new ImageIcon(getClass().getResource( "follower.png"));
                ImageIcon  DeleteIcon= new ImageIcon(getClass().getResource("delete.png"));
                ImageIcon  SelectIcon= new ImageIcon(getClass().getResource("tap.png"));

  //____________________________________________________________________________
                                commingDate = new JLabel("Check In Date") ;
                                    commingDate.setBounds(10, 50, 150, 20);
                                checkin = new JTextField(10) ;
                                   checkin.setBounds(100, 50, 150, 20);
                                  this.add(commingDate);
                                   this.add(checkin);
   //_________________________________________________________
                                       ccheckOut = new JLabel("Check Out Date ") ;
                                        ccheckOut.setBounds(270, 50, 150, 20);
                                       checkout = new JTextField(10) ;
                                        checkout.setBounds(370, 50, 150, 20);
                                 this.add(ccheckOut);
                                 this.add(checkout);
     //__________________________________________________________
                          CustomerNationality = new JLabel("Cutomer Nationality") ;
                          CustomerNationality.setBounds(550, 50, 150, 20);
                          nationality = new JComboBox(Nation);
                          
                          nationality.setBounds(670, 50, 150, 20);
                                 this.add(CustomerNationality);
                                 this.add(nationality);
      //______________________________Combo box to select room ________________________
                                 RoomChoice = new JLabel("RoomChoice");
                                 RoomChoice.setBounds(10, 100, 150, 20);
                                 this.add(RoomChoice);
                               selectroom = new JComboBox(user_control.getRoomNumbers());
                               selectroom.setBounds(100, 100, 150, 20);
                               this.add(selectroom);
      //____________________________________________________________________________________________                       
                         Add = new JButton (ADDIcon); // add add button && Delete
                         Add.setBounds(10, 330, 100, 70);
                         this.add(Add);
                         Delete = new JButton (DeleteIcon);
                         Delete.setBounds(120, 330, 100, 70);
                         this.add(Delete);
                        update = new JButton ("SUBMIT UPDATE"); 
                         update.setBounds(230, 330, 100, 70);
                         this.add(update);
                         buttonAction buttonHandling = new buttonAction();
                         Add.addActionListener(buttonHandling);
                         Delete.addActionListener(buttonHandling);
                         update.addActionListener(buttonHandling);
                    
                         CustomerTable.addMouseListener(new tableMouseListener());
                         CustomerTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                         
        this.setVisible(true);
    }
    int row;
    private class tableMouseListener extends MouseAdapter{
      @Override
      public void mouseClicked(MouseEvent e) {
            row = CustomerTable.rowAtPoint(e.getPoint());//get mouse-selected row
            //int col = GustTable.columnAtPoint(e.getPoint());//get mouse-selected col
            name.setText(String.format("%s", CustomerTable.getValueAt(row, 1)));
            lastName_txt.setText(String.format("%s", CustomerTable.getValueAt(row, 2)));
            nationality.setSelectedItem(CustomerTable.getValueAt(row, 3));
            age_txt.setText(String.format("%s", CustomerTable.getValueAt(row, 4)));
            checkin.setText(String.format("%s", CustomerTable.getValueAt(row, 5)));
            checkout.setText(String.format("%s", CustomerTable.getValueAt(row, 6)));
        }
    }
    
    private class buttonAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == Add){
                if (!CustomerTable.getSelectionModel().isSelectionEmpty()){
                    name.setText("");
                    lastName_txt.setText("");
                    nationality.setSelectedIndex(0);
                    age_txt.setText("");
                    checkin.setText("");
                    checkout.setText("");
                    CustomerTable.getSelectionModel().clearSelection();
                }else{
                    user_control.add_customer(name.getText(), lastName_txt.getText(), 
                        (String) nationality.getSelectedItem(), Integer.parseInt(age_txt.getText()), 
                        checkin.getText(), checkout.getText());
                    
                    JOptionPane.showMessageDialog(null, "Added sec");
                }
            }
            else if (CustomerTable.getSelectionModel().isSelectionEmpty()){
                JOptionPane.showMessageDialog(null, "select any customer to edite or delete", "Missing Selection", JOptionPane.INFORMATION_MESSAGE);
            }else if (ae.getSource() == Delete){
                    int row = CustomerTable.getSelectedRow();//get selected row indext
                    user_control.delete_customer((int) CustomerTable.getValueAt(row, 0));
                    JOptionPane.showMessageDialog(null, "Deleted suc");
            }
            else if (ae.getSource() == update){
                
                    int row = CustomerTable.getSelectedRow();//get selected row indext
                    user_control.update_customer((int) CustomerTable.getValueAt(row, 0), name.getText(), lastName.getText(), 
                        (String) nationality.getSelectedItem(), Integer.parseInt(age_txt.getText()), 
                        checkin.getText(), checkout.getText());
                JOptionPane.showMessageDialog(null, "Added sec");
            }
        }
        
    }

    
}
