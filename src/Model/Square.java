/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author julien
 */
public class Square {
    private int x,y,number,line,col,sub_grid;
     private boolean selected=false,displayed=false,written=false;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        line=y;
        col=x;
        if(x<3 && y<3){
         sub_grid=0;   
        }else{
          if(x<3 && y>2 && y<6){
              sub_grid=3;
          }else{
              if(x<3 && y>5 ){
                  sub_grid=6;
              }else{
                  if(x>2 && x<6 && y<3){
                      sub_grid=1;
                  }else{
                      if(x>2 && x<6 && y>2 && y<6){
                          sub_grid=4;
                      }else{
                          if(x>2 && x<6 && y>5){
                              sub_grid=7;
                          }else{
                              if(x>5 && y<3){
                                  sub_grid=2;
                              }else{
                                  if(x>5 && y>2 && y<6){
                                      sub_grid=5;
                                  }else{
                                      if(x>5 && y>5){
                                          sub_grid=8;
                                      }
                                  }
                              }
                          }
                      }
                  }
              }
          }  
        }
        
            
        
    }

    public boolean isDisplayed() {
        return displayed;
    }

    public void setDisplayed(boolean displayed) {
        this.displayed = displayed;
    }

    public boolean isWritten() {
        return written;
    }

    public void setWritten(boolean written) {
        this.written = written;
    }

    
    
    
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    
    public boolean isGenerationSquarecorrect(Grid g){
        return (issub_gridcorrect(g) && iscolumncorrect(g) && islinecorrect(g) && this.getNumber()!=0);
    }
    
    public boolean issub_gridcorrect(Grid g){
        //Init tab tmp before the check
        int counter=0;
        Square[] tab= new Square[9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
              if(g.getTab()[j][i].getSub_grid()==this.getSub_grid() && !(g.getTab()[j][i].getCol()==col && g.getTab()[j][i].getLine()==line)){
                  tab[counter]=g.getTab()[j][i];
                  counter++;
              }
            }
        }
     //   counter++;
        //Checking
        boolean check=true;
        for(int i=0;i<counter;i++){
            if(tab[i].getNumber()==this.getNumber()){
                check=false;
            }
        }
        
        return check;
    }
    
    public boolean iscolumncorrect(Grid g){
        //Init tab tmp before the check
        int counter=0;
        Square[] tab= new Square[9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
              if(g.getTab()[j][i].getCol()==this.getCol() && !(g.getTab()[j][i].getCol()==col && g.getTab()[j][i].getLine()==line)){
                  tab[counter]=g.getTab()[j][i];
                  counter++;
              }
            }
        }
       // counter++;
        //Checking
        boolean check=true;
        for(int i=0;i<counter;i++){
            if(tab[i].getNumber()==this.getNumber()){
                check=false;
            }
        }
        
        return check;
    }

    public boolean islinecorrect(Grid g){
        //Init tab tmp before the check
        int counter=0;
        Square[] tab= new Square[9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
              if(g.getTab()[j][i].getLine()==this.getLine() && !(g.getTab()[j][i].getCol()==col && g.getTab()[j][i].getLine()==line)){
                  tab[counter]=g.getTab()[j][i];
                  counter++;
              }
            }
        }
        
       // counter++;
        //Checking
        boolean check=true;
        for(int i=0;i<counter;i++){
            if(tab[i].getNumber()==this.getNumber()){
                check=false;
            }
        }
        
        return check;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getSub_grid() {
        return sub_grid;
    }

    public void setSub_grid(int sub_grid) {
        this.sub_grid = sub_grid;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
    
}
