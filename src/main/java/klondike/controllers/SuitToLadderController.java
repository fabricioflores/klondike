package klondike.controllers;

import java.util.ArrayList;
import java.util.Hashtable;

import klondike.models.Card;
import klondike.models.StackCard;
import klondike.models.StackLadder;
import klondike.models.Suit;
import klondike.utils.IO;

public class SuitToLadderController {

	private ArrayList<StackLadder> ladders;
	private Hashtable<Suit, StackCard> suitStacks;
	private IO io;

	public SuitToLadderController(ArrayList<StackLadder> ladders, Hashtable<Suit, StackCard> suitStacks) {

		this.ladders = ladders;
		this.suitStacks = suitStacks;
		io = new IO();
	}

	public void execute() {
		int fromSuit = io.readInt("De que Palo? [1-4]:");
		int toLadder = io.readInt("A que Escalera? [1-7]:");
		Suit suitStack = Suit.values()[fromSuit - 1];
		StackCard suit = suitStacks.get(suitStack);
		if (suit.getStackCard().isEmpty()) {
			io.writeln("El Palo esta vacio");
		} else {
			Card card = suit.getStackCard().pop();
			ladders.get(toLadder - 1).getStackCard().push(card);
		}
	}
}