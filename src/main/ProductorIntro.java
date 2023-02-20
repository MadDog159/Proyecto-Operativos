/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author epidu
 */
public class ProductorIntro  extends Thread{
           int sueldo = 5;
           int intros = 0;
           int Productor_Intro = 0;
           int drive = 30;
           public Semaphore drive_Intro;

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
           
           public int getDrive() {
                      return drive;
           }

           public void setDrive(int drive) {
                      this.drive = drive;
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

           
           
           @Override
           public void run(){
                      try{
                                 while(true){
                                            drive_Intro.acquire(intros);
                                            Thread.sleep(500);
                                 }
                      }catch(InterruptedException e){
                                 
                      }
                      
           }


           
           
}
