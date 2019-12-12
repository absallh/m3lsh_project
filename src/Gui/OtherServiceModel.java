/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Database.Service_Data;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author HERO
 */
public class OtherServiceModel extends Employee {
JFrame OtherServiceFrame ;
    JLabel paint ;
    JLabel service_name ;
    JLabel Serviceprice ;
    JLabel description ;
        JTextField name ;
        JTextField price ;
        JTextField describe ;
            JButton Add ,Delete ;
                JTable OtherServiceTable ;
                    JButton GenerateReport ;
   Service_Data OtherServiceData;
    
    public OtherServiceModel() {
        this.OtherServiceData = new Service_Data();
        OtherServiceFrame = new JFrame ();
    }

    @Override
    public void work() {
       OtherServiceFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       OtherServiceFrame.setSize(1500, 900);
       OtherServiceFrame.setLocation(0,0);
       OtherServiceFrame.setTitle("OtherService");
      
       OtherServiceFrame.setLayout(null);
     
      //____________________________________________________________________________________
       // table:
         OtherServiceTable= new JTable(OtherServiceData);
        JScrollPane sc = new JScrollPane(OtherServiceTable, 
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sc.setBounds(10, 400,1000, 200);
        OtherServiceFrame.add(sc);
        //_______Table charactaristics_________________________________
        OtherServiceTable.setBackground(Color.WHITE);
        
        sc.setBounds(10, 10,500, 400);
        
//        OtherServiceFrame.setBounds(250, 10, 1020, 650);
             OtherServiceFrame.add(sc);
         
     
       
          service_name = new JLabel("service Name") ;
          service_name.setForeground(Color.WHITE);
        name = new JTextField(20) ;
        service_name.setBounds(10, 500, 150, 20);
        OtherServiceFrame.add(service_name);
        name.setBounds(100, 500, 150, 20);
        OtherServiceFrame.add(name);
     //_____________________________________________________
              Serviceprice = new JLabel("Service price") ;
               Serviceprice.setForeground(Color.WHITE);
              Serviceprice.setBounds(270, 500, 150, 20);
              price = new JTextField(10) ;
              price.setBounds(370, 500, 150, 20);
               OtherServiceFrame.add(Serviceprice);
               OtherServiceFrame.add(price);
    //___________________________________________________________________
                    description = new JLabel("description") ;
                     description.setForeground(Color.WHITE);
                    description.setBounds(550, 500, 150, 20);
                    describe = new JTextField() ;
                    describe.setBounds(660, 500, 150, 20);
                         OtherServiceFrame.add(description);
                         OtherServiceFrame.add(describe);
   //__________________________________________________________________________
                         
                ImageIcon  ADDIcon= new ImageIcon("F:\\m3lsh_project\\src\\Gui\\Add-icon.png");
                ImageIcon  DeleteIcon= new ImageIcon("F:\\m3lsh_project\\src\\Gui\\Actions-window-close-icon.png");
                  ImageIcon  ReportIcon= new ImageIcon("F:\\m3lsh_project\\src\\Gui\\33.png");
  //____________________________________________________________________________
                             
                           GenerateReport = new JButton(ReportIcon);
                           GenerateReport.addActionListener(new ActionListener(){

           @Override
           public void actionPerformed(ActionEvent e) {
               if (e.getSource()== GenerateReport){
                   ReportFrame Report = new ReportFrame();
                   Report.work();
               }
           }
       });
                           GenerateReport.setBounds(1200, 10, 150, 100);
                           OtherServiceFrame.add(GenerateReport);

                         Add = new JButton (ADDIcon); // add add button && Delete
                         Add.setBounds(10, 410, 250, 50);
                         OtherServiceFrame.add(Add);
                         Delete = new JButton (DeleteIcon);
                         Delete.setBounds(260, 410, 250, 50);
                         OtherServiceFrame.add(Delete);
                         
                           ImageIcon back = new ImageIcon("F:\\m3lsh_project\\src\\Gui\\hotel.jpg");
                           paint = new JLabel(back);
                           paint.setBounds(0, 0, 1500, 900);
                           OtherServiceFrame.add(paint);

                         
               OtherServiceFrame.setVisible(true);
    }
    
}
