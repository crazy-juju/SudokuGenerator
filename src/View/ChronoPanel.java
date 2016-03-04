/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author julien
 */
public class ChronoPanel extends JPanel {
    
    
    JLabel timer;
    int min=0,sec=0;
    
    public void init(){
        this.removeAll();
        this.setVisible(false);
        timer= new JLabel(" "+min+" : "+sec+" ");
        //System.out.println(timer.getText());
        this.add(timer);
        this.setVisible(true);
    }
    
    public ChronoPanel(){
        timer=new JLabel();
        init();
        
    }
    
}
