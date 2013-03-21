package rooms;

public class LibraryRoom extends Room {
	public LibraryRoom() {
		super("LibraryRoom");

		this.exits.put(Exit_Direction.SOUTH, null);
		this.exits.put(Exit_Direction.WEST, null);

	}

}
