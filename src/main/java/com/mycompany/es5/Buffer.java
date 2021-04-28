/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.es5;

/**
 *
 * @author stefa
 */
import java.util.ArrayList;

public class Buffer
{
   public static ArrayList<Integer> Dati = new ArrayList<Integer>();
   
   public Buffer() {
       
   }
   
   public void AddDati(int dato){
       Dati.add(dato);
   }
   
   public int ReadDati(int i) {
       int datoLetto = 0;
       
       datoLetto = Dati.get(i);
       Dati.remove(i);
       
       return datoLetto;
   }
   
   public int getSize(){
       return Dati.size();
   }
   
   public boolean isFull() {
       boolean valore = false;
       
       if(getSize() == 10)
           valore = true;
       
       return valore;
   }
   
   public boolean isEmpty(){
       return Dati.isEmpty();
   }
}
