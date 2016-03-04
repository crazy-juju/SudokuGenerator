/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author julien
 */
public class WinPopUp extends JDialog implements ActionListener {
    JPanel pano = new JPanel();
    JButton valid=new JButton(" Ok ");
    JLabel congratulations= new JLabel(" Bravo vous avez complété correctement la grille vous pouvez si vous le souhaitez lancer une nouvelle grille en augmentant le niveau de difficulté ");

    public WinPopUp(){
        valid.addActionListener(this);
        GridBagConstraints cont = new GridBagConstraints();
        pano.setLayout(new GridBagLayout());
        cont.fill= GridBagConstraints.BOTH;
        cont.gridx=0;
        cont.gridy=0;
        pano.add(congratulations,cont);
        cont.gridy=1;
        pano.add(valid,cont);
        this.setContentPane(pano);
        this.setVisible(true);
        this.setTitle(" Bravo ! ");
        this.pack();
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(e.getSource()==valid){
           this.dispose();
       }
    
    }


}
