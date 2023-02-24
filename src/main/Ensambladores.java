/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import interfaz.Inicio_Sistema;
import interfaz.casaRodaje;
import static interfaz.casaRodaje.iniciar;
import java.util.logging.Level;
import java.util.logging.Logger;
import main.ProductorIntro;

/**
 *
 * @author epidu
 */
public class Ensambladores extends Thread {
           double sueldo;
           int capitulos;
           int ensambladores;
           int capCreados;
           public static boolean capitulo_creado = false;
           public static boolean capitulo_creadoPlot = false;
           public static boolean reducir_Plot = false;
           int intro, inicio,cierre, creditos,plot;

           public void setIntro(int intro) {
                      this.intro = intro;
           }

           public void setInicio(int inicio) {
                      this.inicio = inicio;
           }

           public void setCierre(int cierre) {
                      this.cierre = cierre;
           }

           public void setCreditos(int creditos) {
                      this.creditos = creditos;
           }

           public void setPlot(int plot) {
                      this.plot = plot;
           }
           
           
           

           public int getEnsambladores() {
                      return ensambladores;
           }

           public void setEnsambladores(int ensambladores) {
                      this.ensambladores = ensambladores;
           }
           
           public double getSueldo() {
                      return sueldo;
           }

           public void setSueldo(double sueldo) {
                      this.sueldo = sueldo;
           }

           public int getCapitulos() {
                      return capitulos;
           }

           public void setCapitulos(int capitulos) {
                      this.capitulos = capitulos;
           }

           public int getCapCreados() {
                      return capCreados;
           }
           
           
           
           public double pagoSueldos(){
                      sueldo = 24*8*ensambladores;
                      return sueldo;
           }
           
           public void capituloCreada(){
                      capitulos += ensambladores;
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
                                 
                                            Thread.sleep(Inicio_Sistema.Horas*2);
                                            capCreados =0;
                                                       if(capitulo_creado == true){
                                                                  
                                                                  for(int i = 0; i< ensambladores;i++){
                                                                             
                                                                             if(casaRodaje.parteIntro > intro-1){
                                                                                        casaRodaje.parteIntro -=intro;
                                                                                        if(casaRodaje.parteInicio > inicio-1){
                                                                                                   casaRodaje.parteInicio -=inicio;
                                                                                                   if(casaRodaje.parteCierre > cierre-1){
                                                                                                              casaRodaje.parteCierre -=cierre;
                                                                                                              if(casaRodaje.parteCreditos > creditos-1){
                                                                                                                         casaRodaje.parteCreditos-=creditos;
                                                                                                                         
                                                                                                                         if(casaRodaje.partePlot > plot-1 && capitulo_creadoPlot == true){
                                                                                                                                    casaRodaje.partePlot -=plot;
                                                                                                                                    capitulos += 1;
                                                                                                                                    capCreados ++;
                                                                                                                                    capitulo_creadoPlot = false;
                                                                                                                                    reducir_Plot = true;
                                                                                                                         }else{
                                                                                                                                    
                                                                                                                                    capitulos += 1;
                                                                                                                                    capCreados ++;
                                                                                                                         }
                                                                                                              }else{
                                                                                                              }
                                                                                                   }else{
                                                                                                   }
                                                                                        }else{
                                                                                        }
                                                                             }else{
                                                                             }
                                                                  }capitulo_creado = false;
                                                       }
                                                       
                                            
                                            
                                            
                                 }catch(InterruptedException e){
                                            interrupt();
                                 }
                     }
           }
           
           
           
}
