package klondike.models;

import java.util.Collections;

public class StackDeck extends StackCard {
	
	public static final int NUMBER_LIMIT = 13;

	public StackDeck() {
		super();
		for (int i = 0; i < NUMBER_LIMIT; i++) {
			Number value = Number.values()[i];
			for (int j = 0; j < 4; j++) {
				Card card = new Card(value, Suit.values()[j], true);
				this.getStackCard().push(card);
			}
		}
	}

	public void shuffle() {
		Collections.shuffle(this.getStackCard());
	}

}
