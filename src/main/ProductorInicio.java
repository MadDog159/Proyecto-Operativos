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

           
           
           @Override
           public void run(){
                      try{
                                 while(iniciar){
                                            Thread.sleep(3000);
                                            int i;
                                            for(i = 0 ; i < inicio; i++){
                                                       drive_Inicio.acquire();
                                            }
                                            
                                 }
                      }catch(InterruptedException e){
                                 
                      }
                      
           }


           
           
}
