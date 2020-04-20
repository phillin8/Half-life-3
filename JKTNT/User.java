import javax.swing.JOptionPane;

public class User {
	
	private String userName;
	private String userID;
	private String password;
	private String email;
	private int creditCard;


	public User(String userName, String userID, String password, String email) {
		this.userName = userName;
		this.userID = userID;
		this.password = password;
		this.email = email;
	}
	
	public boolean verifyLogin() {
		return false;
	}
	
	public boolean addToLibrary(Game g) {
		return false;
	}
	
	public boolean updateLibrary(Game g, String name, double rating) {
		return false;
	}
	
	public boolean deleteFromLibrary(Game g) {
		return false;
	}
	
	public void viewLibrary() {
	
	}
	
	public boolean purchaseGame(Game g){
		return false;
	}
	
	public boolean updateUserInfo(String id, String pass, String email, int creditCard) {
		
//need to put it in other class
//		if(userID.equals(id) && password.equals(pass) && this.email.equals(email) && this.creditCard == creditCard) {
//			
//			JOptionPane.showMessageDialog("Please enter valid credentials");
//			
//			return false;
//		}
		
		this.userID = id;
		this.password = pass;
		this.email = email;
		this.creditCard = creditCard;
		
		return true;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getUserID() {
		return userID;
	}
	public String getUserEmail() {
		return email;
	}
}
