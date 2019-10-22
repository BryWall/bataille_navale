package bataille;

import java.util.Scanner;

import javax.swing.SwingUtilities;

public class Main {
	public final static Scanner SCANNER = new Scanner(System.in);
	
	
    public static void main(String[] args) {

    	Game game = new Game();
    	game.start();
    	//MonLanceurDeFenetre launcher = new MonLanceurDeFenetre();
    	//SwingUtilities.invokeLater(launcher);
    }
    
}