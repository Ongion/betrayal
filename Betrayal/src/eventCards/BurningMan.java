package eventCards;

import Game.Game;

public class BurningMan extends EventCard {

	private Game game;
	
	public BurningMan(String name, String description) {
		super(name, description);
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
