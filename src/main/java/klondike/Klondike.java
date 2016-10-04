package klondike;

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
import klondike.models.StackCard;
import klondike.models.StackDeck;
import klondike.models.StackLadder;
import klondike.models.Suit;
import klondike.utils.IO;
import klondike.views.GameView;

public class Klondike {

	private StackDeck deck;
	private ArrayList<StackLadder> ladders;
	private Hashtable<Suit, StackCard> suitStacks;
	private StackCard discard;
	boolean ok;
	private GameView gameView;
	private IO io;

	private static final int LADDERS_COUNT = 7;

	public Klondike() {
		deck = new StackDeck();
		deck.shuffle();
		ladders = new ArrayList<StackLadder>();
		suitStacks = new Hashtable<Suit, StackCard>();
		discard = new StackCard();
		gameView = new GameView(deck, ladders, suitStacks, discard);
		io = new IO();
		init();
		play();
	}

	public void init() {
		for (int i = 0; i < Suit.values().length; i++) {
			StackCard suit = new StackCard();
			suitStacks.put(Suit.values()[i], suit);
		}
		for (int i = 1; i <= LADDERS_COUNT; i++) {
			StackLadder stackLadder = new StackLadder();
			stackLadder.addCards(i, deck);
			ladders.add(stackLadder);
		}
		gameView.imprimirBoard();
	}

	public void play() {
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
				new SuitToLadderController(ladders, suitStacks, gameView).execute();
			} else if (opcion == 8) {
				new FlipCardController(ladders, gameView).execute();
			}
		} while (!ok);
	}

	public static void main(String[] args) {
		new Klondike();
	}
}
