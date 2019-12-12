/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import Database.Service_Data;
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
class Services_panel extends JPanel {

        TableColumn  Customer_Name = new TableColumn("name") ;
        // Form
            JLabel service_name ;
            JLabel Serviceprice ;
            JLabel description ;
            JTextField name ;
            JTextField price ;
            JTextArea describe ;
            
            //_____________________________________________
            JButton Add ;
            JButton Delete ;
            JButton update;
            JTable SeviceTable ;
            // two Array one from database another String for column name
            Service_Data ServicesData = new Service_Data();
                Color c = new Color(173,216,230);

    public Services_panel() {
             this.setLayout(null);
             this.setBackground(c);
             this.setBounds(250, 10, 1020, 650);
        //_______________tables creation..____________________________________
        SeviceTable = new JTable(ServicesData);
        JScrollPane scroll = new JScrollPane(SeviceTable);
        
        //_______Table charactaristics_________________________________
        SeviceTable.setBackground(Color.WHITE);
        SeviceTable.addMouseListener(new tableMouseListener());
  //__________________________________________________________
//   panel describtion
   

        scroll.setBounds(10, 400,1000, 200);

        this.add(scroll);
        
      //__________________________________________________
         service_name = new JLabel("service Name") ;
        name = new JTextField(20) ;
        service_name.setBounds(10, 10, 150, 20);
        this.add(service_name);
        name.setBounds(100, 10, 150, 20);
        this.add(name);
     //_____________________________________________________
              Serviceprice = new JLabel("Service price") ;
              Serviceprice.setBounds(270, 10, 150, 20);
              price = new JTextField(10) ;
              price.setBounds(370, 10, 150, 20);
               this.add(Serviceprice);
               this.add(price);
    //___________________________________________________________________
                    description = new JLabel("description") ;
                    description.setBounds(10, 50, 150, 20);
                    describe = new JTextArea();
                    describe.setBounds(100, 50, 500, 100);
                         this.add(description);
                         this.add(describe);
   //__________________________________________________________________________
                ImageIcon  ADDIcon= new ImageIcon(getClass().getResource("plus.png"));
                ImageIcon  DeleteIcon= new ImageIcon(getClass().getResource("delete.png"));
  //____________________________________________________________________________

                         Add = new JButton (ADDIcon); // add add button && Delete
                         Add.setBounds(10, 330, 100, 70);
                         this.add(Add);
                         Delete = new JButton (DeleteIcon);
                         Delete.setBounds(120, 330, 100, 70);
                         this.add(Delete);
                         update = new JButton();
                         update.setBounds(230, 330, 100, 70);
                         this.add(update);    
                         buttonAction action = new buttonAction();
                         Add.addActionListener(action);
                         update.addActionListener(action);
                         Delete.addActionListener(action);
                         
                           this.setVisible(true);
                                 
                                 
    }
    
    int row;//the selected row index
    private class tableMouseListener extends MouseAdapter{
      @Override
      public void mouseClicked(MouseEvent e) {
            row = SeviceTable.rowAtPoint(e.getPoint());//get mouse-selected row
            //int col = GustTable.columnAtPoint(e.getPoint());//get mouse-selected col
            name.setText(String.format("%s", ServicesData.getValueAt(row, 0)));
            describe.setText(String.format("%s", ServicesData.getValueAt(row, 1)));
            price.setText(String.format("%s",ServicesData.getValueAt(row, 2)));
        }
    }
    
    private class buttonAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == Add) {
                if (ServicesData.add(name.getText(), Double.parseDouble(price.getText()), describe.getText())){
                    JOptionPane.showMessageDialog(null, "Added successfully");
                }
                else{
                    JOptionPane.showMessageDialog(null, "can't add exist name of service", "Input Error", JOptionPane.INFORMATION_MESSAGE);
                }
            }else if (SeviceTable.getSelectionModel().isSelectionEmpty()){
                JOptionPane.showMessageDialog(null, "select any Employee to edite or delete", "Missing Selection", JOptionPane.INFORMATION_MESSAGE);
            }else{
                if (ae.getSource() == Delete){
                    ServicesData.delete(String.format("%s",ServicesData.getValueAt(row, 0)));
                    JOptionPane.showMessageDialog(null, "Deleted successfully");
                }
                else if (ae.getSource() == update){
                    ServicesData.update(String.format("%s",ServicesData.getValueAt(row, 0)), 
                            name.getText(), Double.parseDouble(price.getText()), describe.getText());
                    JOptionPane.showMessageDialog(null, "Updated successfully");
                }
            }
            ServicesData.setQuery(ServicesData.DEFUALT_QUERY);
        }
    }
        
}
    

