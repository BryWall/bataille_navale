package bataille;

import java.awt.Button;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MaFenetre extends JFrame {
	private JButton b1,b2;
	private Player player;
	private ArrayList<JButton> buttons;
	private Game game;

	public MaFenetre(Player p, Game game) {
		this.game = game;
		this.buttons = new ArrayList<>();
		this.player= p;
		this.setVisible(true);
		this.setSize(500,500);
		this.setTitle("Player's name: " + p.getName());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(construisMoiUnPanel());
		
	}
	
	private JPanel construisMoiUnPanel() {
		JPanel panel = new JPanel();
		MonListenerBouton listener = new MonListenerBouton(this.buttons, this.game, this.player,this);
		int dim = this.player.getGrille().getDimension();
		GridLayout grid = new GridLayout(dim,dim);
		panel.setLayout(grid);
		;
		for(int i = 0 ; i< dim ; i++){
			for(int j = 0 ; j<dim ; j++){
				String str = this.player.getGrille().getCell(j, i).toString().trim();
				JButton b = new JButton();
				if(str.equals("0")){
					b.setBackground(Color.GRAY);
				}
				if(str.equals("1")){
					b.setBackground(Color.GRAY);
				}
				b.setOpaque(true);
				this.buttons.add(b);
				panel.add(b);
				b.addActionListener(listener);
			}
		}
		return panel;
		
		
	}
}
