package bataille;

public class MonLanceurDeFenetre implements Runnable{
	protected Player player;
	protected Game game;
	public MonLanceurDeFenetre(Player p, Game game){
		this.player = p;
		this.game = game;
	}
	@Override
	public void run() {
		MaFenetre fenetre = new MaFenetre(this.player, this.game);
	}
	
}
