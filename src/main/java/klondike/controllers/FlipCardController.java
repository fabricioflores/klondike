package klondike.controllers;

import java.util.ArrayList;

import klondike.models.Card;
import klondike.models.StackLadder;
import klondike.utils.IO;
import klondike.views.GameView;

public class FlipCardController {
	
	private ArrayList<StackLadder> ladders;
	private GameView gameView;
	private IO io;
	
	public FlipCardController(ArrayList<StackLadder> ladders, GameView gameView){
		this.ladders = ladders;
		this.gameView = gameView;
		io = new IO();
	}
	
	public void execute(){
		int ladderPosition = io.readInt("En que Escalera? [1-7]:");
		Card card = ladders.get(ladderPosition - 1).getStackCard().lastElement();
		if(card.isHidden()){
			card.setHidden(false);
		}else{
			io.writeln("Carta ya está volteada");
		}
		gameView.imprimirBoard();
	}

}
