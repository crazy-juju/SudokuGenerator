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
public class Grid {
    private Square[][] tab;
    
    public Grid(){
        tab = new Square[9][9];
        
        //Init Square's tab
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                tab[j][i]= new Square(j,i);
                //System.out.println("-->"+tab[j][i].getSub_grid());
            }
        }
    }

    public Square[][] getTab() {
        return tab;
    }
    
    public void re_initgrid(){
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                tab[j][i].setNumber(0);
            }
        }
    }
    
    public void re_initline(int l){
        for(int i=0;i<9;i++){
            tab[i][l].setNumber(0);
        }
    }
    
    public void generate_grid(){
        
        
        
        //Init Square's tab's values
       
        
        
        
            for(int i=0;i<9;i++){
                for(int j=0;j<9;j++){
                    int cpt=0;
                    int cpt2=0;
                    while(!tab[j][i].isGenerationSquarecorrect(this)){
                        
                        int tmp =(int) (Math.random()*9)+1;
                        tab[j][i].setNumber(tmp);
                       // System.out.println("Tmp = "+tmp);
                        //cpt++;
                        cpt2++;
                        if(cpt==100){
                            re_initline(i);
                            j=0;
                            cpt=0;
                            
                        }
                        if(cpt2==1000){
                            re_initgrid();
                            j=0;
                            i=0;
                            cpt2=0;
                            cpt=0;
                        }
                    }
                    //System.out.println("Valeur en "+j+" , "+i+" vaut = "+tab[j][i].getNumber());
                }
            }
        
        
    }
    
    public boolean isGridGenerationComplete(){
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(this.getTab()[j][i].getNumber()==0){
                    return false;
                }
            }
        }
        return true;
    }
        
    public String ConsoleDisplay (){
        String s="";
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                s+=tab[j][i].getNumber()+" | ";
            }
            s+="\n";
        }
        return s;
    }
    
}
