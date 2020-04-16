import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class JKTNTPanel extends JPanel {
	
	/**
	 * 
	 */
	public JKTNTPanel() {
		super();
		this.setBackground(Color.GRAY);
		this.setPreferredSize(new Dimension(500, 500));
	}

	public void displayGames() {
		
		System.out.println("lol");
	};
	
	public void searchGames(String name) {
		
		//this.add(new TextField("Label"));
		if(name.equals("asd")) {
			System.out.println("found");
			this.setBackground(new Color(255,0,0));
		}
		System.out.println("lol");
	};
}
