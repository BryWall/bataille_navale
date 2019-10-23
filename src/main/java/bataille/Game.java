package bataille;
import java.util.Scanner;


public class Game {
	public final static Scanner SCANNER = new Scanner(System.in);
	private Player p2;
	private Player p1;

	public Game() {
    	int[] list = new int[] {3,4};	
    	int taille = 10;
    	System.out.println("Nom joueur 1 :");
    	String p1_name = SCANNER.nextLine();
    	this.p1 = new Player(p1_name, taille, list);
    	System.out.println("Nom joueur 2 :");
    	String p2_name = SCANNER.nextLine();
    	this.p2 = new Player(p2_name, taille, list);
	}

	public boolean isGameOver() {
		return (this.p1.isGameOver() || this.p2.isGameOver());
	}
	
	public void start() {
		while(!isGameOver()) {
			p2.showGrille();
			System.out.println(p1.getName()+" -> "+p2.getName());
			p1.attack(p2);
			if(!isGameOver()) {
				p1.showGrille();
				p2.attack(p1);
			}
		}
		this.showWinner();
	}

	private void showWinner() {
		if(this.p1.isGameOver())
			System.out.println(p2.getName()+ " won !");
		else
			System.out.println(p1.getName()+ " won !");
		
	}
	
	
}
