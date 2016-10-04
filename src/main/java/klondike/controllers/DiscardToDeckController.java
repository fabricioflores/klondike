package klondike.controllers;

import klondike.models.StackCard;
import klondike.models.StackDeck;
import klondike.utils.IO;
import klondike.views.GameView;

public class DiscardToDeckController {

	private StackDeck deck;
	private StackCard discard;
	private GameView gameView;
	private IO io;

	public DiscardToDeckController(StackCard discard, StackDeck deck, GameView gameView) {
		this.discard = discard;
		this.deck = deck;
		this.gameView = gameView;
		io = new IO();
	}

	public void execute() {
		if (discard.getStackCard().isEmpty()) {
			io.writeln("El descarte está vacío");
		} else {
			while (discard.getStackCard().size() != 0) {
				deck.getStackCard().push(discard.getStackCard().pop());
			}
		}
		gameView.imprimirBoard();
	}
}
