/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author epidu
 */
public class ProductorIntro {
           int sueldo = 5;
           int intros = 0;
           int drive = 30;

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
           
           public void introCreada(){
                      intros +=2;
           }

           public int getDrive() {
                      return drive;
           }

           public void setDrive(int drive) {
                      this.drive = drive;
           }
           
           public void sinDrive(){
                      drive = 0;
           }
           
}
