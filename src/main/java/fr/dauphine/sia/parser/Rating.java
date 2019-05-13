package fr.dauphine.sia.parser;

public class Rating {
	
	String Source;
	String Value;
	public Rating(String source, String value) {
		super();
		Source = source;
		Value = value;
	}
	public String getSource() {
		return Source;
	}
	public void setSource(String source) {
		Source = source;
	}
	public String getValue() {
		return Value;
	}
	public void setValue(String value) {
		Value = value;
	}
	@Override
	public String toString() {
		return "Rating [Source=" + Source + ", Value=" + Value + "]";
	}

}
