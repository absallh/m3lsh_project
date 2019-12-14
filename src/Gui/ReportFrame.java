/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Database.Service_Data;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author HERO
 */
public class ReportFrame extends Employee{

            JFrame report ;
            JPanel chartPanel ;
    public ReportFrame() {
        report = new JFrame ();
    }
    
    Service_Data service; 

    @Override
    public void work() {
        
       report.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       report.setSize(1500, 900);
       report.setLocation(0,0);
       report.setTitle("OtherService");
       report.setLayout(new FlowLayout());
       chartPanel = new JPanel();
      
          DataService(dataset);
          JFreeChart barChart = ChartFactory.createBarChart("Services statistical report", "Services Name", "Services price $",dataset ,PlotOrientation.VERTICAL, true, true, false);
          CategoryPlot barchrt =barChart.getCategoryPlot();
          barchrt.setRangeGridlinePaint(Color.BLUE);
          
             ChartPanel panel=new ChartPanel(barChart);
             report.add(panel);
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       report.setVisible(true);
     
    }
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    public void DataService( DefaultCategoryDataset dataset){
 
    // here should put value selected
    dataset.addValue( 5011, "price1","name1");
     dataset.addValue( 1050, "price1","name2"); 
      dataset.addValue( 2000, "price3","name3");
       dataset.addValue( 5000, "price4","name4");
    }
    
}
