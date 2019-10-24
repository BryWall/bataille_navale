package bataille;

import java.util.Scanner;

import javax.swing.SwingUtilities;


public class Game {
	public final static Scanner SCANNER = new Scanner(System.in);
	private Player p2;
	private Player p1;
	private MonLanceurDeFenetre launcherP1;
	private MonLanceurDeFenetre launcherP2;

	public Game() {
    	int[] list = new int[] {5,4,3,2};	
    	int taille = 10;
    	System.out.println("Nom joueur 1 :");
    	String p1_name = SCANNER.nextLine();
    	this.p1 = new Player(p1_name, taille, list);
    	System.out.println("Nom joueur 2 :");
    	String p2_name = SCANNER.nextLine();
		this.p2 = new Player(p2_name, taille, list);
		this.launcherP1 = new MonLanceurDeFenetre(this.p1,this);
		SwingUtilities.invokeLater(launcherP1);
		this.launcherP2 = new MonLanceurDeFenetre(this.p2,this);
    	SwingUtilities.invokeLater(launcherP2);
	}

	public boolean isGameOver() {
		return (this.p1.isGameOver() || this.p2.isGameOver());
	}
	
	public void start() {
		this.p1.turnOn();
	}

	private void showWinner() {
		if(this.p1.isGameOver()){
			System.out.println(p2.getName()+ " won !");
		}
			
		else{
			System.out.println(p2.getName()+ " won !");
		}
			
		
	}
	
	public Player getP1(){
		return this.p1;
	}

	public Player getP2(){
		return this.p2;
	}
	
	public void changeFenetre(Player p){
		if(p.equals(p1)){
			this.launcherP2.open();
		}
		else{
			this.launcherP1.open();
		}
	}
}
