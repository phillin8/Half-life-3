import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class JKTNTFrame extends JFrame {

	private JLabel label;
	private JKTNTFrame frame;
	private JKTNTPanel mainScreen;
	private JButton search;
	private JButton clear;
	private JButton login;
	private TextField text;
	private TextField user;
	private TextField pass;
	private btnListener clickListener;

	public static void main(String[] args) {
		new JKTNTFrame();
	}

	public JKTNTFrame() {
		// creates the window
		super("JKTNT Window");

		// Line of code to set the size and location

		this.setSize(new Dimension(500, 500));
		this.setLocationRelativeTo(null); // starts center screen
		this.setLayout(new BorderLayout());
		clickListener = new btnListener();
		// this.setResizable(false);
		// Line of code that says what happens when you click close
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// j.setBounds(500, 300, 800, 800);
		// Call helper methods to set up various sections
		setupTopPanel();
		setupMiddlePanel();
		setupBottomPanel();

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
		// Once the panel is set up, add it to the frame
		this.add(top, BorderLayout.NORTH);

	}

	// Sets up the middle panel where the graphics will go
	private void setupMiddlePanel() {
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
		
		// creates the username and password text fields
		user = new TextField("", 20);
		pass = new TextField("", 20);
		mainScreen.add(user);
		mainScreen.add(pass);

		// creates a Login button with event listener attached
		login = new JButton("Login");
		mainScreen.add(login);
		login.addActionListener(clickListener);

		mainScreen.setVisible(true);
		// This anonymous GraphicsPanel should be replaced with an instance variable
		this.add(mainScreen, BorderLayout.CENTER);
	}

	// Sets up the bottom panel with buttons
	private void setupBottomPanel() {
		JPanel bottom = new JPanel();
		bottom.setLayout(new FlowLayout());
		// Now that the panel is set up, add it to the frame
		this.add(bottom, BorderLayout.SOUTH);
	}

//	private String search() {
//		System.out.println("lol");
//		return "";
//	}

	// button listener for Search, Login, etc.
	public class btnListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

			Object btn = e.getSource();

			if (btn == search) {
				// search for the keyword typed in the textField
				mainScreen.searchGames(text.getText());

			} else if (btn == login) {
				// do nothing yet
				mainScreen.setBackground(new Color(0, 0, 0));
			}

			repaint();
		}

	}

}
