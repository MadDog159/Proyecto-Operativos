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
public class ProductorCierre  extends Thread{
           double sueldo = 7.5;
           int cierre = 0;
           int Productor_cierre = 0;
           public Semaphore drive_Cierre;

           public ProductorCierre(Semaphore drive_Cierre) {
                      this.drive_Cierre = drive_Cierre;
           }
           

           public double getSueldo() {
                      return sueldo;
           }

           public int getCierre() {
                      return cierre;
           }

           public void setSueldo(double sueldo) {
                      this.sueldo = sueldo;
           }

           public void setCierre(int cierre) {
                      this.cierre = cierre;
           }
           
           public int getProductor_cierre() {
                      return Productor_cierre;
           }

           public void setProductor_cierre(int Productor_cierre) {
                      this.Productor_cierre = Productor_cierre;
           }
           
           public void cierreCreada(){
                      cierre += Productor_cierre;
           }
           
           public double pagoSueldos(){
                      sueldo = 24*7.5*Productor_cierre;
                      return sueldo;
           }
           
           public void reducir(){
                      drive_Cierre.release(2);
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
                                            Thread.sleep(Inicio_Sistema.Horas*Inicio_Sistema.cedula_Cierre);
                                            int i;
                                            System.out.println(cierre);
                                            for(i = 0 ; i < cierre; i++){
                                                       drive_Cierre.acquire();
                                                       }
                                 }catch(InterruptedException e){
                                            interrupt();
                                 }
                      }
           }


           
           
}
