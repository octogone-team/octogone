package fr.dauphine.sia.parser;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import fr.dauphine.sia.properties.PropertiesLoader;
import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.dauphine.sia.search.SearchMovies;

public class ParserMovie {

	private final static Logger LOGGER = Logger.getLogger(ParserMovie.class);
	
	private static final String ATTRIBUTES_FILE = "MovieAttributes.properties";
	private static final String API_CONFIG = "MovieAPIConfig.properties";
	
	public static final Properties ATTRIBUTES_PROPERTIES = PropertiesLoader.get(ATTRIBUTES_FILE);
	public static final Properties CONFIG_PROPERTIES = PropertiesLoader.get(API_CONFIG);
	

	public static MovieModel parserFileJSON(String jsonStr) {
		MovieModel movie = new MovieModel();
		JSONObject jsonObject = new JSONObject(jsonStr);
		if(Boolean.parseBoolean(jsonObject.getString("Response"))) {
			for(Object attribute : ATTRIBUTES_PROPERTIES.keySet()) {
				String attr = (String) attribute;
				try {
					movie.setAttribute(attr, jsonObject.getString(attr));
				} catch (JSONException e) {
					LOGGER.info(attr+" not in JSON");
				}
			}
		} else {
			LOGGER.error("Error in title: not valid");
		}
		return movie;
	}
	
	
	public static List<MovieModel> parserFilesJSON(String jsonStr) {
		List<MovieModel> elements=null;

		if(jsonStr!=null && jsonStr.contains("Response")) {
			JSONObject jo =new JSONObject(jsonStr);
			boolean response= jo.getBoolean("Response");
			if(response) {
				JSONArray array= jo.getJSONArray("Search");
				
				elements=new ArrayList<MovieModel>();
				for(int i=0; i<array.length();i++) {
					String title=array.getJSONObject(i).getString("Title");
					MovieModel movie=parserFileJSON(SearchMovies.getSpecificMoviesOrSeriesByTitle(title));
					if(movie!=null) {
						elements.add(movie);
					}
				}
			}
			
		}
		return elements;
	}

}
