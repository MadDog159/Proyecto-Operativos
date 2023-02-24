/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import static interfaz.casaRodaje.iniciar;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author epidu
 */
public class ProductorCreditos  extends Thread{
           int sueldo = 3;
           int creditos = 0;
           int Productor_Creditos = 0;
           public Semaphore drive_Creditos;

           public ProductorCreditos(Semaphore drive_Creditos) {
                      this.drive_Creditos = drive_Creditos;
           }
           

           public int getSueldo() {
                      return sueldo;
           }

           public int getCreditos() {
                      return creditos;
           }

           public void setSueldo(int sueldo) {
                      this.sueldo = sueldo;
           }

           public void setCreditos(int creditos) {
                      this.creditos = creditos;
           }
           
           public int getProductor_Creditos() {
                      return Productor_Creditos;
           }

           public void setProductor_Creditos(int Productor_Creditos) {
                      this.Productor_Creditos = Productor_Creditos;
           }
           
           public void creditosCreada(){
                      creditos += Productor_Creditos;
           }
           
           public double pagoSueldos(){
                      sueldo = 24*3*Productor_Creditos;
                      return sueldo;
           }
           
           public void reducir(){
                      drive_Creditos.release();
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
                                            Thread.sleep(500);
                                            int i;
                                            for(i = 0 ; i < creditos; i++){
                                                       drive_Creditos.acquire();
                                            }
                                 }catch(InterruptedException e){
                                            interrupt();
                                 }
                      }
           }


           
           
}
