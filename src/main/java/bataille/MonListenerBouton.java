package bataille;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class MonListenerBouton implements ActionListener{
	private JButton b1,b2;
	
	public MonListenerBouton(JButton b1, JButton b2) {
		this.b1 = b1;
		this.b2 = b2;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == b1) {
			System.out.println("Bouton 1");
		}
		else if(source == b2) {
			System.out.println("Bouton 2");
		}
	}

}
