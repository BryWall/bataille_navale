package bataille.scanner;

import java.util.Scanner;

import bataille.Bateau;
import bataille.Grille;

public class MyScanner {
	public final Scanner SCANNER = new Scanner(System.in);
	private Grille grille;
	
	public MyScanner(Grille g) {
		this.grille = g;
	}
	
	public Bateau addBateau(int taille) {
		System.out.println(grille.toString());
		System.out.println("Veuillez placer un bateau de taille "+ taille + " :");
		System.out.println("Orientation (Horizontale (H) ou Verticale (V))");
		String orientation = SCANNER.nextLine();
		while((!orientation.equals("H")) && (!orientation.equals("V"))) {
			System.out.println("Veuillez saisir H ou V");
			orientation = SCANNER.nextLine();
		}
		int[] coord = this.getCoord();
		return new Bateau(taille,coord[0],coord[1],orientation);
	}
	
	public int[] getCoord() {
		int dim = this.grille.getDimension();
		System.out.println("X (0 -> "+(dim-1)+")");
		int x = Integer.parseInt(SCANNER.nextLine());
		while(x<0 && x>(dim-1)) {
			System.out.println("Entre 0 et "+(dim-1));
			x = Integer.parseInt(SCANNER.nextLine());
		}
		System.out.println("Y (0 -> "+(dim-1)+")");
		int y = Integer.parseInt(SCANNER.nextLine());
		while(y<0 && y>(dim-1)) {
			System.out.println("Entre 0 et "+(dim-1));
			y = Integer.parseInt(SCANNER.nextLine());
		}
		return new int[] {x,y};
	}
	
}