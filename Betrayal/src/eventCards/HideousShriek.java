package eventCards;

import Game.Game;

public class HideousShriek extends EventCard {

	private Game game;
	
	public HideousShriek(String name, String description) {
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
