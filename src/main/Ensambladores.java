/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import interfaz.casaRodaje;
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

           
           
           @Override
           public void run(){
                      try{
                                 while(true){
                                            Thread.sleep(2000);
                                            capCreados =0;
                                                       if(capitulo_creado == true){
                                                                  for(int i = 1; i< ensambladores;i++){
                                                                             if(casaRodaje.parteIntro > 0){
                                                                                        casaRodaje.parteIntro --;
                                                                                        if(casaRodaje.parteInicio > 0){
                                                                                                   casaRodaje.parteInicio --;
                                                                                                   if(casaRodaje.parteCierre > 0){
                                                                                                              casaRodaje.parteCierre --;
                                                                                                              if(casaRodaje.parteCreditos > 0){
                                                                                                                         casaRodaje.parteCreditos--;
                                                                                                                         
                                                                                                                         if(casaRodaje.partePlot > 0 && capitulo_creadoPlot == true){
                                                                                                                                    casaRodaje.partePlot--;
                                                                                                                                    capitulos += 1;
                                                                                                                                    capCreados ++;
                                                                                                                                    capitulo_creadoPlot = false;
                                                                                                                         }else{
                                                                                                                                    capitulos += 1;
                                                                                                                                    capCreados ++;
                                                                                                                                    capitulo_creado = false;
                                                                                                                         }
                                                                                                              }else{
                                                                                                                         break;
                                                                                                              }
                                                                                                   }else{
                                                                                                              break;
                                                                                                   }
                                                                                        }else{
                                                                                                   break;
                                                                                        }
                                                                             }else{
                                                                                        break;
                                                                             }
                                                                  }
                                                       }
                                                       
                                            
                                            
                                            
                                 }
                      }catch(InterruptedException e){
                                 
                      }
                      
           }
           
           
           
}
