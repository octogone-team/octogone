package fr.dauphine.sia.search;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import fr.dauphine.sia.properties.PropertiesLoader;

public class SearchMusics {
	private static Properties API = PropertiesLoader.get("MusicAPIConfig.properties");
	private static Properties TAGS = PropertiesLoader.get("MusicTAGS.properties");
    
	private static String search(String name, String TAG) {
		HttpURLConnection conn;
		name = name.replaceAll(" ", "+");
		try {
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
