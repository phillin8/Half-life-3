import static org.junit.Assert.*;

import org.junit.Test;

public class GameTester {

	@Test
	public void testGameStringString() {
		Game test = new Game("2k20","/");
		assertEquals("2k20", test.getName());
	}
	
	public void testGameStringStringDouble() {
		Game test = new Game("2k20", "/", 19.99);
		assertEquals("2k20", test.getName());
		assertEquals(19.99, test.getPrice(), 0.001);
	}
	
	public void testGetName() {
		Game test = new Game("The Simpsons", "/");
		assertEquals("The Simpsons", test.getName());
	}
	
	public void testGetPrice() {
		Game test = new Game("test", "/", 19.99);
		assertEquals(19.99, test.getPrice(), 0.001);
	}
}
