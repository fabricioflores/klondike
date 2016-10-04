package klondike.models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CardTest {
	private Card card;
	@Before
	public void init(){
		card = new Card(Number.ACE, Suit.BRILLO, true);
	}

	@Test
	public void testConstructor() {
		assertEquals(card.getNumber(), Number.ACE);
		assertEquals(card.getSuit(), Suit.BRILLO);
		assertTrue(card.isHidden());
	}
	
	@Test
	public void testSetHidden() {
		card.setHidden(false);
		assertFalse(card.isHidden());
	}
	
	@Test
	public void testToStringHidden() {
		card.setHidden(true);
		assertTrue(card.toString().equals("[]"));
	}
	
	@Test
	public void testToStringNotHidden() {
		card.setHidden(false);
		assertTrue(card.toString().equals("[ACE BRILLO]"));
	}

}
