package eventCards;

import java.util.Locale;

import Game.Game;

public class Whoops extends EventCard {

	private Game game;
	
	public Whoops(Locale loc){
		super("Whoops", loc);
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
