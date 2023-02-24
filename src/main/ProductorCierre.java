/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import static interfaz.casaRodaje.iniciar;
import java.util.concurrent.Semaphore;


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

           
           
           @Override
           public void run(){
                      try{
                                 while(iniciar){
                                            Thread.sleep(2000);
                                            int i;
                                            System.out.println(cierre);
                                            for(i = 0 ; i < cierre; i++){
                                                       drive_Cierre.acquire();
                                                       }
                                            }
                   
                                 
                      }catch(InterruptedException e){
                                 
                      }
                      
           }


           
           
}
