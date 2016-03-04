/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Grid;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author julien
 */
public class GlobalView extends JFrame implements ActionListener {
    ViewPanel pano ;
    Grid displayed,correction;
    int difficulty; //0 =easy ; 1=normal; 2=hard
    JMenuBar bar;
    JMenu menu,neo;
    JMenuItem export,easy,normal,hard;
    
    public void init_Grid(){
        int nb_square_visible=0;
        if(difficulty==0){
            nb_square_visible=35;
        }
        if(difficulty==1){
            nb_square_visible=30;
        }
        if(difficulty==2){
            nb_square_visible=25;
        }
        
        int tmp,counter;
        boolean[] t= new boolean[81];
        for(int i=0;i<81;i++){
            t[i]=false;
        }
        for(int i=0;i<nb_square_visible;i++){
            tmp=(int)(Math.random()*80);
            if(t[tmp]==true){
                i--;
            }else{
                counter=0;
                for(int j=0;j<9;j++){
                    for(int k=0;k<9;k++){
                        counter++;
                        if(tmp==counter){
                            t[tmp]=true;
                            displayed.getTab()[k][j].setNumber(correction.getTab()[k][j].getNumber());
                            displayed.getTab()[k][j].setDisplayed(true);
                        }
                    }
                }
            }
        }
        
        
        pano= new ViewPanel(displayed);
        this.addKeyListener(pano.gd);
        
        this.setContentPane(pano);
        
        this.setSize(1000,600);
        this.setTitle("Sudoku Generator by Crazy juju");
        this.setVisible(true);
       
        
    }
    
    
    public GlobalView(){
        difficulty=0;
        displayed=new Grid();
        correction=new Grid();
        correction.generate_grid();
        
        
        GridBagConstraints cont = new GridBagConstraints();
        cont.fill= GridBagConstraints.BOTH;
        this.getContentPane().setLayout(new GridBagLayout());
        
        
        
        
        
        
        
        bar= new JMenuBar();
        menu=new JMenu(" Menu ");
        neo= new JMenu(" Nouvelle Partie ");
        neo.addActionListener(this);
        export = new JMenuItem(" Imprimer la Grille ");
        export.addActionListener(this);
        easy=new JMenuItem(" Difficulté Facile ");
        easy.addActionListener(this);
        normal=new JMenuItem(" Difficulté Normale");
        normal.addActionListener(this);
        hard=new JMenuItem(" Difficulté Difficile ");
        hard.addActionListener(this);
        
        
        
        neo.add(easy);
        neo.add(normal);
        neo.add(hard);
        menu.add(neo);
        menu.add(export);
        bar.add(menu);
        
        
        
        
        this.setJMenuBar(bar);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.init_Grid();
        System.out.println(this.correction.ConsoleDisplay());
      // pano.start_chrono();
       
        
    }

    public void export_in_png(){
        BufferedImage bi = new BufferedImage(this.getSize().width, this.getSize().height, BufferedImage.TYPE_INT_ARGB); 
        Graphics g = bi.createGraphics();
        this.getContentPane().getComponent(0).paint(g);  //this == JComponent
        g.dispose();
        String s=" Grille n°";
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                s+=this.displayed.getTab()[j][i].getNumber();
            }
        }
        
        
        
        
        try{ImageIO.write(bi,"png",new File(s+".png"));}catch (Exception e) {}
    }
    
    public void create_new_grid(){
        
        //pano.removeAll();
        displayed=new Grid();
        correction=new Grid();
        correction.generate_grid();
        this.init_Grid();
        pano.stop_chrono();
        //pano.start_chrono();
        
    }
    
    
    
    
    
    public boolean isGameComplete (){
        boolean result=true;
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(this.correction.getTab()[j][i].getNumber()==this.displayed.getTab()[j][i].getNumber()){
                    result=false;
                }
            }
        }
        
        return result;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==export){
            this.export_in_png();
        }
        if(e.getSource()==easy){
            difficulty=0;
            this.create_new_grid();
            
            
        }
        if(e.getSource()==normal){
            difficulty=1;
            this.create_new_grid();
        }
        if(e.getSource()==hard){
            difficulty=2;
            this.create_new_grid();
        }
    
       
    }
}
