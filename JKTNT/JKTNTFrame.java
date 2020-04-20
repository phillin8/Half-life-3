import java.awt.*;

import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 

@SuppressWarnings("serial")
public class JKTNTFrame extends JFrame {

	private JLabel label;
	private JKTNTPanel mainScreen;
	private JKTNTPanel gamePanel;
	private JButton search;
	private JButton clear;
	private JButton loginCheck;
	private JButton loginSet;
	private JButton registerSet;
	private JButton registerCheck;
	private JButton back;
	private JButton menuBack;
	private TextField text;
	private TextField userR;
	private TextField passR;
	private TextField user;
	private TextField pass;
	private btnListener clickListener;
	private Game[] g;

	public static void main(String[] args) throws InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException, ClassNotFoundException {
		// gets the sleek look
		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(info.getName())) {
				UIManager.setLookAndFeel(info.getClassName());
				break;
			}
		}
		new JKTNTFrame();

	}

	public JKTNTFrame() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		// creates the window
		super("Welcome to JKTNT");
		// Line of code to set the size and location

		this.setSize(new Dimension(800, 800));
		this.setLocationRelativeTo(null); // starts center screen
		this.setLayout(new BorderLayout());
		clickListener = new btnListener();
		// this.setResizable(false);
		// Line of code that says what happens when you click close
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// j.setBounds(500, 300, 800, 800);
		// Call helper methods to set up various sections
		setupTopPanel();
		setupBottomPanel();
		setupGames();

