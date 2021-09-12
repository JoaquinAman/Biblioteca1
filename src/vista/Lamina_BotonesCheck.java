package vista;

import javax.swing.*;

public class Lamina_BotonesCheck extends JPanel{
	
	public  Lamina_BotonesCheck(String titulo) {

		setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), titulo));
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		bot = new JCheckBox();
		
		add(bot);
	}
	
	private JCheckBox bot; 

	public JCheckBox getBot() {
		return bot;
	}

	public void setBot(JCheckBox bot) {
		this.bot = bot;
	}
}
