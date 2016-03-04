/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Grid;
import java.awt.GridBagConstraints;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 *
 * @author julien
 */
public class ViewPanel extends JPanel {
    
    Grid displayed;
    GridDraw gd;
    ChronoPanel cp;
    GridBagConstraints cont =new GridBagConstraints();
    Thread t;
    ChronoRunnable cr;
     public void start_chrono(){
        
        
        cont.gridx=0;
        cont.gridy=0;       
        this.add(cp,cont);
        
        t.run();
        
     }
     
     public void stop_chrono(){
       cp.min=0;
        cp.sec=0;
     }
     
    public ViewPanel(Grid g){
        
        
        
        cont.fill= GridBagConstraints.BOTH;
        displayed=g;
        gd=new GridDraw(displayed);
        this.addKeyListener(gd);
        cont.gridy=5;
        cont.gridx=0;
        this.add(gd,cont);
        cp= new ChronoPanel();
        cr = new ChronoRunnable(cp);
        t = new Thread(cr);
        this.setVisible(true);
        
    }
}
