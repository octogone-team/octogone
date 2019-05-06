package fr.dauphine.sia.parser;

import java.util.ArrayList;
import java.util.List;

public class MovieModel {
	private String Title;
	private String Year;
	private String Rated;
	private String Released;
	private String Runtime;
	private String Genre;
	private String Director;
	private String Writer;
	private String Actors;
	private String Plot;
	private String Language;
	private String Country;
	private String Awards;
	private String Poster;
	private String Metascore; 
	private String imdbRating;
	private String imdbVotes;
	private String imdbID;
	private String Type;
	private String DVD;
	private String BoxOffice;
	private String Production;
	private String Website;
	private String Response;
	private List<Rating> rates;

    public MovieModel(String title, String year, String rated, String released, String runtime, String genre, String director,
			String writer, String actors, String plot, String language, String country, String awards, String poster,
			String metascore, String imdbRating, String imdbVotes, String imdbID, String type, String dVD,
			String boxOffice, String production, String website, String response) {
		
    	this.Title = title;
    	this.Year = year;
    	this.Rated = rated;
    	this.Released = released;
    	this.Runtime = runtime;
    	this.Genre = genre;
    	this.Director = director;
    	this.Writer = writer;
    	this.Actors = actors;
    	this.Plot = plot;
    	this.Language = language;
    	this.Country = country;
    	this.Awards = awards;
    	this.Poster = poster;
    	this.Metascore = metascore;
		this.imdbRating = imdbRating;
		this.imdbVotes = imdbVotes;
		this.imdbID = imdbID;
		this.Type = type;
		this.DVD = dVD;
		this.BoxOffice = boxOffice;
		this.Production = production;
		this.Website = website;
		this.Response = response;
		this.rates= new ArrayList<Rating>();
	}
	
	public void addRate(Rating rate) {
		this.rates.add(rate);
	}
	
	public String getTitle() {
		return this.Title;
	}
	
	public void setTitle(String title) {
		this.Title = title;
	}
	
	public String getYear() {
		return Year;
	}
	
	public void setYear(String year) {
		Year = year;
	}
	
	public String getRated() {
		return Rated;
	}
	
	public void setRated(String rated) {
		Rated = rated;
	}
	
	public String getReleased() {
		return Released;
	}
	
	public void setReleased(String released) {
		Released = released;
	}
	
	public String getRuntime() {
		return Runtime;
	}
	
	public void setRuntime(String runtime) {
		Runtime = runtime;
	}
	
	public String getGenre() {
		return Genre;
	}
	
	public void setGenre(String genre) {
		Genre = genre;
	}
	
	public String getDirector() {
		return Director;
	}
	
	public void setDirector(String director) {
		Director = director;
	}
	
	public String getWriter() {
		return Writer;
	}
	
	public void setWriter(String writer) {
		Writer = writer;
	}
	
	public String getActors() {
		return Actors;
	}
	
	public void setActors(String actors) {
		Actors = actors;
	}
	
	public String getPlot() {
		return Plot;
	}
	
	public void setPlot(String plot) {
		Plot = plot;
	}
	
	public String getLanguage() {
		return Language;
	}
	
	public void setLanguage(String language) {
		Language = language;
	}
	
	public String getCountry() {
		return Country;
	}
	
	public void setCountry(String country) {
		Country = country;
	}
	
	public String getAwards() {
		return Awards;
	}
	
	public void setAwards(String awards) {
		Awards = awards;
	}
	
	public String getPoster() {
		return Poster;
	}
	
	public void setPoster(String poster) {
		Poster = poster;
	}
	
	public List<Rating> getRates() {
		return rates;
	}
	
	public void setRates(List<Rating> rates) {
		this.rates = rates;
	}
	
	public String getMetascore() {
		return Metascore;
	}
	
	public void setMetascore(String metascore) {
		Metascore = metascore;
	}
	
	public String getImdbRating() {
		return imdbRating;
	}
	
	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}
	
	public String getImdbVotes() {
		return imdbVotes;
	}
	
	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	
	public String getImdbID() {
		return imdbID;
	}
	
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	
	public String getType() {
		return Type;
	}
	
	public void setType(String type) {
		Type = type;
	}
	
	public String getDVD() {
		return DVD;
	}
	
	public void setDVD(String dVD) {
		DVD = dVD;
	}
	
	public String getBoxOffice() {
		return BoxOffice;
	}
	
	public void setBoxOffice(String boxOffice) {
		BoxOffice = boxOffice;
	}
	
	public String getProduction() {
		return Production;
	}
	
	public void setProduction(String production) {
		Production = production;
	}
	
	public String getWebsite() {
		return Website;
	}
	
	public void setWebsite(String website) {
		Website = website;
	}
	
	public String isResponse() {
		return Response;
	}
	
	public void setResponse(String response) {
		Response = response;
	}
    
	@Override
	public String toString() {
		String str="";
		for(Rating rate:rates) {
			str+=rate.toString();
		}
		return "Film [\nTitle=" + Title + ",\nYear=" + Year + ",\nRated=" + Rated + ",\nReleased=" + Released + ",\nRuntime="
				+ Runtime + ",\nGenre=" + Genre + ",\nDirector=" + Director + ",\nWriter=" + Writer + ",\nActors=" + Actors
				+ ",\nPlot=" + Plot + ",\nLanguage=" + Language + ",\nCountry=" + Country + ",\nAwards=" + Awards
				+ ",\nPoster=" + Poster + ",\nrates=" + str + ",\nMetascore=" + Metascore + ",\nimdbRating=" + imdbRating
				+ ",\nimdbVotes=" + imdbVotes + ",\nimdbID=" + imdbID + ",\nType=" + Type + ",\nDVD=" + DVD + ",\nBoxOffice="
				+ BoxOffice + ",\nProduction=" + Production + ",\nWebsite=" + Website + ",\nResponse=" + Response + "]";
	}
    
}
