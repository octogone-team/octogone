package fr.dauphine.sia.Parser;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

public class MovieModel {
	private static Logger LOGGER = Logger.getLogger(MovieModel.class);

	private HashMap<String, String> values;
	private List<Rating> rates;

	public MovieModel() {
		values = new HashMap<>();
	}

	public void addRate(Rating rate) {
		this.rates.add(rate);
	}

	public List<Rating> getRates() {
		return rates;
	}

	public void setRates(List<Rating> rates) {
		this.rates = rates;
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

//		String str="";
//		for(Rating rate:rates) {
//			str+=rate.toString();
//		}
//		return "Film [\nTitle=" + Title + ",\nYear=" + Year + ",\nRated=" + Rated + ",\nReleased=" + Released + ",\nRuntime="
//				+ Runtime + ",\nGenre=" + Genre + ",\nDirector=" + Director + ",\nWriter=" + Writer + ",\nActors=" + Actors
//				+ ",\nPlot=" + Plot + ",\nLanguage=" + Language + ",\nCountry=" + Country + ",\nAwards=" + Awards
//				+ ",\nPoster=" + Poster + ",\nrates=" + str + ",\nMetascore=" + Metascore + ",\nimdbRating=" + imdbRating
//				+ ",\nimdbVotes=" + imdbVotes + ",\nimdbID=" + imdbID + ",\nType=" + Type + ",\nDVD=" + DVD + ",\nBoxOffice="
//				+ BoxOffice + ",\nProduction=" + Production + ",\nWebsite=" + Website + ",\nResponse=" + Response + "]";
	}

}