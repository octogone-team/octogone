package fr.dauphine.sia.search;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SearchMusics {

	private static String API_URL="https://api.deezer.com/search?q=";
	private static String ARTIST_TAG = "artist:\"";
    private static String ALBUM_TAG = "album:\"";
    private static String TRACK_TAG = "track:\"";
    private static String LABEL_TAG = "label:\"";
    private static String charset = "UTF-8";
    
	private static String search(String name, String TAG) {
		HttpURLConnection conn;
		name = name.replaceAll(" ", "+");
		try {
			conn = (HttpURLConnection) new URL(API_URL+TAG+name+"\"").openConnection();
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
	
	public static String searchByArtistName(String name) {
		return search(name, ARTIST_TAG);
	}
	
	public static String searchByAlbumName(String name) {
		return search(name, ALBUM_TAG);
	}
	
	public static String searchByTrackName(String name) {
		return search(name, TRACK_TAG);
	}
	
	public static String searchByLabelName(String name) {
		return search(name, LABEL_TAG);
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
