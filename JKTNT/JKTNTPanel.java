import java.awt.Color;
import java.awt.Dimension;
import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class JKTNTPanel extends JPanel {
        // comment
	/**
	 * 
	 */
	public JKTNTPanel() {
		super();
		this.setBackground(Color.GRAY);
		this.setPreferredSize(new Dimension(1000, 800));
	}

	public void displayGames() {
		this.setBackground(new Color(255,0,0));

		this.revalidate();
		
		System.out.println("lol");
	};
}
