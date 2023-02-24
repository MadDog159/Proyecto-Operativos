/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import static interfaz.casaRodaje.iniciar;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import static main.Ensambladores.capitulo_creado;


/**
 *
 * @author epidu
 */
public class ProductorIntro  extends Thread{
           int sueldo;
           int intros = 0;
           int Productor_Intro = 0;
           public  Semaphore drive_Intro;
           

           public ProductorIntro(Semaphore drive_Intro) {
                      this.drive_Intro = drive_Intro;
           }
           

           public int getSueldo() {
                      return sueldo;
           }

           public int getIntros() {
                      return intros;
           }

           public void setSueldo(int sueldo) {
                      this.sueldo = sueldo;
           }

           public void setIntros(int intros) {
                      this.intros = intros;
           }
           
           public int getProductor_Intro() {
                      return Productor_Intro;
           }

           public void setProductor_Intro(int Productor_Intro) {
                      this.Productor_Intro = Productor_Intro;
           }
           
           public void introCreada(){
                      intros += Productor_Intro;
           }
           
           public double pagoSueldos(){
                      sueldo = 24*5*Productor_Intro;
                      return sueldo;
           }
           
           public  void reducir(){
                      drive_Intro.release();
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
//                                            System.out.println("esta entrando y no deberia");
                                            wait();
                                 } catch (InterruptedException ex) {
                                            Logger.getLogger(ProductorIntro.class.getName()).log(Level.SEVERE, null, ex);
                                 }
                      }
           }
           
           /**
            *
            */
           @Override
           public void run(){
                      
                      while(!isInterrupted()){ 
                                 
                                 enSuspension();
//                                 System.out.println(iniciar);

                                 try{
                                            Thread.sleep(500);      
                                            int i;
                                            for(i = 0 ; i < intros; i++){
                                                       drive_Intro.acquire();
                                            }
                                 
                                 }catch(InterruptedException e){
                                            interrupt();
                                 }
                      
                      }
           }

}
