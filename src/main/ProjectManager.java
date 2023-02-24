/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import interfaz.Inicio_Sistema;
import interfaz.casaRodaje;
import static interfaz.casaRodaje.iniciar;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author epidu
 */
public class ProjectManager  extends Thread{
           double sueldo;
           public static int dias_restantes;
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
                                            if(casaRodaje.contador == true){
                                                       drive_Restante.acquire();
                                                       Thread.sleep((Inicio_Sistema.Horas/24)*Inicio_Sistema.cedula_PM_contador);
                                                       casaRodaje.outputPM.setText("Chequeando progreso del dia");
                                                       dias_restantes -= 1;
                                                       drive_Restante.release();
                                                       casaRodaje.contador = false;
                                                       trabajando = true;
                                            }

                                            if (trabajando == true){
                                                       casaRodaje.Rick_Morty = true;
                                                       Thread.sleep(Inicio_Sistema.Horas*(15+Inicio_Sistema.cedula_PM_intervalos)/1440);
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
                                                       Thread.sleep(Inicio_Sistema.Horas*(15+Inicio_Sistema.cedula_PM_intervalos)/1440);
                                                       casaRodaje.outputPM.setText("Viendo Reviews");
                                                       casaRodaje.reviews = false;
                                                       trabajando = true;
                                                       flojeando = false;
                                            }
                                 }catch(InterruptedException e){
                                 interrupt();
                      }
                      }
                      
           }


           
           
}
