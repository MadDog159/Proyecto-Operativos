/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import interfaz.casaRodaje;
import java.util.concurrent.Semaphore;


/**
 *
 * @author epidu
 */
public class ProjectManager  extends Thread{
           int sueldo;
           int dias_restantes;
           boolean trabajando;
           boolean flojeando;
           public Semaphore drive_Restante;
           

           public ProjectManager(Semaphore drive_Restante) {
                      this.drive_Restante = drive_Restante;
           }

           public int getSueldo() {
                      return sueldo;
           }

           public void setSueldo(int sueldo) {
                      this.sueldo = sueldo;
           }

           public int getDias_restantes() {
                      return dias_restantes;
           }

           public void setDias_restantes(int dias_restantes) {
                      this.dias_restantes = dias_restantes;
           }

           public double pagoSueldos(){
                      sueldo = 24*7;
                      return sueldo;
           }
           

           @Override
           public void run(){
                      try{
                                 if(casaRodaje.contador == true){
                                            drive_Restante.acquire();
                                            Thread.sleep(166,6);
                                            drive_Restante.release();
                                            casaRodaje.contador = false;
                                 }

                                 if (trabajando == true){
                                            casaRodaje.Rick_Morty = true;
                                            Thread.sleep(12,5);
                                            casaRodaje.Rick_Morty = false;
                                            trabajando = false;
                                            flojeando = true;
                                 }
                                 if(flojeando == true){
                                            casaRodaje.reviews = true;
                                            Thread.sleep(12,5);
                                            casaRodaje.reviews = false;
                                            trabajando = true;
                                            flojeando = false;
                                 }
   
                                 
                      }catch(InterruptedException e){
                                 
                      }
                      
           }


           
           
}
