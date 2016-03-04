/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Grid;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JComponent;

/**
 *
 * @author julien
 */
public class GridDraw extends JComponent implements MouseListener,KeyListener {
    
    Grid displayed;
    
    
    public GridDraw(Grid g){
        displayed=g;
        
        
        
        this.addMouseListener(this);
        
        
    }

    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponents(g); //To change body of generated methods, choose Tools | Templates.
        g=(Graphics2D)g;
       
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(displayed.getTab()[j][i].isSelected()){
                    g.setColor(Color.green);
                    g.fillRect(j*50, i*50,50,50);                   
                }
                g.setColor(Color.black);
                
                g.drawRect(j*50, i*50,50,50);
                if(displayed.getTab()[j][i].getNumber()!=0){
                    if(displayed.getTab()[j][i].isDisplayed()){
                         g.setColor(Color.RED);
                    }
                    if(displayed.getTab()[j][i].isWritten()){
                         g.setColor(Color.BLUE);
                    }
                    g.drawString(" "+displayed.getTab()[j][i].getNumber()+" ",20+ (j)*50, ((i+1)*50)-20);
                }
            }
        }
        this.setSize(new Dimension(600,600));
       
        
        
    }
    
    
    public boolean isGridCorrect(){
        boolean result=true;
        if(this.isGridDisplayedComplete(this.displayed)){
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    if(!this.displayed.getTab()[j][i].isGenerationSquarecorrect(this.displayed)){
                        result=false;
                    }
                }
            }
        }else{
            result=false;
        }
        return result;
    }
    
    public boolean isGridDisplayedComplete(Grid g){
        boolean result=true;
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(g.getTab()[j][i].getNumber()==0){
                    result=false;
                }
            }
        }

        return result;
    }
    
    

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
           
        int x= e.getX()/50;
        int y= e.getY()/50;
        if(x<9 && y<9){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                displayed.getTab()[j][i].setSelected(false);
            }
        }
        displayed.getTab()[x][y].setSelected(true);
        this.repaint();
        }
           
    
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
     // System.out.println(e.getKeyChar());
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       if(e.getKeyChar()>'0' &&e.getKeyChar()<='9' ){
           for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(displayed.getTab()[j][i].isSelected() && displayed.getTab()[j][i].isDisplayed()==false){
                    displayed.getTab()[j][i].setNumber(e.getKeyChar()-'0');
                    displayed.getTab()[j][i].setWritten(true);
                }
            }
        } 
           this.repaint();
           if(this.isGridCorrect()){
               WinPopUp wp = new WinPopUp();
           }
           
           
       }
        System.out.println(e.getKeyChar());
       
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
       if(e.getKeyCode()==e.VK_UP){ //Top arrow
           boolean move=true;
           for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(displayed.getTab()[j][i].isSelected() && move){
                      if(i!=0){
                          displayed.getTab()[j][i].setSelected(false);
                          displayed.getTab()[j][i-1].setSelected(true);
                          move=false;
                          this.repaint();
                          
                      }
                }
            }
        }      
       }
        if(e.getKeyCode()==e.VK_DOWN){ //Bottom Arrow
            boolean move=true;
           for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(displayed.getTab()[j][i].isSelected() && move){
                      if(i!=8){
                          displayed.getTab()[j][i].setSelected(false);
                          displayed.getTab()[j][i+1].setSelected(true);
                          move=false;
                          this.repaint();
                          
                      }
                }
            }
        }      
       }
       if(e.getKeyCode()==e.VK_RIGHT){ //Right Arrow
           boolean move=true;
           for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(displayed.getTab()[j][i].isSelected() && move){
                      if(j!=8){
                          displayed.getTab()[j][i].setSelected(false);
                          displayed.getTab()[j+1][i].setSelected(true);
                          move=false;
                          this.repaint();
                          
                      }
                }
            }
        }      
       }
        if(e.getKeyCode()==e.VK_LEFT){ //LeftArrow
            boolean move=true;
           for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(displayed.getTab()[j][i].isSelected() && move){
                      if(j!=0){

                          displayed.getTab()[j][i].setSelected(false);
                          displayed.getTab()[j-1][i].setSelected(true);
                          move=false;
                          this.repaint();
                          
                      }
                }
            }
        }      
       }
    
    }

    @Override
    public void keyReleased(KeyEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
