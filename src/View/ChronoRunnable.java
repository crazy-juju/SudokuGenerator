/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import static java.lang.Thread.currentThread;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author julien
 */
public class ChronoRunnable implements Runnable {

    ChronoPanel majifie;
    Boolean alive=true;
    private volatile Thread currentThread = null;
    
    public ChronoRunnable(ChronoPanel cp){
        majifie=cp;
    }
    
    
    @Override
    public void run() {
        currentThread = Thread.currentThread();
        while(alive){
        try {
            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            Thread.sleep(1000);
            majifie.sec++;
            if(majifie.sec==60){
                majifie.sec=0;
                majifie.min++;
            }
            majifie.init();
//            majifie.update(majifie.getGraphics());
            
            
            
        } catch (InterruptedException ex) {
           // Logger.getLogger(ChronoRunnable.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        } 
    
    }
    public void cancel(){
        currentThread.interrupt();
    }
    
}
