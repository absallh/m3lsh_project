/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Database.CustomerData;
import Database.Service_Data;
import control.room;
import control.service;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javafx.scene.control.*;
import javax.swing.*;

/**
 *
 * @author HERO
 */
class CustomerPanel extends JPanel {

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
            JList ChoiceService ;
            JList SelectedServices;
            JButton Click;
            JComboBox selectroom ;
             JScrollPane S1 ;
            //SOME ARRAY OF STRING FIRST FOR TABLE COLUMN NAME AND SECPND FOR NATIONALITY
//                                       String [] ColumnName={"id","name","nationality","checkin Date","checkout","Services","AssginedRoom","Phone"};
            CustomerData CoustomerData= new CustomerData();
             String Nation [] ={"Egyption","Chinese","English","French","German","Italian","Japanese"
             ,"Russian","Spanish","American","Saudi Arabian","Australian","Belgian"} ;
             ArrayList<room> SelctionRoom  = new ArrayList<>();
             Service_Data  service = new Service_Data();
             //Should put Array of Object about service >>
              String [] array ={"ahmed","mohamed","hossam ","osama","amr","mostafa","ahmed","mohamed","hossam ","osama","amr","mostafa"};
//             this is array list from room type
            //_____________________________________________
            JButton Add ;
            JButton Delete ;
            JButton update;
            JTable CustomerTable ;
                Color c = new Color(173,216,230);

    public CustomerPanel() {
                            // Panel Colore and positions in frame
        this.setLayout(null);
        this.setBackground(c);
        //_______________tables creation..____________________________________
        CustomerTable= new JTable(CoustomerData);
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
                               selectroom = new JComboBox();
                               int i=0;
                               while (! SelctionRoom.isEmpty()){
                               selectroom.addItem(SelctionRoom.get(i));
                               i++;
                               }
                               selectroom.setBounds(100, 100, 150, 20);
                               this.add(selectroom);
     //__________________________________________________________________________________________________

                            ChoiceService = new JList(array);
                            ChoiceService.setVisibleRowCount(5);
                            ChoiceService.setFixedCellHeight(10);
                            ChoiceService.setFixedCellWidth(100);
                            ChoiceService.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                            S1 =new JScrollPane(ChoiceService);
                            S1.setBounds(20, 200, 200, 100);
                            this.add (S1);
                            
                            Click = new JButton(SelectIcon);
                            Click.addActionListener( new ActionListener(){
             @Override
             public void actionPerformed(ActionEvent e) {
               SelectedServices.setListData( ChoiceService.getSelectedValues());
                    }    

              }
        );
                          Click.setBounds(220, 200, 200, 100);
                          this.add(Click);
                          SelectedServices = new JList();
                          SelectedServices.setVisibleRowCount(5);
                          SelectedServices.setFixedCellHeight(10);
                          SelectedServices.setFixedCellWidth(100);
                          SelectedServices.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
                          
                          JScrollPane S2 =new JScrollPane(SelectedServices);
                           S2.setBounds(420, 200, 200, 100);
                            this.add (S2);
                                 
                                 

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
                         
        this.setVisible(true);
    }                         
                     
    private class tableMouseListener extends MouseAdapter{
      @Override
      public void mouseClicked(MouseEvent e) {
            int row = CustomerTable.rowAtPoint(e.getPoint());//get mouse-selected row
            //int col = GustTable.columnAtPoint(e.getPoint());//get mouse-selected col
            name.setText(String.format("%s", CoustomerData.getValueAt(row, 1)));
            lastName.setText(String.format("%s", CoustomerData.getValueAt(row, 2)));
            nationality.setSelectedItem(CoustomerData.getValueAt(row, 3));
            age_txt.setText(String.format("%s", CoustomerData.getValueAt(row, 4)));
            checkin.setText(String.format("%s", CoustomerData.getValueAt(row, 5)));
            checkout.setText(String.format("%s", CoustomerData.getValueAt(row, 6)));
        }
    }
    
    private class buttonAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == Add){
                CoustomerData.write(name.getText(), lastName.getText(), 
                        (String) nationality.getSelectedItem(), Integer.parseInt(age_txt.getText()), 
                        checkin.getText(), checkout.getText());
                CoustomerData.setQuery(CoustomerData.DEFUALT_QUERY);
                JOptionPane.showMessageDialog(null, "Added sec");
            }
            else if (ae.getSource() == Delete){
                if (CustomerTable.getSelectionModel().isSelectionEmpty())
                    JOptionPane.showMessageDialog(null, "select any customer to edite", "Missing Selection", JOptionPane.INFORMATION_MESSAGE);
                else 
                {
                    int row = CustomerTable.getSelectedRow();//get selected row indext
                    CoustomerData.delete((int) CoustomerData.getValueAt(row, 0));
                    JOptionPane.showMessageDialog(null, "Deleted suc");
                    CoustomerData.setQuery(CoustomerData.DEFUALT_QUERY);
                }
            }
            else if (ae.getSource() == update){
                if (CustomerTable.getSelectionModel().isSelectionEmpty())
                    JOptionPane.showMessageDialog(null, "select any customer to update", "Missing Selection", JOptionPane.INFORMATION_MESSAGE);
                else 
                {
                    int row = CustomerTable.getSelectedRow();//get selected row indext
                    CoustomerData.update((int) CoustomerData.getValueAt(row, 0), name.getText(), lastName.getText(), 
                        (String) nationality.getSelectedItem(), Integer.parseInt(age_txt.getText()), 
                        checkin.getText(), checkout.getText());
                CoustomerData.setQuery(CoustomerData.DEFUALT_QUERY);
                JOptionPane.showMessageDialog(null, "Added sec");
                }
            }
        }
        
    }

    
}
