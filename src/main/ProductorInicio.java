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
public class ProductorInicio  extends Thread{
           int sueldo = 7;
           int inicio = 0;
           int Productor_Inicio = 0;
           public Semaphore drive_Inicio;

           public ProductorInicio(Semaphore drive_Inicio) {
                      this.drive_Inicio = drive_Inicio;
           }
           

           public int getSueldo() {
                      return sueldo;
           }

           public int getInicio() {
                      return inicio;
           }

           public void setSueldo(int sueldo) {
                      this.sueldo = sueldo;
           }

           public void setInicio(int inicio) {
                      this.inicio = inicio;
           }
           
           public int getProductor_Inicio() {
                      return Productor_Inicio;
           }

           public void setProductor_Inicio(int Productor_Inicio) {
                      this.Productor_Inicio = Productor_Inicio;
           }
           
           public void inicioCreada(){
                      inicio += Productor_Inicio;
           }
           
           public double pagoSueldos(){
                      sueldo = 24*7*Productor_Inicio;
                      return sueldo;
           }
           
           public void reducir(){
                      drive_Inicio.release();
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
                                 
                                            Thread.sleep(Inicio_Sistema.Horas*Inicio_Sistema.cedula_Inicio);
                                            int i;
                                            for(i = 0 ; i < inicio; i++){
                                                       drive_Inicio.acquire();
                                            }
                                            
                                 }catch(InterruptedException e){
                                            interrupt();
                                 }
                      }
                      
           }


           
           
}