//		this.setLocationRelativeTo(null); // starts center screen
//		this.setLayout(new GridLayout(10, 10));
//		this.setVisible(true);
//		this.setResizable(false);
		this.pack();
		this.setVisible(true);
	}

	// Sets up the top panel where some graphics-related buttons
	// will go.
	private void setupTopPanel() {
		JPanel top = new JPanel();
		top.setLayout(new FlowLayout());
		// MyButtonListener buttonListener = new MyButtonListener();

		label = new JLabel("Welcome to JKTNT!");

		// top.add(login);
		// loadData.addActionListener(buttonListener);
		// saveData.addActionListener(buttonListener);
		// clear.addActionListener(buttonListener);

		// These anonymous JButtons should be replaced with instance variables
		top.add(label);
		top.setVisible(true);
		
		mainScreen = new JKTNTPanel();
		mainScreen.setLayout(new FlowLayout());

		// creates a empty 20px wide textField
		text = new TextField("", 20);
		mainScreen.add(text);

		// creates a Search button with event listener attached
		search = new JButton("Search");
		mainScreen.add(search);
		search.addActionListener(clickListener);

		// creates a button to clear the search bar
		clear = new JButton("Clear");
		mainScreen.add(clear);
		clear.addActionListener(clickListener);
		
	    // creates a Login button with event listener attached
        loginSet = new JButton("Login");
        mainScreen.add(loginSet);
        loginSet.addActionListener(clickListener);
		
		// Create a register button with event listener
		registerSet = new JButton("register");
		mainScreen.add(registerSet);
		registerSet.addActionListener(clickListener);

		mainScreen.setVisible(true);
		
		this.add(mainScreen, BorderLayout.NORTH);
		// Once the panel is set up, add it to the frame
		//this.add(top, BorderLayout.NORTH);

	}



	private void setupGames() {
		// set up a panel inside the mainScreen panel to display games
		gamePanel = new JKTNTPanel();
		// JScrollPane scrollFrame = new JScrollPane(gamePanel);
		gamePanel.setPreferredSize(new Dimension(400, 1500));
		// scrollFrame.setPreferredSize(mainScreen.getMaximumSize());

		JScrollPane scroll = new JScrollPane(gamePanel);
		scroll.getVerticalScrollBar().setPreferredSize(new Dimension(15, 0));
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		//scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll.setLayout(new ScrollPaneLayout());
		scroll.setPreferredSize(new Dimension(800, 500));

		
		
		gamePanel.setLayout(new FlowLayout());
		// mainScreen.setPreferredSize(mainScreen.getPreferredSize());
		gamePanel.setVisible(true);
		this.add(scroll, BorderLayout.CENTER);
		// mainScreen.add(gamePanel);
		
		
		g = new Game[10];

//		for(int i = 4; i < g.length; i++) {
//			g[i] = new Game("Dead Island","deadIsland.png",19.99);
//			g[i].getButton().addActionListener(clickListener);
//			gamePanel.add(g[i]);
//		}
		g[0] = new Game("Dead Island", "deadIsland.png", 19.99);
		g[0].getButton().addActionListener(clickListener);
		g[1] = new Game("Xcom2", "xcom2.png", 29.99);
		g[1].getButton().addActionListener(clickListener);
		g[2] = new Game("Tomb Rider", "tombRaider.jpg", 19.99);
		g[2].getButton().addActionListener(clickListener);
		g[3] = new Game("Dead Island", "deadIsland.png", 19.99);
		g[3].getButton().addActionListener(clickListener);
		gamePanel.add(g[0]);
		gamePanel.add(g[1]);
		gamePanel.add(g[2]);
		// gamePanel.add(g[3]);

		gamePanel.revalidate();
		gamePanel.repaint();
	}

	// testing for changing panels
	private void displayDetailedPage(Game g) {
		gamePanel.removeAll();
		gamePanel.add(g);

		// display a description of the game
		JTextArea description = new JTextArea();
		description.setSize(500, 500);
		// temporary text for 1 game
		description.setText(
				"XCOM 2 is a 2016 turn-based tactics video game that was developed by Firaxis Games and published by 2K Games. It is the sequel to 2012's reboot of the series XCOM: Enemy Unknown; it takes place 20 years after the events of Enemy Unknown. XCOM, a military organization trying to fight off an alien invasion, has lost the war and is now a resistance force against the occupation of Earth and the established totalitarian regime and military dictatorship. Gameplay is split between turn-based combat in which players command a squad of soldiers to fight enemies and strategy elements. Players manage and control the operations of the Avenger, a derelict alien ship that is a mobile base for XCOM, commanding the engineering and research department of the base between missions. ");
		description.setFont(new Font("TimesRoman", Font.PLAIN, 18));

		description.setEditable(false);
		description.setLineWrap(true);
		description.setWrapStyleWord(true);

		// make the text area scrollable
		JScrollPane scroll = new JScrollPane(description);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scroll.setPreferredSize(new Dimension(500, 500));

		gamePanel.add(scroll);

		// create a back button to go back to home page
		back = new JButton("Back");
		gamePanel.add(back);
		back.addActionListener(clickListener);

		gamePanel.revalidate();
		gamePanel.repaint();

	}
	
	private void registerUser() {
	    mainScreen.removeAll();
	    
	    JLabel uname = new JLabel("Enter Username");
	    JLabel pwd = new JLabel("Enter Password");
	    userR = new TextField("", 20);
	    passR = new TextField("", 20);
	    mainScreen.add(uname);
	    mainScreen.add(userR);
	    mainScreen.add(pwd);
	    mainScreen.add(passR);
	    
	    registerCheck = new JButton("Register");
	    mainScreen.add(registerCheck);
	    registerCheck.addActionListener(clickListener);
	    
	    menuBack = new JButton("Back");
	    menuBack.addActionListener(clickListener);
	    mainScreen.add(menuBack);
	    mainScreen.setVisible(true);
	    
	    mainScreen.revalidate();
		mainScreen.repaint();
	}
	
	private void verifyRegister(String userN, String passW) {
	    try {
	        if (userN.isEmpty() || passW.isEmpty()) {
	            JOptionPane.showMessageDialog(mainScreen, "Please enter in valid user/pass!");
	        } else {
    	        File users = new File("userlogin.csv");
    	        // FileWriter write = new FileWriter(users);
    	        Scanner read = new Scanner(users);
    	        boolean goodReg = true;
    	        while (read.hasNextLine()) {
                    String data = read.nextLine();
                    int pos = data.indexOf(",");
                    String user = data.substring(0, pos);
                    if (user.equals(userN)) {
                        JOptionPane.showMessageDialog(mainScreen, "Username already exists!");
                        goodReg = false;
                        break;
                    }
    	        }
    	        read.close();
    	        if (goodReg) {
    	            FileWriter write = new FileWriter(users);
    	            write.append(userN + "," + passW);
    	            JOptionPane.showMessageDialog(mainScreen, "User has been registered!");
    	            write.close();
    	        }
	        }
	    } catch (IOException e){
	        System.out.println("File not found!");
	        e.printStackTrace();
	    }
	}
	/*
	 * This method simply displays the login screen and allows the user 
	 * to login to their account.
	 * 
	 * Needs to handle the case where user enters in a too long pass or user name
	 */
	private void login() {
		mainScreen.removeAll();
        user = new TextField("", 20);
        pass = new TextField("", 20);
		// creates the username and password text fields
		JLabel uname = new JLabel("Username");
		JLabel psw = new JLabel("Password");
		mainScreen.add(uname);
		mainScreen.add(user);
		mainScreen.add(psw);
		mainScreen.add(pass);

		// creates a Login button with event listener attached
		loginCheck = new JButton("Login");
		mainScreen.add(loginCheck);
		loginCheck.addActionListener(clickListener);

		menuBack = new JButton("Back");
		menuBack.addActionListener(clickListener);
		mainScreen.add(menuBack);
		mainScreen.setVisible(true);
		// this.add(mainScreen, BorderLayout.CENTER);
		mainScreen.revalidate();
		mainScreen.repaint();
		// Use a document listener to make the screen display the username
		// When you log in
//		String username = user.getText();
//		usernameText = new JLabel(username);
//		System.out.println("This is the output" + username);
//	//	usernameText.setText(username);
//		mainScreen.add(usernameText);
		// This is for when we include the dB
		// String sql="SELECT userName FROM employees WHERE UserName=? and Password=?";
	}
	
	/*
	 * Attempts to login the user by referencing the csv file containing
	 * user login information. If good the console prints successful login,
	 * else it will notify the user of a bad login.
	 * 
	 * @param userN - The user name read in from the text field
	 * 
	 * @param passW - The password read in from the text field
	 */
    private void verifyLogin(String userN, String passW) {
        try {
            File users = new File("userlogin.csv");
            Scanner reader = new Scanner(users);
            boolean goodLogin = false;
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                int pos = data.indexOf(",");
                String user = data.substring(0, pos);
                String pass = data.substring(pos + 1, data.length());
                if (!user.isEmpty() && !pass.isEmpty() && user.equals(userN) && pass.equals(passW)) {
                    JOptionPane.showMessageDialog(mainScreen, "Login Successful!");
                    goodLogin = true;
                    break;
                }
            }
            reader.close();
            if (!goodLogin) {
                JOptionPane.showMessageDialog(mainScreen, "Login failed!");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Cannot find file!");
            e.printStackTrace();
        }
        
    }

	// goes back to the main game library page, with preloaded games
	private void back() {
		gamePanel.removeAll();

		// Temporary games showing on the main page
		gamePanel.add(g[0]);
		gamePanel.add(g[1]);
		gamePanel.add(g[2]);
		// gamePanel.add(g[3]);
		// redraw the panel
		gamePanel.revalidate();
		gamePanel.repaint();
	}

	private void menuBack() {
		mainScreen.removeAll();

		// creates a empty 20px wide textField
		mainScreen.add(text);
		// creates a Search button with event listener attached
		mainScreen.add(search);
		// creates a button to clear the search bar
		mainScreen.add(clear);
		// creates a Login button with event listener attached
		mainScreen.add(loginSet);
		
		mainScreen.add(registerSet);
		mainScreen.revalidate();
		mainScreen.repaint();
	}

	// Sets up the bottom panel with buttons
	private void setupBottomPanel() {
		JPanel bottom = new JPanel();
		bottom.setLayout(new FlowLayout());

		// load the images
		// add the game to the display

		// Now that the panel is set up, add it to the frame
		this.add(bottom, BorderLayout.SOUTH);
	}


	// button listener for Search, Login, etc.
	public class btnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			Object btn = e.getSource();

			if (btn == search) {
				// do nothing yet, need diagram
				// search for the keyword typed in the textField
				mainScreen.searchGames(text.getText());

			} else if (btn == registerSet) {
			    registerUser();
			} else if (btn == registerCheck) {
			    verifyRegister(userR.getText(), passR.getText());
			} else if (btn == loginSet) {
				login();
			//\\ if (user.getText().toString() != null && pass.getText().toString() != null 
			//	) {	//&& user.getText().trim().length() > 0 && pass.getText().trim().length() > 0) {

		    } else if (btn == clear) {
				// do nothing yet, need diagram
				mainScreen.setBackground(new Color(255, 255, 255));
			} else if (btn == menuBack) {
				menuBack();
			} else if (btn == back) {
				back();
			} else if (btn == loginCheck) {
			    verifyLogin(user.getText(), pass.getText());
			} else {
				// for all the other buttons that are beleng to games
				// gamePanel.setBackground(new Color((int)(Math.random()*255), 155, 0));

				// react based on the game clicked
				for (int i = 0; i < g.length; i++) {
					if (g[i] == null) {
						break;
					}
					if (btn.equals(g[i].getButton())) {
						displayDetailedPage(g[i]);
					}
				}

				// trying to get to a new page

			}
		}

	}

}