/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import static interfaz.casaRodaje.iniciar;
import java.util.concurrent.Semaphore;
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
           
           /**
            *
            */
           @Override
           public void run(){
                      try{
                                 while(iniciar){
                                            Thread.sleep(500);
                                            int i;
                                            for(i = 0 ; i < intros; i++){
                                                       drive_Intro.acquire();
                                            }
                                            //System.out.println(drive_Intro.availablePermits());


   
                                 }
                      }catch(InterruptedException e){
                                 
                      }
                      
           }


           
           
}
