package bataille;

import java.util.ArrayList;

import bataille.scanner.MyScanner;

public class Player {
    private Grille grille;
    private String name;
    private int[] nb_bateaux;
	private MyScanner scanner;
	private boolean turn;

    public Player(String name, int dimension_grille, int[] nb_bat) {
        this.grille = new Grille(dimension_grille,nb_bat.length);
        this.name = name;
        this.nb_bateaux = nb_bat;
        this.scanner = new MyScanner(this.grille);
		this.addBateauxToGrille();
		this.turn = false;
    }

    public String getName() {
        return name;
	}
	public Grille getGrille() {
        return this.grille;
    }

    public ArrayList<Bateau> getBateaux() {
        return this.grille.getBateaux();
    }

    public boolean isGameOver(){
    	return this.grille.isGameOver();
    }


    private void addBateauxToGrille(){
    	System.out.println("Placement des bateaux");
		for(int taille : this.nb_bateaux) {
    		Bateau b = this.scanner.addBateau(taille);
    		while(!this.grille.canAddBateau(b)) {
    			System.out.println("Impossible de placer le bateau, veuillez réessayer à un autre endroit");
    			b= this.scanner.addBateau(taille);
    		}
			System.out.println("Bâteau placé !");
			this.grille.addBateau(b);
    	}
    	System.out.println(this.grille.toString());
    }
    
    public void attack(Player p2) {
    	if((!p2.isGameOver()) && this.isTurn()) {
    		System.out.println("Your turn "+this.name);
			int[] coord = this.scanner.getCoord();
        	while(p2.isAlreadyUsed(coord)) {
        		coord = this.scanner.getCoord();
			}
			p2.getGrille().attack(coord);
        	if(p2.isTouched(coord)) {
        		this.attack(p2);
			}
			this.turnOff();
    	}
	}
	
	public void attack(Player p2, int[] coord) {
    	if((!p2.isGameOver()) && this.isTurn()) {
    		System.out.println("Your turn "+this.name);
			p2.getGrille().attack(coord);
        	if(!p2.isTouched(coord)) {
				this.turnOff();
				p2.turnOn();
			}
    	}
    }
    
    public boolean isAlreadyUsed(int[] coord) {
    	return this.grille.isAlreadyUsed(coord);
    	
    }
    
    public boolean isTouched(int[] coord) {
    	boolean touched = this.grille.isTouched(coord);
    	this.showGrille();
    	return touched;
    }
    
    public void showGrille() {
    	System.out.println("Grille de "+this.name);
    	System.out.println(this.grille.toStringHidden());
	}
	
	public boolean isTurn(){
		return  this.turn;
	}

	public void turnOn(){
		this.turn = true;
	}

	public void turnOff(){
		this.turn = false;
	}
    
}