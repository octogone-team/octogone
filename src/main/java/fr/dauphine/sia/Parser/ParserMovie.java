package fr.dauphine.sia.Parser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import fr.dauphine.sia.SearchMovies;

public class ParserMovie {

	public static MovieModel parserFileJSON(String jsonStr) {
		MovieModel movie = null;
		try {
			
			JSONObject jo =new JSONObject(jsonStr);
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
			    
			    movie= new MovieModel(title,year,rated,released,runtime,genre,director,
						writer,actors,plot,language,country,awards,poster,metascore, imdbRating,imdbVotes,imdbID,type, 
						dVD,boxOffice, production,website,response);
			    
			    JSONArray array= jo.getJSONArray("Ratings");
				
				for(int j=0; j<array.length();j++) {
					String source=array.getJSONObject(j).getString("Source");
					String value=array.getJSONObject(j).getString("Value");
					Rating rating=new Rating(source, value);
					movie.addRate(rating);
				}
			} else {
				System.out.println("Erreur de titre");
			}
			
		}  catch (JSONException e) {
			e.printStackTrace();
		}
		return movie;
	}
	
	public static void main(String[] argv) {
		MovieModel film=ParserMovie.parserFileJSON(SearchMovies.getSpecificMoviesByTitle("X-men"));
		System.out.println(" voici le film: "+film);
	}

}
