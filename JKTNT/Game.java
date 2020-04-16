import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.print.DocFlavor.URL;
import javax.swing.*;

/*
 * This is how we draw graphics on an object.
 * We want to draw things on a JButton, so:
 * 1. Extend JButton
 * 2. Override paintComponent 
 * 3. Draw our graphics in the paintComponent method
 */

public class Game extends JPanel {
	private Image image;
	private JButton btn;
	private String name;
	private double price;
	

	/**
	 * Creates a Game object as a panel, for users in the future
	 * @param name Name of the game, for display and other use
	 * @param path Path to the picture of the game
	 */
	public Game(String name, String path) {
		super();
		this.name = name;
		this.setPreferredSize(new Dimension(250,320));
		this.setLayout(new BorderLayout());
		
		btn = new JButton(name + "      add price here");
		btn.setPreferredSize(new Dimension(250, 20));
		
		image = new ImageIcon(path).getImage();
		//Image newImg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	    //btn.setIcon(new ImageIcon(image));
		this.add(btn,BorderLayout.SOUTH);
	}
	
	/**
	 * Creates a Game object as a panel
	 * @param name Name of the game, for display and other use
	 * @param path Path to the picture of the game
	 * @param price Price of the game, the administrator can add price
	 */
	public Game(String name, String path, double price) {
		super();
		this.name = name;
		this.price = price;
		this.setPreferredSize(new Dimension(250,320));
		this.setLayout(new BorderLayout());
		
		btn = new JButton(name + "      $" + price);
		btn.setPreferredSize(new Dimension(250, 20));
		
		image = new ImageIcon(path).getImage();
		//Image newImg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	    //btn.setIcon(new ImageIcon(image));
		this.add(btn,BorderLayout.SOUTH);
	}
	
	
	
	@Override // This method already exists in JButton
	public void paintComponent(Graphics g) {
	    super.paintComponent(g); //Tells the JButton to do its own drawing

		// Starting here, draw our graphics
		// All graphics get drawn by starting with g.
		g.drawImage(image, 0, 0, 250,300, this);
		
		
	}
	
	
	public JButton getButton() {
		return btn;
	}
	public String getName() {
		return name;
	}
	public double getPrice() {
		return price;
	}
}
