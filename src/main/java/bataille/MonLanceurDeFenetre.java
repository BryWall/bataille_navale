package bataille;

public class MonLanceurDeFenetre implements Runnable{
	protected Player player;
	protected Game game;
	protected MaFenetre fenetre;
	public MonLanceurDeFenetre(Player p, Game game){
		this.player = p;
		this.game = game;
	}
	@Override
	public void run() {
		this.fenetre = new MaFenetre(this.player, this.game);
		
	}

	public void open() {
		this.fenetre.setVisible(true);
	}
	
}
