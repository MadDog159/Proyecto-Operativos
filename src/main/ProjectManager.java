/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import interfaz.Inicio_Sistema;
import interfaz.casaRodaje;
import static interfaz.casaRodaje.iniciar;
import java.util.concurrent.Semaphore;


/**
 *
 * @author epidu
 */
public class ProjectManager  extends Thread{
           double sueldo;
           int dias_restantes;
           boolean trabajando;
           boolean flojeando;
           public Semaphore drive_Restante;
           

           public ProjectManager(Semaphore drive_Restante) {
                      this.drive_Restante = drive_Restante;
           }

           public double getSueldo() {
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
                                 while(iniciar){
                                            if(casaRodaje.contador == true){
                                                       drive_Restante.acquire();
                                                       Thread.sleep(166,6);
                                                       casaRodaje.outputPM.setText("Chequeando progreso del dia");
                                                       dias_restantes -= 1;
                                                       drive_Restante.release();
                                                       casaRodaje.contador = false;
                                                       trabajando = true;
                                            }

                                            if (trabajando == true){
                                                       casaRodaje.Rick_Morty = true;
                                                       Thread.sleep(12,5);
                                                       casaRodaje.outputPM.setText("Viendo Rick y Morty");
                                                       if(casaRodaje.verificar == true){
                                                                  casaRodaje.faltas +=1;
                                                       }
                                                       casaRodaje.Rick_Morty = false;
                                                       trabajando = false;
                                                       flojeando = true;
                                            }
                                            if(flojeando == true){
                                                       casaRodaje.reviews = true;
                                                       Thread.sleep(12,5);
                                                       casaRodaje.outputPM.setText("Viendo Reviews");
                                                       casaRodaje.reviews = false;
                                                       trabajando = true;
                                                       flojeando = false;
                                            }
                                 }

                                 
   
                                 
                      }catch(InterruptedException e){
                                 
                      }
                      
           }


           
           
}
