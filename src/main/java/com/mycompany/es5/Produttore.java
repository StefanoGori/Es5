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
import com.mycompany.es5.Semaforo;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Produttore extends Thread
{
    Semaforo pieno;
    Semaforo vuoto;
    
    public Produttore(Semaforo semaforo1, Semaforo semaforo2){
        pieno = semaforo1;
        vuoto = semaforo2;
    }

    @Override
    public void run() {
        int i = 0;
        int n = 0;
        Random rand = new Random();
        Buffer generaDati = new Buffer();
        
        
        while(Main.STOP) {
            if(generaDati.isEmpty() == true){
                try {
                    for(i = 0; i < 10; i++){
                        vuoto.P();                 
                        n = rand.nextInt(50);  
                        generaDati.AddDati(n); 
                        System.out.println(Thread.currentThread().getName() + ": Il Dato Generato è: " + n);  
                    
                        if(generaDati.isFull()){
                            for(i = 0; i < 10; i++)
                            pieno.V();            
                        }
                    }
                
                    Thread.sleep(5000);  
                } 
                catch (InterruptedException ex){
                    Logger.getLogger(Produttore.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        for(i = 0; i < 10; i++){
             pieno.V();
        }
        System.out.println("Produttore è uscito dal ciclo");
    }  
}
