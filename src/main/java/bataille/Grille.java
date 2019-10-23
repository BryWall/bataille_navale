package bataille;

import java.util.ArrayList;

public class Grille {

    private Cell[][] grille; 
    private int dimension;
    private ArrayList<Bateau> bateaux;

    public Grille(int dimension, int nb_bateaux) {
        this.bateaux = new ArrayList<Bateau>(nb_bateaux);
        this.dimension = dimension;
        this.grille = new Cell[dimension][dimension];
        this.init();
        
    }
    public ArrayList<Bateau> getBateaux() {
    	return this.bateaux;
    }

    private void init(){
        for(int i = 0 ; i<this.dimension ; i++ ){
            for(int j = 0 ; j<this.dimension ; j++){
                this.grille[j][i] = new Cell(i,j);
            }
        }
    }


    public int getDimension(){
        return this.dimension;
    }

    public void addBateau(Bateau b) {
        int y = b.getY();
        int x = b.getX();
        int taille = b.getTaille();
        String orientation = b.getOrientation();
        if(orientation.equals("H")){
            for(int i=0 ; i<taille ; i++){
                grille[y][x+i].setBateau(b);;
            }
            
        }
        else{
            for(int i=0 ; i<taille ; i++){
                grille[y+i][x].setBateau(b);;
            }
        }
        this.bateaux.add(b);
    }

    public String toString() {
        String str = "";
        for(int i = 0; i< this.dimension ; i++){
            for(int j = 0; j< this.dimension ; j++){
                str += this.grille[i][j].toString();
            }
            str += "\n";
        }
        return str;
    }

    public String toStringHidden() {
        String str = "";
        for(int i = 0; i< this.dimension ; i++){
            for(int j = 0; j< this.dimension ; j++){
                str += this.grille[i][j].toStringHidden();
            }
            str += "\n";
        }
        return str;
    }


    public boolean isTouched(int[] coord) {
    	int x = coord[0];
    	int y = coord[1];
    	return this.grille[y][x].hasBateau();
    }

    public boolean isAlreadyUsed(int[] coord) {
    	int x = coord[0];
    	int y = coord[1];
    	return this.grille[y][x].isAttacked();
    	
    }

    public boolean isGameOver(){
    	for(Bateau b : this.bateaux){
            if(! b.isFlowed()){
                return false;
            }
        }
        return true;
    }

    public boolean canAddBateau(Bateau b){
        int taille = b.getTaille();
        int y = b.getY();
        int x = b.getX();
        String o = b.getOrientation();
        if(o.equals("H")){
            if((x + taille) <= this.dimension){
                for(int i=0 ; i<taille ; i++){
                    if(grille[y][x+i].hasBateau()){
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        else{
            if((y+ taille) <= this.dimension){
                for(int i=0 ; i<taille ; i++){
                    if(grille[y+i][x].hasBateau()){
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
    }

    public Cell getCell(int x, int y){
        return this.grille[y][x];
    }
	public void attack(int[] coord) {
        int x = coord[0];
        int y = coord[1];
        this.grille[y][x].attacked();
	}

}