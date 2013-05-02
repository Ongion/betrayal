package eventCards;

import java.util.Locale;

import Game.Game;

public class Drip extends EventCard {

	private Game game;
	
	public Drip(Locale loc){
		super("Drip", loc);
		this.game = Game.getInstance();
	}
	
	@Override
	public void happen(int rollResult) {
		// TODO Auto-generated method stub

	}

	@Override
	public void happens() {
		// TODO Auto-generated method stub

	}

}
