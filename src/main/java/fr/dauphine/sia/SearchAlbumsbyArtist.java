package fr.dauphine.sia;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

public class SearchAlbumsbyArtist {

	//Do not forget to replace space by %20 if there are any in the artist name
	public void getAlbumsByArtist(String artistName) throws MalformedURLException, IOException{
		HttpURLConnection conn = (HttpURLConnection) new URL(
                "https://api.deezer.com/search?q=artist:\""+artistName+"\"").openConnection();
        conn.connect();
 
        BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
 
        byte[] bytes = new byte[1024];
        int tmp ;
        while( (tmp = bis.read(bytes) ) != -1 ) {
            String chaine = new String(bytes,0,tmp);
            System.out.print(chaine);
        }
		
	}
	public static void main(String[] args) {
		SearchAlbumsbyArtist main = new SearchAlbumsbyArtist();
		try {
			main.getAlbumsByArtist("eminem");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
