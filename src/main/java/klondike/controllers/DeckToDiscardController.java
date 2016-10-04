package klondike.controllers;

import klondike.models.Card;
import klondike.models.StackCard;
import klondike.models.StackDeck;
import klondike.utils.IO;
import klondike.views.GameView;

public class DeckToDiscardController {

	private StackDeck deck;
	private StackCard discard;
	private GameView gameView;
	private IO io;

	public DeckToDiscardController(StackCard discard, StackDeck deck, GameView gameView) {
		this.discard = discard;
		this.deck = deck;
		this.gameView = gameView;
		io = new IO();
	}

	public void execute() {
		if (deck.getStackCard().isEmpty()) {
			io.writeln("La baraja está vacía");
		} else {
			Card card = deck.getStackCard().pop();
			card.setHidden(false);
			discard.getStackCard().push(card);
		}
		gameView.imprimirBoard();
	}
}
