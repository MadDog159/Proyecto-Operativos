/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import interfaz.Inicio_Sistema;
import interfaz.casaRodaje;
import static interfaz.casaRodaje.iniciar;
import static interfaz.casaRodaje.modelo;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author epidu
 */
public class Director  extends Thread{
           double sueldo = 100;
           boolean vigilando = true;
           int min_val = 30, max_val = 90;
           int min_per = 500, max_per = 750;
           int reloj_intervalo;
           int reloj_periodo;
           int dias_restantes;
           public Semaphore drive_Restante;
           

           public Director(Semaphore drive_Restante) {
                      this.drive_Restante = drive_Restante;
           }

           public double getSueldo() {
                      return sueldo;
           }

           public void setSueldo(int sueldo) {
                      this.sueldo = sueldo;
           }
           
           public void GananciasNetas(){
                       for(int i = 0; i < casaRodaje.modelo.getSize(); i++){
                                 casaRodaje.CapitulosTotales  += Integer.parseInt(modelo.getElementAt(i));
                                 }
                       casaRodaje.Ganancia = (int) ((casaRodaje.CapitulosTotales + casaRodaje.CapitulosSobrantes) * 653333);
                       casaRodaje.GananciaNeta = casaRodaje.Ganancia - casaRodaje.faltas;
                                                                                        
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
                                            reloj_intervalo = (int) (Math.random() * (max_val - min_val));
                                            reloj_periodo = (int) (Math.random() * (max_per - min_per));
                                            
                                            if(drive_Restante.availablePermits() == 1){
                                                       if (vigilando == true){
                                                                  casaRodaje.verificar = true;
                                                                  casaRodaje.outputDirector.setText("Vigilando Project Manager");
                                                                  Thread.sleep(reloj_intervalo);
                                                                  vigilando = false;
                                                                  casaRodaje.verificar = false;

                                                       }else if(vigilando == false){
                                                                  casaRodaje.outputDirector.setText("Tomandose una taza de cafe");
                                                                  Thread.sleep(reloj_periodo);
                                                                  vigilando = true;
                                                                  casaRodaje.verificar = true;
                                                       }
                                            }else{                
                                                       drive_Restante.acquire();
                                                       casaRodaje.outputDirector.setText("Revisando Trabajo del Project Manager");
                                                       Thread.sleep(100);
                                                       //System.out.println("termina nojoda");
                                                       drive_Restante.release();                   
                                            }

                                            
                                 }catch(InterruptedException e){
                                            interrupt();
                                 }
                      }
                      
           }


           
           
}
