package rooms;

public class EventRoom implements Room {
	private String name;
	
	public EventRoom(String name) {
		this.name = name;
	}

	@Override
	public String getName() {
		return this.name;
	}

}
