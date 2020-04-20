import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test
	public void testUser() {
		User a = new User("adam", "00001", "123123", "adam.xmail.com");
		assertFalse(a == null);
		assertEquals("adam", a.getUserName());
		assertEquals("adam.xmail.com", a.getUserEmail());
	}
	
	
	@Test
	public void testUpdateUserInfo() {
		User a = new User("adam", "00001", "123123", "adam.xmail.com");
		assertEquals("adam", a.getUserName());
		assertEquals("adam.xmail.com", a.getUserEmail());
		
		a.updateUserInfo("1234", "123123", "adam.gmail.com", 1234567890);
		

		
	}
	@Test
	public void testGetUserName() {
		User a = new User("adam", "00001", "123123", "adam.xmail.com");
		assertEquals("adam", a.getUserName());
	}
	@Test
	public void testGetUserID() {
		User a = new User("adam", "00001", "123123", "adam.xmail.com");
		assertEquals("00001", a.getUserID());

	}
	@Test
	public void testGetUserEmail() {
		User a = new User("adam", "00001", "123123", "adam.xmail.com");
		assertEquals("adam.xmail.com", a.getUserEmail());

	}
	
	
	@Test
	public void testVerifyLogin() {
		
	}

	@Test
	public void testAddToLibrary() {
		
	}

	@Test
	public void testUpdateLibrary() {
		
	}

	@Test
	public void testDeleteFromLibrary() {
		
	}

	@Test
	public void testViewLibrary() {
		
	}

	@Test
	public void testPurchaseGame() {
		
	}

	

}
