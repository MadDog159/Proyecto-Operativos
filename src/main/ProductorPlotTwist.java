/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.concurrent.Semaphore;


/**
 *
 * @author epidu
 */
public class ProductorPlotTwist  extends Thread{
           double sueldo = 10;
           int plottwist = 0;
           int Productor_plottwist = 0;
           public Semaphore drive_PlotTwist;

           public ProductorPlotTwist(Semaphore drive_PlotTwist) {
                      this.drive_PlotTwist = drive_PlotTwist;
           }
           

           public double getSueldo() {
                      return sueldo;
           }

           public int getPlottwist() {
                      return plottwist;
           }

           public void setSueldo(double sueldo) {
                      this.sueldo = sueldo;
           }

           public void setPlottwist(int plottwist) {
                      this.plottwist = plottwist;
           }
           
           public int getProductor_plottwist() {
                      return Productor_plottwist;
           }

           public void setProductor_plottwist(int Productor_plottwist) {
                      this.Productor_plottwist = Productor_plottwist;
           }
           
           public void plottwistCreada(){
                      plottwist += Productor_plottwist;
           }
           public double pagoSueldos(){
                      sueldo = 24*10*Productor_plottwist;
                      return sueldo;
           }

           
           
           @Override
           public void run(){
                      try{
                                 while(true){
                                            Thread.sleep(2000);
                                            int i;
                                            for(i = 0 ; i < plottwist; i++){
                                                       drive_PlotTwist.acquire();
                                            }
                                            
                                 }
                      }catch(InterruptedException e){
                                 
                      }
                      
           }


           
           
}
