/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.*;

/**
 *
 * @author epidu
 */
public class Spinner {
           
           public static void Spinner(){
                      JSpinner pantalla = new JSpinner();
                       
                      SpinnerModel value =  new SpinnerNumberModel(
                      5, //initial value  
                      0, //minimum value  
                      10, //maximum value  
                      1); //step  
                      JSpinner spinner = new JSpinner(value);   
                      spinner.setBounds(100,100,50,30);    
                      pantalla.add(spinner);    
                      pantalla.setSize(500,500);    
                      pantalla.setLayout(null);      
                      pantalla.setVisible(true);
                      
//                      spinner.addChangeListener(new ChangeListener() {  
//                      public void stateChanged(ChangeEvent e) {  
//                      label.setText("Value : " + ((JSpinner)e.getSource()).getValue());  
//        }
                      
           }

          
           
           
}
