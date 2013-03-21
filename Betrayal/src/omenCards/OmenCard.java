package omenCards;

public class OmenCard {
	protected String name;
	protected String quote;

	protected OmenCard(String name, String quote) {
		this.name = name;
		this.quote = quote;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}

	public boolean isHauntRoll() {
		// TODO Auto-generated method stub
		return false;
	}
}