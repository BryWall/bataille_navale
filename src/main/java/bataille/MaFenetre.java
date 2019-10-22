package bataille;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MaFenetre extends JFrame {
	private JButton b1,b2;
	
	public MaFenetre() {
		this.setVisible(true);
		this.setSize(300,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(construisMoiUnPanel());
		
	}
	
	private JPanel construisMoiUnPanel() {
		JPanel panel = new JPanel();
		
		b1= new JButton("Mon bouton 1");
		b2 = new JButton("Mon bouton 2");
		MonListenerBouton listener = new MonListenerBouton(b1,b2);
		b1.addActionListener(listener);
		b2.addActionListener(listener);
		panel.add(b1);
		panel.add(b2);
		
		return panel;
		
		
	}
}
