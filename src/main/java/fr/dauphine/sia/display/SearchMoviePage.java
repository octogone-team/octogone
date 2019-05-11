package fr.dauphine.sia.display;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import fr.dauphine.sia.SearchMovies;
import fr.dauphine.sia.Parser.MovieModel;
import fr.dauphine.sia.Parser.ParserMovie;

public class SearchMoviePage extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int screenWidth = (int)screenSize.getWidth();
    int screenHeight = (int)screenSize.getHeight();
	
	 private JPanel panMovie = new JPanel();
	 private JPanel panSerie = new JPanel();
	 private JPanel panresulat = new JPanel();
	 private JPanel pan = new JPanel();
	 
	 private JLabel labelMovie = new JLabel("Movie Title : ");
	 private JFormattedTextField movieTitle = new JFormattedTextField();
	 private JLabel labelYear = new JLabel("Year's release of movie : ");
	 private JFormattedTextField year = new JFormattedTextField();
	 private JLabel labelSeason = new JLabel("Season (if serie) : ");
	 private JFormattedTextField season = new JFormattedTextField();
	 private JLabel labelEpisod = new JLabel("Episod (if serie) : ");
	 private JFormattedTextField episod = new JFormattedTextField();
	 private JButton searchFilmButton = new JButton ("OK");
	 
	 private JTextPane resultArea = new JTextPane();
	 
 	 
	 public SearchMoviePage() {
		 this.setTitle("Search Movies Page");
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 panMovie.setBackground(Color.white);
		 panMovie.setLayout(new GridBagLayout()); 
		 panresulat.setBackground(Color.white);
		 panresulat.setLayout(new GridBagLayout());
		 panSerie.setBackground(Color.white);
		 panSerie.setLayout(new GridBagLayout());
		 pan.setLayout(new GridBagLayout());
	 }

	 public void Fenetre(){
	    movieTitle.setFont(new Font("Arial", Font.BOLD, 14));
		movieTitle.setPreferredSize(new Dimension(screenWidth-1340, 30));
		movieTitle.setForeground(Color.BLUE);
		year.setFont(new Font("Arial", Font.BOLD, 14));
		year.setPreferredSize(new Dimension(screenWidth-1600, 30));
		year.setForeground(Color.BLUE);
		season.setFont(new Font("Arial", Font.BOLD, 14));
		season.setPreferredSize(new Dimension(screenWidth-1800, 30));
		season.setForeground(Color.BLUE);
		episod.setFont(new Font("Arial", Font.BOLD, 14));
		episod.setPreferredSize(new Dimension(screenWidth-1800, 30));
		episod.setForeground(Color.BLUE);
		
		resultArea.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 14));
		resultArea.setPreferredSize(new Dimension(screenWidth-200, screenHeight-500));
		resultArea.setEditable(false);
	
		// Search Movie Panel
		GridBagConstraints constraintsPanMovie = new GridBagConstraints();
		constraintsPanMovie.anchor = GridBagConstraints.WEST;
		constraintsPanMovie.insets = new Insets(10, 10, 10, 10);
		constraintsPanMovie.gridx = 0;
		constraintsPanMovie.gridy = 0;		
		panMovie.add(labelMovie, constraintsPanMovie);
		constraintsPanMovie.gridx = 1;
		constraintsPanMovie.gridy = 0;
		panMovie.add(movieTitle, constraintsPanMovie);
		constraintsPanMovie.gridx = 2;
		constraintsPanMovie.gridy = 0;		
		panMovie.add(labelYear, constraintsPanMovie);
		constraintsPanMovie.gridx = 3;
		constraintsPanMovie.gridy = 0;
		panMovie.add(year, constraintsPanMovie);
		constraintsPanMovie.gridx = 4;
		constraintsPanMovie.gridy = 0;
		panMovie.add(labelSeason, constraintsPanMovie);
		constraintsPanMovie.gridx = 5;
		constraintsPanMovie.gridy = 0;
		panMovie.add(season, constraintsPanMovie);
		constraintsPanMovie.gridx = 6;
		constraintsPanMovie.gridy = 0;
		panMovie.add(labelEpisod, constraintsPanMovie);
		constraintsPanMovie.gridx = 7;
		constraintsPanMovie.gridy = 0;
		panMovie.add(episod, constraintsPanMovie);
	    constraintsPanMovie.gridx = 0;
		constraintsPanMovie.gridy = 2;
		constraintsPanMovie.gridwidth = 10;
		constraintsPanMovie.anchor = GridBagConstraints.CENTER;
		panMovie.add(searchFilmButton, constraintsPanMovie);
		panMovie.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Search Films"));
		
		//Result Panel
		GridBagConstraints constraintsPanResult = new GridBagConstraints();
		constraintsPanResult.anchor = GridBagConstraints.WEST;
		constraintsPanResult.gridx = 0;
		constraintsPanResult.gridy = 0;
		panresulat.add(resultArea, constraintsPanResult);
		panresulat.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Result"));
		JScrollPane scroll = new JScrollPane(resultArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	    searchFilmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MovieModel movie = null;
				List<MovieModel> movies = new ArrayList<>();
				int y = -1;
				int ep = -1;
				int seas = -1;
				if (!movieTitle.getText().equals("")) {
					String t = movieTitle.getText();
					if(!year.getText().equals("")) {
						try {
							y = Integer.parseInt(year.getText());
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Attention! L'année est incorrect");
						}
					}
					else if(!episod.getText().equals("")) {
						try {
							ep = Integer.parseInt(episod.getText());
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Attention! L'épisode est incorrect");
						}
					}
					else if(!season.getText().equals("")) {
						try {
							seas = Integer.parseInt(season.getText());
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Attention! La saison est incorrect");
						}
					}
					if(seas==-1&&ep!=-1) {
						JOptionPane.showMessageDialog(null, "Attention! Quelle saison vous intéresse?");
					}
					
					//SEARCH
					if(y==-1&&seas==-1&&ep==-1) {
						if(SearchMovies.getMoviesByTitle(t).contains("Error")){
							movie=ParserMovie.parserFileJSON(SearchMovies.getSpecificMoviesOrSeriesByTitle(t));
						} else {
							movies = ParserMovie.parserFilesJSON(SearchMovies.getMoviesByTitle(t));
						}
					} 
					else if (y!=-1&&seas==-1&&ep==-1) {
						movies=ParserMovie.parserFilesJSON(SearchMovies.getMoviesByYear(t, y));
					}
					else if(seas!=-1) {
						if(ep!=-1) {
							if(y!=-1) {
								movies = ParserMovie.parserFilesJSON(SearchMovies.getSeriesByEpisodeByYear(t, seas, ep, y));
							}else {
								movies = ParserMovie.parserFilesJSON(SearchMovies.getSeriesByEpisode(t, seas, ep));
							}
						} else {
							if(y!=-1) {
								movies = ParserMovie.parserFilesJSON(SearchMovies.getSeriesBySeasonByYear(t, seas, y));
							}else {
								movies = ParserMovie.parserFilesJSON(SearchMovies.getSeriesBySeason(t, seas));
							}
						}
					}
					
					//Display Movies
					StringBuilder s = new StringBuilder();
					if(movie!=null) {
						System.out.println();
						movies.add(movie);
					}
					if (!movies.isEmpty()){
						s.append("<html>");
						for (MovieModel m : movies) {
							s.append("<table>");
								s.append("<tr>");
									s.append("<td style=\"text-align:left\">");
										s.append("<img src = \""+m.getPoster()+"\" style=\"width:150px;height:150px;\"/>");
									s.append("</td>");
									
									s.append("<td>");
										s.append("<p align=\"center\" style=\"font-size:50px; font-weight:bold;\">"+m.getAttribute("Title"));
										s.append("<span style=\"font-size:15px;\"> - "+m.getAttribute("Runtime")+"</span>");
										s.append("<br>");
										s.append("<span align=\"center\" style=\"font-size:20px; font-style:italic;\">"+m.getAttribute("Plot")+"</span>");
										s.append("</p>");
										s.append("<p>");
										s.append("<span align=\"center\" style=\"font-size:18px; font-style:italic; color:blue;\">Date de sortie : </span>");
										s.append("<span align=\"center\" style=\"font-size:20px; font-style:italic;\">"+m.getAttribute("Released")+"</span>");
										s.append("</p>");
										s.append("<p>");
										s.append("<span align=\"center\" style=\"font-size:18px; font-style:italic; color:blue;\">Genre : </span>");
										s.append("<span align=\"center\" style=\"font-size:20px; font-style:italic;\">"+m.getAttribute("Genre")+"</span>");
										s.append("</p>");
										s.append("<p>");
										s.append("<span align=\"center\" style=\"font-size:18px; font-style:italic; color:blue;\">Langue : </span>");
										s.append("<span align=\"center\" style=\"font-size:20px; font-style:italic;\">"+m.getAttribute("Language")+"</span>");
										s.append("</p>");
										s.append("<p>");
										s.append("<span align=\"center\" style=\"font-size:18px; font-style:italic; color:blue;\">Producteur : </span>");
										s.append("<span align=\"center\" style=\"font-size:20px; font-style:italic;\">"+m.getAttribute("Director")+"</span>");
										s.append("</p>");
										s.append("<p>");
										s.append("<span align=\"center\" style=\"font-size:18px; font-style:italic; color:blue;\">Scénariste : </span>");
										s.append("<span align=\"center\" style=\"font-size:20px; font-style:italic;\">"+m.getAttribute("Writer")+"</span>");
										s.append("</p>");
										s.append("<p>");
										s.append("<span align=\"center\" style=\"font-size:18px; font-style:italic; color:blue;\">Acteur : </span>");
										s.append("<span align=\"center\" style=\"font-size:20px; font-style:italic;\">"+m.getAttribute("Actors")+"</span>");
										s.append("</p>");
									s.append("</td>");
								s.append("</tr>");
							s.append("</table>");
							s.append("<br>");
							s.append("<HR>");
						}
						s.append("</html>");
						resultArea.setContentType("text/html");
						resultArea.setText(s.toString());
					}
					else {
						JOptionPane.showMessageDialog(null, "Aucun film correspondant");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Attention! Veuillez saisir le titre du film");
				}
			}
		});

	    // Page Panel
 		GridBagConstraints constraintsPan = new GridBagConstraints();
 		constraintsPan.anchor = GridBagConstraints.WEST;
 		constraintsPan.insets = new Insets(10, 10, 10, 10);
 		constraintsPan.gridx = 0;
 		constraintsPan.gridy = 0;
 		pan.add(panMovie, constraintsPan);
 		constraintsPan.gridx = 0;
 		constraintsPan.gridy = 1;
 		pan.add(panSerie, constraintsPan);
 		constraintsPan.gridx = 0;
 		constraintsPan.gridy = 2;
 		pan.add(scroll, constraintsPan);
	 		
	    this.add(pan);
	    this.pack();
	    this.setVisible(true);
	 }       

	 public static void main(String[] args) {
		SearchMoviePage p = new SearchMoviePage();
		p.Fenetre();
	 }
}
