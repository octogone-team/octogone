package fr.dauphine.sia.search;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SearchMovies {
	
	private static String key = "aac9f937";
	private static String url = "http://www.omdbapi.com/";
	private static String charset = "UTF-8";
	
	public static String getMoviesByTitle(String title) {
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
	
	public static String getMoviesByYears(String title, int year) {
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
	
	public static String getSpecificMoviesOrSeriesByTitle(String title) {
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
	
	public static String getSeriesBySeason(String title, int season) {
		String query = null;
		try {
			query = String.format("apikey=%s&s=%s&season=%s",
						URLEncoder.encode(key, charset),
						URLEncoder.encode(title, charset), 
						URLEncoder.encode(Integer.toString(season), charset));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return getFilm(query);
	}
	
	public static String getSpecificSeriesBySeason(String title, int season) {
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
	
	public static String getSpecificSeriesByEpisode(String title, int season, int episode) {
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

	private static String getFilm (String query) {
        try {
        	if(query!=null) {
	            URLConnection connection = new URL(url + "?" + query).openConnection();
	            connection.setRequestProperty("Accept-Charset", charset);
				InputStream response = connection.getInputStream();
				return (convertInputStreamToString(response));
        	}
		} catch (IOException e) {
			e.printStackTrace();
		}
        return null;
	}
	
	private static String convertInputStreamToString(InputStream inputStream){
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        try {
			while ((length = inputStream.read(buffer)) != -1) {
			    result.write(buffer, 0, length);
			}
			return result.toString(charset);
		} catch (IOException e) {
			e.printStackTrace();
		}
        return null;
	}
}
