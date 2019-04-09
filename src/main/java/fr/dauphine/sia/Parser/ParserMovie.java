package fr.dauphine.sia.Parser;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONStringer;

import java.io.BufferedInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class ParserMovie {

	
	public static List<ArtistModel> parserArtistModel(String jsonChaine){
		
		List<ArtistModel> list=new ArrayList<ArtistModel>();
		
		
		try {
			
			
			JSONObject jo =new JSONObject(jsonChaine);
			
			JSONArray array= jo.getJSONArray("data");
			
			for(int i=0; i<array.length();i++) {
				
				int id=array.getJSONObject(i).getInt("id");
			    boolean  readable=array.getJSONObject(i).getBoolean("readable");
			    String  title=array.getJSONObject(i).getString("title");
			    String  title_short=array.getJSONObject(i).getString("title_short");
			    String link=array.getJSONObject(i).getString("link");
			    int  duration=array.getJSONObject(i).getInt("duration");
			    int rank=array.getJSONObject(i).getInt("rank");
			    boolean  explicit_lyrics=array.getJSONObject(i).getBoolean("explicit_lyrics");
			    int  explicit_content_lyrics=array.getJSONObject(i).getInt("explicit_content_lyrics");
			    int  explicit_content_cover=array.getJSONObject(i).getInt("explicit_content_cover");
			    String   preview=array.getJSONObject(i).getString("preview");
			    Artist artist;
			    Album album;
			    String type=array.getJSONObject(i).getString("type");
			    
			    JSONObject artistObject=array.getJSONObject(i).getJSONObject("artist");
			    JSONObject albumObject=array.getJSONObject(i).getJSONObject("album");
			    
			    //initialisation of article
			    int idArtist=artistObject.getInt("id");
			    String nameArtist=artistObject.getString("name");  
			    String linkArtist=artistObject.getString("link");
			    String pictureArtist=artistObject.getString("picture");
			    String picture_smallArtist=artistObject.getString("picture_small");
			    String picture_mediumArtist=artistObject.getString("picture_medium");
			    String picture_bigArtist=artistObject.getString("picture_big");
			    String picture_xlArtist=artistObject.getString("picture_xl");
			    String tracklistArtist=artistObject.getString("tracklist");
			    String typeArtist=artistObject.getString("type");
			    artist= new  Artist( idArtist,  nameArtist,  linkArtist,   pictureArtist,   picture_smallArtist,
			    		  picture_mediumArtist,   picture_bigArtist,   picture_xlArtist,   tracklistArtist,
			    		  typeArtist);
			
			
			int  idAlbum=albumObject.getInt("id");
		    String titleAlbum=albumObject.getString("title");
		    String coverAlbum=albumObject.getString("cover");
		    String cover_smallAlbum=albumObject.getString("cover_small");
		    String cover_mediumAlbum=albumObject.getString("cover_medium");
		    String cover_bigAlbum=albumObject.getString("cover_big");
		    String cover_xlAlbum=albumObject.getString("cover_xl");
		    String tracklistAlbum=albumObject.getString("tracklist");
		    String typeAlbum=albumObject.getString("type");
		    
		    album= new Album( idAlbum,   titleAlbum, coverAlbum,  cover_smallAlbum,  cover_mediumAlbum, cover_bigAlbum, cover_xlAlbum,  tracklistAlbum ,  typeAlbum );
			
		    ArtistModel artistmodel=new ArtistModel( id, readable, title,  title_short, link,   duration, rank,
		    		 explicit_lyrics, explicit_content_lyrics, explicit_content_cover,  preview,  artist,  album,   type);
			
		    artistmodel.plot();
			list.add(artistmodel);
			} 
			 
			 
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
       
		return list;
	}
	
	public static Film parserFileJSON(String str) {
		
//		String address="http://www.omdbapi.com/?t="+titre+"&apikey=aac9f937";
		Film film = null;
//		HttpURLConnection conn;
		try {
//			conn = (HttpURLConnection) new URL(address).openConnection();
//			conn.connect();
//			BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
//			
//			String str=new String(bis.readAllBytes());
			
			JSONObject jo =new JSONObject(str);
			String response=jo.getString("Response");
			
			if(Boolean.parseBoolean(response)==true) {
				String title=jo.getString("Title");
			    String year=jo.getString("Year");
			    String rated=jo.getString("Rated");
			    String released=jo.getString("Released");
			    String runtime=jo.getString("Runtime");
			    String genre=jo.getString("Genre");
			    String director=jo.getString("Director");
			    String writer=jo.getString("Writer");
			    String actors=jo.getString("Actors");
			    String plot=jo.getString("Plot");
			    String language=jo.getString("Language");
			    String country=jo.getString("Country");
			    String awards=jo.getString("Awards");
			    String poster=jo.getString("Poster");
			    String metascore=jo.getString("Metascore");
			    String imdbRating=jo.getString("imdbVotes");
			    String imdbVotes=jo.getString("imdbVotes");
			    String imdbID=jo.getString("imdbID");
			    String type=jo.getString("Type");
			    String dVD=jo.getString("DVD");
			    String boxOffice=jo.getString("BoxOffice");
			    String production=jo.getString("Production");
			    String website=jo.getString("Website");
			    
				film= new Film(title,year,rated,released,runtime,genre,director,
				writer,actors,plot,language,country,awards,poster,metascore, imdbRating,imdbVotes,imdbID,type, 
				dVD,boxOffice, production,website,response);
				
				JSONArray array= jo.getJSONArray("Ratings");
				
				for(int i=0; i<array.length();i++) {
					String source=array.getJSONObject(i).getString("Source");
					String value=array.getJSONObject(i).getString("Value");
					Rating rating=new Rating(source, value);
					film.addRate(rating);
				}
			}
			else {
				System.out.println("Erreur de titre");
			}
			
		}  catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return film;
		
	}
	
	public static void main(String[] argv) {
	    ParserMovie.parserArtistModel(Artist.searchByTrackName("abc"));
		//Film film=ParserMovie.parserFileJSON("indian2332332a");
		
		//System.out.println(" voici le film: "+film);
	}

}
