package fr.dauphine.sia.search;

import fr.dauphine.sia.properties.PropertiesLoader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import static fr.dauphine.sia.constants.SearchConstants.*;

public class SearchMusics {
	private static Properties API = PropertiesLoader.get(MUSIC_API_PROPERTIES);
	private static Properties TAGS = PropertiesLoader.get(MUSIC_TAGS_PROPERTIES);
    
	private static String search(String name, String TAG) {
		HttpURLConnection conn;
		name = name.replaceAll(" ", "+");
		try {
			System.out.println("URL:"+API.get("url"));
			System.out.println("TAG:"+TAG);
			System.out.println("name:"+name);
			conn = (HttpURLConnection) new URL(API.get("url")+TAG+name+"\"").openConnection();
			conn.connect();
			InputStream response = conn.getInputStream();
			return (convertInputStreamToString(response));
		} catch (MalformedURLException e) {
			e.printStackTrace();
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
			return result.toString(API.get("charset").toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String searchByArtistName(String name) {
		return search(name, TAGS.get("artist").toString());
	}
	
	public static String searchByAlbumName(String name) {
		return search(name, TAGS.get("album").toString());
	}
	
	public static String searchByTrackName(String name) {
		return search(name, TAGS.get("track").toString());
	}
	
	public static String searchByLabelName(String name) {
		return search(name, TAGS.get("label").toString());
	}
}
