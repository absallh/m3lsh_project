/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;


import Database.Service_Data;
import java.awt.*;
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
            JTextField describe ;
            
            //_____________________________________________
            JButton Add ;
            JButton Delete ;
            JTable SeviceTable ;
            // two Array one from database another String for column name
            Service_Data ServicesData = new Service_Data();
            String[]ColumnName ={"Service Name","Service price","Service Describtion"};
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
                    describe = new JTextField() ;
                    describe.setBounds(100, 50, 150, 20);
                         this.add(description);
                         this.add(describe);
   //__________________________________________________________________________
                ImageIcon  ADDIcon= new ImageIcon("C:\\Users\\HERO\\Desktop\\m3lsh_project\\src\\plus.png");
                ImageIcon  DeleteIcon= new ImageIcon("C:\\Users\\HERO\\Desktop\\m3lsh_project\\src\\delete.png");
  //____________________________________________________________________________

                         Add = new JButton (ADDIcon); // add add button && Delete
                         Add.setBounds(10, 330, 100, 70);
                         this.add(Add);
                         Delete = new JButton (DeleteIcon);
                         Delete.setBounds(120, 330, 100, 70);
                         this.add(Delete);
     
                                 
                           this.setVisible(true);
                                 
                                 
    }              
                                 
}
    
