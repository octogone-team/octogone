package fr.dauphine.sia.Parser;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;

public class ParserMovie {

	public static List<Movie> readMoviefromXML(String nameFileGraph) throws FileNotFoundException, XMLStreamException {
		List<Movie> listMovie = new ArrayList<Movie>();
		int eventType;
		String title;
		int year;
		String rated;
		Date released;
		String runtime;
		String genre;
		String director;
		String writer;
		String actors;
		String plot;
		String language;
		String country;
		String awards;
		String poster;
		int metascore;
		double imdbRating;
		double imbdVotes;
		String imdbID;
		String type;
		XMLInputFactory xmlif = XMLInputFactory.newInstance();
		XMLStreamReader xmlsr = xmlif.createXMLStreamReader(new FileReader(nameFileGraph));
		while (xmlsr.hasNext()) {
			eventType = xmlsr.next();

			switch (eventType) {
			case XMLEvent.START_ELEMENT:

				if (xmlsr.getLocalName().equals("movie")) {
					title = xmlsr.getAttributeValue(0);
					year = Integer.parseInt(xmlsr.getAttributeValue(1));
					rated = xmlsr.getAttributeValue(2);
					released = new SimpleDateFormat("dd/MM/yyyy").parse(xmlsr.getAttributeValue(3));
					runtime = xmlsr.getAttributeValue(4);

				}

				if (xmlsr.getLocalName().equals("data")) {
					if (xmlsr.getAttributeValue(0).equals("label")) {
						key = "label";
					}
					if (xmlsr.getAttributeValue(0).equals("r")) {
						key = "r";
					}
					if (xmlsr.getAttributeValue(0).equals("g")) {
						key = "g";
					}
					if (xmlsr.getAttributeValue(0).equals("b")) {
						key = "b";
					}
					if (xmlsr.getAttributeValue(0).equals("x")) {
						key = "x";
					}
					if (xmlsr.getAttributeValue(0).equals("y")) {
						key = "y";
					}
				}
				if (xmlsr.getLocalName().equals("edge")) {
					int source = Integer.parseInt(xmlsr.getAttributeValue(0));
					int target = Integer.parseInt(xmlsr.getAttributeValue(1));
					Movie MovieSource = null;
					Movie Movieneigh = null;
					for (Movie Movie : listMovie) {
						if (Movie.getId() == source) {
							MovieSource = Movie;
						}
						if (Movie.getId() == target) {
							Movieneigh = Movie;
						}
					}
					MovieSource.addNeighbour(Movieneigh);
					Movieneigh.addNeighbour(MovieSource);
				}

				break;
			case XMLEvent.CHARACTERS:

				if (key == "label") {
					Moviename = xmlsr.getText();
				}

				if (key == "r") {
					rgbcolors[0] = Integer.parseInt(xmlsr.getText());
				}
				if (key == "g") {
					rgbcolors[1] = Integer.parseInt(xmlsr.getText());
				}
				if (key == "b") {
					rgbcolors[2] = Integer.parseInt(xmlsr.getText());
				}

				if (key == "x") {
					x = Double.parseDouble(xmlsr.getText());
				}
				if (key == "y") {
					y = Double.parseDouble(xmlsr.getText());
				}
				key = null;

				break;

			case XMLEvent.END_ELEMENT:

				if (xmlsr.getLocalName().equals("node")) {
					Disease color = setDisease(rgbcolors);
					Movie Movie = new Movie(Moviename, id, color);
					listMovie.add(Movie);
					Movie.setCoordonates(x, y);
					Movie.setRgbColors(rgbcolors[0], rgbcolors[1], rgbcolors[2]);
				}

			default:
				break;
			}
		}
		return listMovie;
	}

}
