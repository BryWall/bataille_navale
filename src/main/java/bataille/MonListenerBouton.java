package bataille;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.JButton;

public class MonListenerBouton implements ActionListener {
	private ArrayList<JButton> buttons;
	private Game game;
	private Player player;

	public MonListenerBouton(ArrayList<JButton> b, Game game, Player p) {
		this.buttons = b;
		this.game = game;
		this.player = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(this.player.getName() +" "+ this.player.isTurn());
		Object source = e.getSource();
		System.out.println("Index : " + this.buttons.indexOf(source));
		Player me = this.player;
		Player enemy = (this.game.getP1() == me) ? this.game.getP2() : this.game.getP1();
		int x = this.buttons.indexOf(source) % 10;
		int y = this.buttons.indexOf(source) / 10;
		System.out.println("x : " + x);
		System.out.println("y : " + y);
		System.out.println("name : " + me.getName());
		Cell cell = me.getGrille().getCell(x, y);
		int [] coord = new int[] {x,y};
		enemy.attack(me, coord);
		if(cell.toString().trim().equals("2")){
			((AbstractButton) source).setBackground(Color.RED);
		}
		if(cell.toString().trim().equals("3")){
			((AbstractButton) source).setBackground(Color.GRAY);
		}
		((AbstractButton) source).setText(cell.toString());
		
		
		
	}

}
