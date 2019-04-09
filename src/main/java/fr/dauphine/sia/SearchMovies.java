package fr.dauphine.sia;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SearchMovies {
	
	private static String key = "aac9f937";
	private static String url = "http://www.omdbapi.com/";
	private static String charset = "UTF-8";
	
	public static JSONObject getMoviesByTitle(String title) {
		String query = null;
		try {
			query = String.format("apikey=%s&s=%s", 
						URLEncoder.encode(key, charset),
						URLEncoder.encode(title, charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return getFilm(query);
	}
	
	public static JSONObject getMoviesByYear(String title, int year) {
		String query = null;
		try {
			query = String.format("apikey=%s&s=%s&y=%s", 
						URLEncoder.encode(key, charset),
						URLEncoder.encode(title, charset), 
						URLEncoder.encode(Integer.toString(year), charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return getFilm(query);
	}
	
	public static JSONObject getSeriesByTitle(String title) {
		String query = null;
		try {
			query = String.format("apikey=%s&t=%s", 
						URLEncoder.encode(key, charset),
						URLEncoder.encode(title, charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return getFilm(query);
	}
	
	public static JSONObject getSeriesBySeason(String title, int season) {
		String query = null;
		try {
			query = String.format("apikey=%s&t=%s&season=%s", 
						URLEncoder.encode(key, charset),
						URLEncoder.encode(title, charset), 
						URLEncoder.encode(Integer.toString(season), charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return getFilm(query);
	}
	
	public static JSONObject getSeriesByEpisode(String title, int season, int episode) {
		String query = null;
		try {
			query = String.format("apikey=%s&t=%s&season=%s&episode=%s", 
						URLEncoder.encode(key, charset),
						URLEncoder.encode(title, charset), 
						URLEncoder.encode(Integer.toString(season), charset), 
						URLEncoder.encode(Integer.toString(episode), charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return getFilm(query);
	}

	private static JSONObject getFilm (String query) {
		JSONObject jsonObject = null;
        try {
        	if(query!=null) {
	            URLConnection connection = new URL(url + "?" + query).openConnection();
	            connection.setRequestProperty("Accept-Charset", charset);
				InputStream response = connection.getInputStream();
				jsonObject = (JSONObject) new JSONParser().parse(new InputStreamReader(response, charset));
        	}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
        return jsonObject;
	}
}
