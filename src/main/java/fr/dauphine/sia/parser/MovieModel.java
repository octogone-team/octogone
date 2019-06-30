package fr.dauphine.sia.parser;

import java.util.HashMap;

import org.apache.log4j.Logger;

public class MovieModel {

	public enum TYPE{
		MOVIE,SERIE
	};

	private static Logger LOGGER = Logger.getLogger(MovieModel.class);
	
	private HashMap<String, String> values;
	private TYPE type;
	
	public MovieModel() {
		values = new HashMap<>();
	}
	
	public String getAttribute(String attribute) {
		return values.get(attribute);
	}
	
	public void setAttribute(String attribute, String value) {
		if(!ParserMovie.ATTRIBUTES_PROPERTIES.keySet().contains(attribute)) {
			LOGGER.error("Attribute does not exist");
		} else {
			values.put(attribute, value);
		}
	}
	
	public void setType(TYPE t) {
		this.type = t;
	}
	
	public boolean notExist() {
		return values.isEmpty();
	}
	
	public HashMap<String, String> getValues(){
		return values;
	}
    
	@Override
	public String toString() {
		if(values.containsKey("Titre")) {
			return "Titre: "+values.get("Titre");
		}
		return "";
	}
	
	@Override
	public boolean equals(Object object) {
		if(!(object instanceof MovieModel)) {
			return false;
		}
		MovieModel movie=(MovieModel) object;
		return values.equals(movie.values);
	}
}
