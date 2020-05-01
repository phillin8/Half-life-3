import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.print.DocFlavor.URL;
import javax.swing.*;

import java.util.ArrayList;
import java.util.HashMap;

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
	private String description;
	private String organization;
	private String storeLink;
	private String[] platforms;
	private double price;
	private JTextArea gamePage;
	private JTextArea commPanel;
	private String commentFile;
	private TextField commArea;

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
	public Game(String name, String path, double price, String cFile, String description) {
		super();
		this.name = name;
		this.price = price;
		this.description = description;
		this.commentFile = cFile;
		this.setPreferredSize(new Dimension(250,320));
		this.setLayout(new BorderLayout());
		
		btn = new JButton(name + "      $" + price);
		btn.setPreferredSize(new Dimension(250, 20));
		
		image = new ImageIcon(path).getImage();
		//Image newImg = image.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
	    //btn.setIcon(new ImageIcon(image));
		this.add(btn,BorderLayout.SOUTH);
		createGamePanel(description);
	}
	
	private void createGamePanel(String desc) {
	    JTextArea comments = new JTextArea();
	    comments.setSize(500, 500);
	    ArrayList<Comment> commentsList = readComments();
	    String dummy = "";
	    for (int i = 0; i < commentsList.size(); i++) {
	        dummy += commentsList.get(i).getUser() + ": " 
	                         + commentsList.get(i).getComment() + "\n Rating: "
	                         + commentsList.get(i).getRating() + "\n";
	    }
	    comments.setText("Comments:\n\n" + dummy);
	    comments.setFont(new Font("TimesRoman", Font.PLAIN, 18));
        comments.setEditable(false);
        comments.setLineWrap(true);
        comments.setWrapStyleWord(true);
	    JTextArea description = new JTextArea();
        description.setSize(500, 500);
        // temporary text for 1 game
        description.setText("Game Description:\n\n" + desc);
        description.setFont(new Font("TimesRoman", Font.PLAIN, 18));
        description.setEditable(false);
        description.setLineWrap(true);
        description.setWrapStyleWord(true);
        this.gamePage = description;
        this.commPanel = comments;
        
	}
	
	private ArrayList<Comment> readComments() {
	    ArrayList<Comment> comments = new ArrayList<Comment>(0);
        try {
            BufferedReader read = new BufferedReader(new FileReader(".\\comments\\" + commentFile));
            String dummy;
            for (int i = 0; (dummy = read.readLine()) != null; i++) {
                String[] commentInfo = dummy.split("\t");
                comments.add(new Comment(commentInfo[0], commentInfo[1], Integer.parseInt(commentInfo[2])));
            }
            read.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return comments;
	}
	
	public JTextArea getCommPanel() {
	    return commPanel;
	}
	
	public JTextArea getGamePanel() {
	    return gamePage;
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

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the organization
     */
    public String getOrganization() {
        return organization;
    }

    /**
     * @param organization the organization to set
     */
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    /**
     * @return the storeLink
     */
    public String getStoreLink() {
        return storeLink;
    }

    /**
     * @param storeLink the storeLink to set
     */
    public void setStoreLink(String storeLink) {
        this.storeLink = storeLink;
    }

    /**
     * @return the platforms
     */
    public String[] getPlatforms() {
        return platforms;
    }

    /**
     * @param platforms the platforms to set
     */
    public void setPlatforms(String[] platforms) {
        this.platforms = platforms;
    }
}
