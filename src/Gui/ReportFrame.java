/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import javax.swing.JFrame;

/**
 *
 * @author HERO
 */
public class ReportFrame extends Employee{
            JFrame report ;
    public ReportFrame() {
        report = new JFrame ();
    }

    @Override
    public void work() {
       report.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       report.setSize(1500, 900);
       report.setLocation(0,0);
       report.setTitle("OtherService");
       report.setLayout(null);
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       report.setVisible(true);
     
    }
    
    
}
