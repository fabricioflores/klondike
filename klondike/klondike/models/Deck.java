package klondike.models;

import java.util.ArrayList;

public class Deck {
	
	private ArrayList<Card> deck;
	
	public Deck (){
		this.deck = new ArrayList<Card>();
	    for (int i=0; i<13; i++){
	      Number value = Number.values()[i];
	      for (int j=0; j<4; j++){
	        Card card = new Card(value, Suit.values()[j]);
	        this.deck.add(card);
	      }
	    }
	}

}
