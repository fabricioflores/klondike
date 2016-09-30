package klondike.models;

public class Card{
	private Suit suit;
	private Number number;
	
	public Card (Number number, Suit suit){
		this.number = number;
		this.suit = suit;
	}
}