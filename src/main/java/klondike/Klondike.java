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
import klondike.models.Game;
import klondike.models.StackCard;
import klondike.models.StackDeck;
import klondike.models.StackLadder;
import klondike.models.Suit;
import klondike.utils.IO;
import klondike.views.GameView;

public class Klondike {

	private Game game;
	boolean ok;
	private GameView gameView;
	private IO io;

	public Klondike() {
		game = new Game();
		gameView = new GameView(game.getDeck(), game.getLadders(), game.getSuitStacks(), game.getDiscard());
		io = new IO();
		init();
		play();
	}

	public void init() {
		gameView.imprimirBoard();
	}

	public void play() {
		do {
			ok = false;
			int opcion = io.readInt("Opcion= [1-9]:");
			if (opcion == 1) {
				new DeckToDiscardController(game.getDiscard(), game.getDeck(), gameView).execute();
			} else if (opcion == 2) {
				new DiscardToDeckController(game.getDiscard(), game.getDeck(), gameView).execute();
			} else if (opcion == 3) {
				new DiscardToSuitController(game.getDiscard(), game.getSuitStacks(), gameView).execute();
			} else if (opcion == 4) {
				new DiscardToLadderController(game.getDiscard(), game.getLadders(), gameView).execute();
			} else if (opcion == 5) {
				new LadderToSuitController(game.getLadders(), game.getSuitStacks(), gameView).execute();
			} else if (opcion == 6) {
				new LadderToLadderController(game.getLadders(), gameView).execute();
			} else if (opcion == 7) {
				new SuitToLadderController(game.getLadders(), game.getSuitStacks(), gameView).execute();
			} else if (opcion == 8) {
				new FlipCardController(game.getLadders(), gameView).execute();
			}
		} while (!ok);
	}

	public static void main(String[] args) {
		new Klondike();
	}
}
