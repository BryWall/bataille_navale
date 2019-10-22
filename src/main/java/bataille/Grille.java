package bataille;

import java.util.ArrayList;

public class Grille {

    private int[][] grille; 
    private int dimension;
    private ArrayList<Bateau> bateaux;

    public Grille(int dimension, int nb_bateaux) {
        this.bateaux = new ArrayList<Bateau>(nb_bateaux);
        this.dimension = dimension;
        this.grille = new int[dimension][dimension];
    }
    public ArrayList<Bateau> getBateaux() {
    	return this.bateaux;
    }


    public int getDimension(){
        return this.dimension;
    }

    public boolean addBateau (Bateau b){
        int taille = b.getTaille();
        int x = b.getX();
        int y = b.getY();
        String orientation = b.getOrientation();
        if(orientation.equals("H")){
            if(this.dimension > (x + taille)){
                for(int i=0 ; i<taille ; i++){
                    if(grille[y][x+i] == 1){
                        return false;
                    }
                }
            }
            else{
                return false;
            }
        }
        else {
            if(this.dimension > (y + taille)){
                for(int i=0 ; i<taille ; i++)
                    if(grille[y+i][x] == 1){
                        return false;
                    }
            }
            else{
                return false;
            }
        }
        return this.addBateautoGrille(b);
    }

    private boolean addBateautoGrille(Bateau b) {
        int y = b.getY();
        int x = b.getX();
        int taille = b.getTaille();
        String orientation = b.getOrientation();
        if(orientation.equals("H")){
            for(int i=0 ; i<taille ; i++){
                grille[y][x+i] = 1;
            }
            
        }
        else{
            for(int i=0 ; i<taille ; i++){
                grille[y+i][x] =  1;
            }
        }
        this.bateaux.add(b);
        return true;
    }

    public String toString() {
        String str = "";
        for(int i = 0; i< this.dimension ; i++){
            for(int j = 0; j< this.dimension ; j++){
                str += this.grille[i][j];
            }
            str += "\n";
        }
        return str;
    }
    public String toStringHidden() {
    	String str = "";
    	for(int i = 0; i< this.dimension ; i++){
            for(int j = 0; j< this.dimension ; j++){
                if((this.grille[i][j] == 0) || (this.grille[i][j] == 1)) {
                	str += "?";
                }
                else {
                	str += this.grille[i][j];
                }
            }
            str += "\n";
        }
    	return str;
    }


    public boolean isTouched(int[] coord) {
    	int x = coord[0];
    	int y = coord[1];
    	if(this.grille[y][x] == 1) {
    		this.grille[y][x] = 2;
    		return true;
    	}
    	this.grille[y][x] = 3;
    	return false;
    }
    public boolean isAlreadyUsed(int[] coord) {
    	int x = coord[0];
    	int y = coord[1];
    	return ((this.grille[y][x] == 2) ||  (this.grille[y][x] == 3));
    	
    }

    public boolean isGameOver(){
    	int dim = this.getDimension();
    	for(int i=0; i<dim;i++) {
    		for(int j=0; j<dim;j++) {
    			if( this.grille[i][j] == 1) {
    				return false;
    			}
    		}
    	}
    	return true;
    }


}