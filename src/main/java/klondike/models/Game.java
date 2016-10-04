package klondike.models;

import java.util.ArrayList;
import java.util.Hashtable;

import klondike.controllers.DeckToDiscardController;
import klondike.controllers.DiscardToDeckController;
import klondike.controllers.DiscardToLadderController;
import klondike.controllers.DiscardToSuitController;
import klondike.controllers.FlipCardController;
import klondike.controllers.LadderToLadderController;
import klondike.controllers.LadderToSuitController;
import klondike.controllers.SuitToLadderController;
import klondike.utils.IO;
import klondike.views.GameView;

public class Game {

	private StackDeck deck;
	private ArrayList<StackLadder> ladders;
	private Hashtable<Suit, StackCard> suitStacks;
	private StackCard discard;
	boolean ok;
	private GameView gameView;
	private IO io;

	public Game() {
		deck = new StackDeck();
		deck.shuffle();
		ladders = new ArrayList<StackLadder>();
		suitStacks = new Hashtable<Suit, StackCard>();
		discard = new StackCard();
		gameView = new GameView(deck, ladders, suitStacks, discard);
		io = new IO();

		for (int i = 0; i < Suit.values().length; i++) {
			StackCard suit = new StackCard();
			suitStacks.put(Suit.values()[i], suit);
		}

		for (int i = 1; i <= 7; i++) {
			StackLadder s = new StackLadder();
			s.addCards(i, deck);
			ladders.add(s);
		}

		gameView.imprimirBoard();

		do {
			ok = false;
			int opcion = io.readInt("Opcion= [1-9]:");
			if (opcion == 1) {
				new DeckToDiscardController(discard, deck, gameView).execute();
			} else if (opcion == 2) {
				new DiscardToDeckController(discard, deck, gameView).execute();
			} else if (opcion == 3) {
				new DiscardToSuitController(discard, suitStacks, gameView).execute();
			} else if (opcion == 4) {
				new DiscardToLadderController(discard, ladders, gameView).execute();
			} else if (opcion == 5) {
				new LadderToSuitController(ladders, suitStacks, gameView).execute();
			} else if (opcion == 6) {
				new LadderToLadderController(ladders, gameView).execute();
			} else if (opcion == 7) {
				new SuitToLadderController(ladders, suitStacks,gameView).execute();
			} else if (opcion == 8) {
				new FlipCardController(ladders, gameView).execute();
			}
		} while (!ok);
	}

	public static void main(String[] args) {
		new Game();
	}

}