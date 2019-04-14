package fr.dauphine.sia.Parser;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.dauphine.sia.SeachMusics;

public class ParserMusic {
	
	public static List<MusicModel> parserArtistModel(String jsonChaine){
		List<MusicModel> list=new ArrayList<MusicModel>();
		
		try {
			JSONObject jo =new JSONObject(jsonChaine);
			JSONArray array= jo.getJSONArray("data");
			
			for(int i=0; i<array.length();i++) {
				
				int id = array.getJSONObject(i).getInt("id");
			    boolean readable = array.getJSONObject(i).getBoolean("readable");
			    String title = array.getJSONObject(i).getString("title");
			    String title_short=array.getJSONObject(i).getString("title_short");
			    String link=array.getJSONObject(i).getString("link");
			    int duration=array.getJSONObject(i).getInt("duration");
			    int rank=array.getJSONObject(i).getInt("rank");
			    boolean explicit_lyrics=array.getJSONObject(i).getBoolean("explicit_lyrics");
			    int explicit_content_lyrics=array.getJSONObject(i).getInt("explicit_content_lyrics");
			    int explicit_content_cover=array.getJSONObject(i).getInt("explicit_content_cover");
			    String preview=array.getJSONObject(i).getString("preview");
			    Artist artist;
			    Album album;
			    String type=array.getJSONObject(i).getString("type");
			    
			    JSONObject artistObject=array.getJSONObject(i).getJSONObject("artist");
			    JSONObject albumObject=array.getJSONObject(i).getJSONObject("album");
			    
			    //initialization of artist
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
			
			    //initialization of album
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
			
			    //Music Model
			    MusicModel musiquemodel=new MusicModel( id, readable, title,  title_short, link,   duration, rank,
		    		 explicit_lyrics, explicit_content_lyrics, explicit_content_cover,  preview,  artist,  album,   type);
			
			    musiquemodel.plot();
				list.add(musiquemodel);
			} 
			 
		} catch (JSONException e) {
			e.printStackTrace();
		}  
		return list;
	}
	
	public static void main(String[] argv) {
	    ParserMusic.parserArtistModel(SeachMusics.searchByTrackName("abc"));
	}
}
