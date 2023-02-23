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

           
           
           @Override
           public void run(){
                      try{
                                 while(true){
                                            Thread.sleep(500);
                                            int i;
                                            for(i = 0 ; i < creditos; i++){
                                                       drive_Creditos.acquire();
                                            }
                                            
                                 }
                      }catch(InterruptedException e){
                                 
                      }
                      
           }


           
           
}
