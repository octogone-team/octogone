package fr.dauphine.sia.parser;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.dauphine.sia.parser.MovieModel.TYPE;
import fr.dauphine.sia.properties.PropertiesLoader;
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
					if(attr.equals("Episodes")) {
						movie.setAttribute(attr, String.valueOf(jsonObject.getJSONArray(attr).length()));
					}else {
						movie.setAttribute(attr, jsonObject.getString(attr));
					}
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
		System.out.println("->"+jsonStr);
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
						if(movie.getAttribute("Type").equals("series") && !movie.getAttribute("totalSeasons").equals("N/A")) {
							int nbrSeason = Integer.parseInt(movie.getAttribute("totalSeasons"));
							for(int s=1; s<=nbrSeason; s++) {
								MovieModel season=parserFileJSON(SearchMovies.getSpecificSeriesBySeason(title, s));
								if(season.getAttribute("Episodes")!=null) {
									int nbrEpisode = Integer.parseInt(season.getAttribute("Episodes"));
									for(int ep=1; ep<=nbrEpisode; ep++) {
										MovieModel episode=parserFileJSON(SearchMovies.getSpecificSeriesByEpisode(title, s, ep));
										if(episode!=null) {
											episode.setType(TYPE.SERIE);
											episode.setAttribute("SerieTitle", title);
											elements.add(episode);
										}
									}
								}
							}
						} else {
							movie.setType(TYPE.MOVIE);
							elements.add(movie);
						}
					}
				}
			}
			
		}
		return elements;
	}

}
