package fr.dauphine.sia;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoviesTest {

	@Test
	public void getMoviesByTitleTest() {
		String myMV = "{\"Search\":[{\"Title\":\"X-Men: Days of Future Past\",\"Year\":\"2014\",\"imdbID\":\"tt1877832\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BZGIzNWYzN2YtMjcwYS00YjQ3LWI2NjMtOTNiYTUyYjE2MGNkXkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg\"},{\"Title\":\"X-Men: First Class\",\"Year\":\"2011\",\"imdbID\":\"tt1270798\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMTg5OTMxNzk4Nl5BMl5BanBnXkFtZTcwOTk1MjAwNQ@@._V1_SX300.jpg\"},{\"Title\":\"X-Men\",\"Year\":\"2000\",\"imdbID\":\"tt0120903\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BZmIyMDk5NGYtYjQ5NS00ZWQxLTg2YzQtZDk1ZmM4ZDBlN2E3XkEyXkFqcGdeQXVyMTQxNzMzNDI@._V1_SX300.jpg\"},{\"Title\":\"X2: X-Men United\",\"Year\":\"2003\",\"imdbID\":\"tt0290334\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNDk0NjYxMzIzOF5BMl5BanBnXkFtZTYwMTc1MjU3._V1_SX300.jpg\"},{\"Title\":\"X-Men: The Last Stand\",\"Year\":\"2006\",\"imdbID\":\"tt0376994\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNDBhNDJiMWEtOTg4Yi00NTYzLWEzOGMtMjNmNjAxNTBlMzY3XkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_SX300.jpg\"},{\"Title\":\"X-Men Origins: Wolverine\",\"Year\":\"2009\",\"imdbID\":\"tt0458525\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BZWRhMzdhMzEtZTViNy00YWYyLTgxZmUtMTMwMWM0NTEyMjk3XkEyXkFqcGdeQXVyNTIzOTk5ODM@._V1_SX300.jpg\"},{\"Title\":\"X-Men: Apocalypse\",\"Year\":\"2016\",\"imdbID\":\"tt3385516\",\"Type\":\"movie\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMjU1ODM1MzYxN15BMl5BanBnXkFtZTgwOTA4NDE2ODE@._V1_SX300.jpg\"},{\"Title\":\"X-Men\",\"Year\":\"1992–1997\",\"imdbID\":\"tt0103584\",\"Type\":\"series\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNTVjNmEwNTMtNmQ2ZC00MGJkLWI3MDgtNzMyNTc4YjVkNTQ1L2ltYWdlXkEyXkFqcGdeQXVyNTAyODkwOQ@@._V1_SX300.jpg\"},{\"Title\":\"Wolverine and the X-Men\",\"Year\":\"2008–2009\",\"imdbID\":\"tt0772145\",\"Type\":\"series\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BNzk4Nzg3NjMyMV5BMl5BanBnXkFtZTcwMjk3MjU0Mg@@._V1_SX300.jpg\"},{\"Title\":\"X-Men: Evolution\",\"Year\":\"2000–2003\",\"imdbID\":\"tt0247827\",\"Type\":\"series\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BOWMyMThhN2UtMGMzYi00ODVmLWFlODItYmZlMzMxYzE3MmZkXkEyXkFqcGdeQXVyOTgwMzk1MTA@._V1_SX300.jpg\"}],\"totalResults\":\"78\",\"Response\":\"True\"}";
		assertEquals(SearchMovies.getMoviesByTitle("X-men"),myMV);
	}
	
	@Test
	public void getMoviesByYear() {
		String myMV = "{\"Search\":[{\"Title\":\"X-Men: Mutant Academy 2\",\"Year\":\"2001\",\"imdbID\":\"tt0286319\",\"Type\":\"game\",\"Poster\":\"N/A\"},{\"Title\":\"X-Men: Reign of Apocalypse\",\"Year\":\"2001\",\"imdbID\":\"tt0494293\",\"Type\":\"game\",\"Poster\":\"N/A\"}],\"totalResults\":\"2\",\"Response\":\"True\"}";
		assertEquals(SearchMovies.getMoviesByYear("X-men", 2001),myMV);
	}
	@Test
	public void getSeriesByTitle() {
		String myMV = "{\"Title\":\"Game of Thrones\",\"Year\":\"2011–\",\"Rated\":\"TV-MA\",\"Released\":\"17 Apr 2011\",\"Runtime\":\"57 min\",\"Genre\":\"Action, Adventure, Drama, Fantasy, Romance\",\"Director\":\"N/A\",\"Writer\":\"David Benioff, D.B. Weiss\",\"Actors\":\"Peter Dinklage, Lena Headey, Emilia Clarke, Kit Harington\",\"Plot\":\"Nine noble families fight for control over the mythical lands of Westeros, while an ancient enemy returns after being dormant for thousands of years.\",\"Language\":\"English\",\"Country\":\"USA, UK\",\"Awards\":\"Won 1 Golden Globe. Another 273 wins & 454 nominations.\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BMjA5NzA5NjMwNl5BMl5BanBnXkFtZTgwNjg2OTk2NzM@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"9.5/10\"}],\"Metascore\":\"N/A\",\"imdbRating\":\"9.5\",\"imdbVotes\":\"1,429,496\",\"imdbID\":\"tt0944947\",\"Type\":\"series\",\"totalSeasons\":\"8\",\"Response\":\"True\"}";
		assertEquals(SearchMovies.getSpecificMoviesOrSeriesByTitle("Game+of+Thrones"),myMV);
	}
	
	@Test
	public void getSeriesBySeason() {
		String myMV = "{\"Title\":\"Game of Thrones\",\"Season\":\"2\",\"totalSeasons\":\"8\",\"Episodes\":[{\"Title\":\"The North Remembers\",\"Released\":\"2012-04-01\",\"Episode\":\"1\",\"imdbRating\":\"8.9\",\"imdbID\":\"tt1971833\"},{\"Title\":\"The Night Lands\",\"Released\":\"2012-04-08\",\"Episode\":\"2\",\"imdbRating\":\"8.6\",\"imdbID\":\"tt2069318\"},{\"Title\":\"What Is Dead May Never Die\",\"Released\":\"2012-04-15\",\"Episode\":\"3\",\"imdbRating\":\"8.9\",\"imdbID\":\"tt2070135\"},{\"Title\":\"Garden of Bones\",\"Released\":\"2012-04-22\",\"Episode\":\"4\",\"imdbRating\":\"8.9\",\"imdbID\":\"tt2069319\"},{\"Title\":\"The Ghost of Harrenhal\",\"Released\":\"2012-04-29\",\"Episode\":\"5\",\"imdbRating\":\"8.9\",\"imdbID\":\"tt2074658\"},{\"Title\":\"The Old Gods and the New\",\"Released\":\"2012-05-06\",\"Episode\":\"6\",\"imdbRating\":\"9.1\",\"imdbID\":\"tt2085238\"},{\"Title\":\"A Man Without Honor\",\"Released\":\"2012-05-13\",\"Episode\":\"7\",\"imdbRating\":\"9.0\",\"imdbID\":\"tt2085239\"},{\"Title\":\"The Prince of Winterfell\",\"Released\":\"2012-05-20\",\"Episode\":\"8\",\"imdbRating\":\"8.9\",\"imdbID\":\"tt2085240\"},{\"Title\":\"Blackwater\",\"Released\":\"2012-05-27\",\"Episode\":\"9\",\"imdbRating\":\"9.7\",\"imdbID\":\"tt2084342\"},{\"Title\":\"Valar Morghulis\",\"Released\":\"2012-06-03\",\"Episode\":\"10\",\"imdbRating\":\"9.4\",\"imdbID\":\"tt2112510\"}],\"Response\":\"True\"}";
		assertEquals(SearchMovies.getSeriesBySeason("Game+of+Thrones", 2),myMV);
	}
	
	@Test
	public void getSeriesByEpisode() {
		String myMV = "{\"Title\":\"The Night Lands\",\"Year\":\"2012\",\"Rated\":\"TV-MA\",\"Released\":\"08 Apr 2012\",\"Season\":\"2\",\"Episode\":\"2\",\"Runtime\":\"54 min\",\"Genre\":\"Action, Adventure, Drama, Fantasy, Romance\",\"Director\":\"Alan Taylor\",\"Writer\":\"George R.R. Martin (based on \\\"A Song of Ice and Fire\\\" by), David Benioff (created by), D.B. Weiss (created by), David Benioff, D.B. Weiss\",\"Actors\":\"Peter Dinklage, Lena Headey, Emilia Clarke, Aidan Gillen\",\"Plot\":\"Arya makes friends with Gendry. Tyrion tries to take control of the Small Council. Theon arrives at his home, Pyke, in order to persuade his father into helping Robb with the war. Jon tries to investigate Craster's secret.\",\"Language\":\"English\",\"Country\":\"USA\",\"Awards\":\"N/A\",\"Poster\":\"https://m.media-amazon.com/images/M/MV5BYjY5ZmM3YTItMTE2ZS00YmEwLThjNTEtMDliM2Y4ZTQ1ZDYwXkEyXkFqcGdeQXVyMjk3NTUyOTc@._V1_SX300.jpg\",\"Ratings\":[{\"Source\":\"Internet Movie Database\",\"Value\":\"8.6/10\"}],\"Metascore\":\"N/A\",\"imdbRating\":\"8.6\",\"imdbVotes\":\"17823\",\"imdbID\":\"tt2069318\",\"seriesID\":\"tt0944947\",\"Type\":\"episode\",\"Response\":\"True\"}";
		assertEquals(SearchMovies.getSeriesByEpisode("Game+of+Thrones", 2, 2),myMV);
	}
}
