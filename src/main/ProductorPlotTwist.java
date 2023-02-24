/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import interfaz.Inicio_Sistema;
import static interfaz.casaRodaje.iniciar;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


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
           
           public void reducir(){
                      drive_PlotTwist.release(2);
           }
           public synchronized void suspender(){
                      iniciar = true;
           }
           public synchronized void reanudar(){
                      iniciar = false;
                      notifyAll();
           }
           public synchronized void enSuspension(){
                      while(iniciar){
                                 try {
                                            wait();
                                 } catch (InterruptedException ex) {
                                            Logger.getLogger(ProductorIntro.class.getName()).log(Level.SEVERE, null, ex);
                                 }
                      }
           }

           
           
           @Override
           public void run(){
                      while(!isInterrupted()){
                                 
                                 enSuspension();
                                 
                                 try{
                                 
                                            Thread.sleep(Inicio_Sistema.Horas*Inicio_Sistema.cedula_Plot);
                                            int i;
                                            for(i = 0 ; i < plottwist; i++){
                                                       drive_PlotTwist.acquire();
                                            }
                                            //System.out.println(drive_PlotTwist.availablePermits());
                                            
                                 }catch(InterruptedException e){
                                            interrupt();
                                 }
                      }
                      
           }


           
           
}
