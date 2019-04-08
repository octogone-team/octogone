package fr.dauphine.sia;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class SearchFilm {

	public JSONObject getFilm () {

    	String url = "http://www.omdbapi.com/";
        String charset = "UTF-8";
        String title = "Game of Thrones";
        String season = "5";
        String episode = "5";
        String key = "aac9f937";

        try {
        	String query = String.format("apikey=%s&t=%s&season=%s&episode=%s", 
        			URLEncoder.encode(key, charset),
        			URLEncoder.encode(title, charset), 
                    URLEncoder.encode(season, charset),
                    URLEncoder.encode(episode, charset));

            URLConnection connection = new URL(url + "?" + query).openConnection();
            connection.setRequestProperty("Accept-Charset", charset);
               
			InputStream response = connection.getInputStream();
			
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject)jsonParser.parse(new InputStreamReader(response, "UTF-8"));
			return jsonObject;
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
}
