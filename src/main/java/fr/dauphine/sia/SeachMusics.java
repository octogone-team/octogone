package fr.dauphine.sia;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SeachMusics {

	private static String API_URL="https://api.deezer.com/search?q=";
	private static String ARTIST_TAG = "artist:\"";
    private static String ALBUM_TAG = "album:\"";
    private static String TRACK_TAG = "track:\"";
    private static String LABEL_TAG = "label:\"";
    private static String charset = "UTF-8";
    
	private static JSONObject search(String name, String TAG) {
		HttpURLConnection conn;
		name = name.replaceAll(" ", "+");
		try {
			conn = (HttpURLConnection) new URL(API_URL+TAG+name+"\"").openConnection();
			conn.connect();
			InputStream response = conn.getInputStream();
			JSONObject jsonObject = (JSONObject) new JSONParser().parse(new InputStreamReader(response, charset));
			return jsonObject;
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	
		return null;	
	}
	
	public static JSONObject searchByArtistName(String name) {
		return search(name, ARTIST_TAG);
	}
	
	public static JSONObject searchByAlbumName(String name) {
		return search(name, ALBUM_TAG);
	}
	
	public static JSONObject searchByTrackName(String name) {
		return search(name, TRACK_TAG);
	}
	
	public static JSONObject searchByLabelName(String name) {
		return search(name, LABEL_TAG);
	}
}
