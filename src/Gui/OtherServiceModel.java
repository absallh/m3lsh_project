/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import control.other_services;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
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
    JTextArea describe ;
    JButton Add ,Delete, update ;
    JTable OtherServiceTable ;
    JButton GenerateReport ;
                    
    other_services OtherServiceControl;
    
    public OtherServiceModel() {
        this.OtherServiceControl = new other_services();
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
         OtherServiceTable= new JTable(OtherServiceControl.getServiceData());
        JScrollPane sc = new JScrollPane(OtherServiceTable, 
            ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, 
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sc.setBounds(10, 400,1000, 200);
        OtherServiceFrame.add(sc);
        //_______Table charactaristics_________________________________
        OtherServiceTable.setBackground(Color.WHITE);
        OtherServiceTable.addMouseListener(new tableMouseListener());
        
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
                    describe = new JTextArea() ;
                    describe.setBounds(660, 500, 600, 80);
                         OtherServiceFrame.add(description);
                         OtherServiceFrame.add(describe);
   //__________________________________________________________________________
                         
                ImageIcon  ADDIcon= new ImageIcon(getClass().getResource("Add-icon.png"));
                ImageIcon  DeleteIcon= new ImageIcon(getClass().getResource("Actions-window-close-icon.png"));
                  ImageIcon  ReportIcon= new ImageIcon(getClass().getResource("33.png"));
  //____________________________________________________________________________
                             
                           GenerateReport = new JButton(ReportIcon);
                           GenerateReport.setBounds(1200, 10, 150, 100);
                           OtherServiceFrame.add(GenerateReport);

                         Add = new JButton (ADDIcon); // add add button && Delete
                         Add.setBounds(10, 410, 250, 50);
                         OtherServiceFrame.add(Add);
                         Delete = new JButton (DeleteIcon);
                         Delete.setBounds(260, 410, 250, 50);
                         OtherServiceFrame.add(Delete);
                         update = new JButton("Update");
                         update.setBounds(370, 410, 250, 50);
                         OtherServiceFrame.add(update);
                         
                         buttonAction action = new buttonAction();
                         Add.addActionListener(action);
                         Delete.addActionListener(action);
                         update.addActionListener(action);
                         GenerateReport.addActionListener(action);
                         
                           ImageIcon back = new ImageIcon(getClass().getResource("hotel.jpg"));
                           paint = new JLabel(back);
                           paint.setBounds(0, 0, 1500, 900);
                           OtherServiceFrame.add(paint);

                         
               OtherServiceFrame.setVisible(true);
    }
    
    int row;//the selected row index
    private class tableMouseListener extends MouseAdapter{
      @Override
      public void mouseClicked(MouseEvent e) {
            row = OtherServiceTable.rowAtPoint(e.getPoint());//get mouse-selected row
            //int col = GustTable.columnAtPoint(e.getPoint());//get mouse-selected col
            
            name.setText((String) OtherServiceTable.getValueAt(row, 0));
            describe.setText((String) OtherServiceTable.getValueAt(row, 1));
            price.setText(String.format("%s", 
                    OtherServiceTable.getValueAt(row, 2)));
        }
    }
    
    
    private class buttonAction implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (ae.getSource() == Add){
                if(!OtherServiceTable.getSelectionModel().isSelectionEmpty()){
                    name.setText("");
                    price.setText("");
                    describe.setText("");
                    OtherServiceTable.getSelectionModel().clearSelection();
                }else{
                    if(OtherServiceControl.addService(name.getText(), 
                            Double.parseDouble(price.getText()), describe.getText()))
                    {
                        JOptionPane.showMessageDialog(null, "Added successfully");
                    }else{
                        JOptionPane.showMessageDialog(null, "can't add exist id or user name","input Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }//end of Add action
            
            else if (OtherServiceTable.getSelectionModel().isSelectionEmpty()){
                JOptionPane.showMessageDialog(null, "select any Employee to edite or delete", "Missing Selection", JOptionPane.INFORMATION_MESSAGE);
            }else{
                String serviceName = (String) OtherServiceTable.getValueAt(row, 0);
                if (ae.getSource() == Delete){
                    OtherServiceControl.deleteService(serviceName);
                    JOptionPane.showMessageDialog(null, "deleted successfully");
                }
                else if (ae.getSource() == update){
                    OtherServiceControl.updateService(serviceName,
                            name.getText(), Double.parseDouble(price.getText()), describe.getText());
                    
                    JOptionPane.showMessageDialog(null, "updated successfully");
                }else if (ae.getSource() == GenerateReport){
                    String []date =OtherServiceControl.getServiceDates(serviceName);
                    JOptionPane.showMessageDialog(null, date[0]);
                    int count [] =OtherServiceControl.countService(date, serviceName);
                    JOptionPane.showMessageDialog(null, count[0]);
                    ReportFrame Report = new ReportFrame();
                    Report.DataService(count, date);
                    Report.work();
                }
            }
        }
        
    }
    
}
