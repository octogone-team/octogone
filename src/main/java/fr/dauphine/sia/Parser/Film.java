package fr.dauphine.sia.Parser;

import java.util.ArrayList;
import java.util.List;

public class Film {
	String Title;
    String Year;
    String Rated;
    String Released;
    String Runtime;
    String Genre;
    String Director;
    String Writer;
    String Actors;
    String Plot;
    String Language;
    String Country;
    String Awards;
    String Poster;
    List<Rating> rates;
    String Metascore; 
    String imdbRating;
    String imdbVotes;
    String imdbID;
    String Type;
    String DVD;
    String BoxOffice;
    String Production;
    String Website;
    String Response;
	public Film(String title, String year, String rated, String released, String runtime, String genre, String director,
			String writer, String actors, String plot, String language, String country, String awards, String poster,
			String metascore, String imdbRating, String imdbVotes, String imdbID, String type, String dVD,
			String boxOffice, String production, String website, String response) {
		super();
		Title = title;
		Year = year;
		Rated = rated;
		Released = released;
		Runtime = runtime;
		Genre = genre;
		Director = director;
		Writer = writer;
		Actors = actors;
		Plot = plot;
		Language = language;
		Country = country;
		Awards = awards;
		Poster = poster;
		Metascore = metascore;
		this.imdbRating = imdbRating;
		this.imdbVotes = imdbVotes;
		this.imdbID = imdbID;
		Type = type;
		DVD = dVD;
		BoxOffice = boxOffice;
		Production = production;
		Website = website;
		Response = response;
		this.rates= new ArrayList();
	}
	
	public void addRate(Rating rate) {
		this.rates.add(rate);
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
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
		return "Film [Title=" + Title + ", Year=" + Year + ", Rated=" + Rated + ",\n Released=" + Released + ", Runtime="
				+ Runtime + ", Genre=" + Genre + ", Director=" + Director + ", Writer=" + Writer + ", Actors=" + Actors
				+ ", Plot=" + Plot + ",\n Language=" + Language + ",\n Country=" + Country + ", Awards=" + Awards
				+ ", Poster=" + Poster + ", rates=" + str + ", Metascore=" + Metascore + ", imdbRating=" + imdbRating
				+ ", imdbVotes=" + imdbVotes + ", imdbID=" + imdbID + ", Type=" + Type + ", DVD=" + DVD + ", BoxOffice="
				+ BoxOffice + ", Production=" + Production + ", Website=" + Website + ", Response=" + Response + "]";
	}
    
}
