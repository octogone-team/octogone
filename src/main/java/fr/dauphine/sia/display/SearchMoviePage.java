package fr.dauphine.sia.display;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import fr.dauphine.sia.SearchMovies;
import fr.dauphine.sia.Parser.MovieModel;
import fr.dauphine.sia.Parser.ParserMovie;

public class SearchMoviePage extends JFrame {
	private static final long serialVersionUID = 1L;
	
	 private JPanel panFilm = new JPanel();
	 private JPanel panSerie = new JPanel();
	 private JPanel panresulat = new JPanel();
	 private JPanel pan = new JPanel();
	 
	 private JLabel labelFilm = new JLabel("Movie Title : ");
	 private JFormattedTextField movieTitle = new JFormattedTextField();
	 private JLabel labelYear = new JLabel("Year's release of movie : ");
	 private JFormattedTextField year = new JFormattedTextField();
	 private JButton searchFilmButton = new JButton ("OK");
	 
	 private JLabel labelSerie = new JLabel("Serie Title : ");
	 private JFormattedTextField serieTitle = new JFormattedTextField();
	 private JLabel labelSeason = new JLabel("Season : ");
	 private JFormattedTextField season = new JFormattedTextField();
	 private JLabel labelEpisod = new JLabel("Episod : ");
	 private JFormattedTextField episod = new JFormattedTextField();
	 private JButton searchSerieButton = new JButton ("OK");
	 
	 private JTextArea resultArea = new JTextArea();
 	 
	 public SearchMoviePage() {
		 this.setTitle("Search Movies Page");
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 panFilm.setBackground(Color.white);
		 panFilm.setLayout(new GridBagLayout()); 
		 panresulat.setBackground(Color.white);
		 panresulat.setLayout(new GridBagLayout());
		 panSerie.setBackground(Color.white);
		 panSerie.setLayout(new GridBagLayout());
		 pan.setLayout(new GridBagLayout());
	 }

	 public void Fenetre(){
	    movieTitle.setFont(new Font("Arial", Font.BOLD, 14));
		movieTitle.setPreferredSize(new Dimension(1000, 30));
		movieTitle.setForeground(Color.BLUE);
		year.setFont(new Font("Arial", Font.BOLD, 14));
		year.setPreferredSize(new Dimension(500, 30));
		year.setForeground(Color.BLUE);
		
		serieTitle.setFont(new Font("Arial", Font.BOLD, 14));
		serieTitle.setPreferredSize(new Dimension(1000, 30));
		serieTitle.setForeground(Color.BLUE);
		season.setFont(new Font("Arial", Font.BOLD, 14));
		season.setPreferredSize(new Dimension(255, 30));
		season.setForeground(Color.BLUE);
		episod.setFont(new Font("Arial", Font.BOLD, 14));
		episod.setPreferredSize(new Dimension(255, 30));
		episod.setForeground(Color.BLUE);
		
		resultArea.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 14));
		resultArea.setPreferredSize(new Dimension(1800, 600));
		resultArea.setEditable(false);
		
		// Search Film Panel
		GridBagConstraints constraintsPanFilm = new GridBagConstraints();
		constraintsPanFilm.anchor = GridBagConstraints.WEST;
		constraintsPanFilm.insets = new Insets(10, 10, 10, 10);
		constraintsPanFilm.gridx = 0;
		constraintsPanFilm.gridy = 0;		
		panFilm.add(labelFilm, constraintsPanFilm);
		constraintsPanFilm.gridx = 1;
		constraintsPanFilm.gridy = 0;
		panFilm.add(movieTitle, constraintsPanFilm);
		constraintsPanFilm.gridx = 2;
		constraintsPanFilm.gridy = 0;		
		panFilm.add(labelYear, constraintsPanFilm);
		constraintsPanFilm.gridx = 3;
		constraintsPanFilm.gridy = 0;
		panFilm.add(year, constraintsPanFilm);
	    constraintsPanFilm.gridx = 0;
		constraintsPanFilm.gridy = 2;
		constraintsPanFilm.gridwidth = 4;
		constraintsPanFilm.anchor = GridBagConstraints.CENTER;
		panFilm.add(searchFilmButton, constraintsPanFilm);
		panFilm.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Search Films"));
		
		// Search Serie Panel
		GridBagConstraints constraintsPanSerie = new GridBagConstraints();
		constraintsPanSerie.anchor = GridBagConstraints.WEST;
		constraintsPanSerie.insets = new Insets(10, 10, 10, 10);
		constraintsPanSerie.gridx = 0;
		constraintsPanSerie.gridy = 0;		
		panSerie.add(labelSerie, constraintsPanSerie);
		constraintsPanSerie.gridx = 1;
		constraintsPanSerie.gridy = 0;
		panSerie.add(serieTitle, constraintsPanSerie);
		constraintsPanSerie.gridx = 2;
		constraintsPanSerie.gridy = 0;		
		panSerie.add(labelSeason, constraintsPanSerie);
		constraintsPanSerie.gridx = 3;
		constraintsPanSerie.gridy = 0;
		panSerie.add(season, constraintsPanSerie);
		constraintsPanSerie.gridx = 4;
		constraintsPanSerie.gridy = 0;		
		panSerie.add(labelEpisod, constraintsPanSerie);
		constraintsPanSerie.gridx = 5;
		constraintsPanSerie.gridy = 0;
		panSerie.add(episod, constraintsPanSerie);
		constraintsPanSerie.gridx = 0;
		constraintsPanSerie.gridy = 2;
		constraintsPanSerie.gridwidth = 6;
		constraintsPanSerie.anchor = GridBagConstraints.CENTER;
		panSerie.add(searchSerieButton, constraintsPanSerie);
		panSerie.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Search Series"));
		
		//Result Panel
		GridBagConstraints constraintsPanResult = new GridBagConstraints();
		constraintsPanResult.anchor = GridBagConstraints.WEST;
		constraintsPanResult.gridx = 0;
		constraintsPanResult.gridy = 0;
		panresulat.add(resultArea, constraintsPanResult);
		panresulat.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Result"));
		
	    searchFilmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MovieModel film = null;
				if (!movieTitle.getText().equals("")) {
					String t = movieTitle.getText();
					if(!year.getText().equals("")) {
						try {
							int y = Integer.parseInt(year.getText());
							film=ParserMovie.parserFileJSON(SearchMovies.getMoviesByYear(t, y));
						} catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Attention! L'année est incorrect");
						}
					} else {
						film=ParserMovie.parserFileJSON(SearchMovies.getSpecificMoviesOrSeriesByTitle(t));
					}
					if(film!=null) {
						System.out.println("Voici la film: "+film);
						resultArea.setText(film.toString());
					} else {
						JOptionPane.showMessageDialog(null, "Aucun film correspondant");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Attention! Quel est le titre du film");
				}
			}
		});
	    
	    searchSerieButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!serieTitle.getText().equals("")) {
					MovieModel serie=null;
					String t = serieTitle.getText();
					if(season.getText().equals("")&&episod.getText().equals("")) {
						serie=ParserMovie.parserFileJSON(SearchMovies.getSpecificMoviesOrSeriesByTitle(t));
					} 
					else if(!season.getText().equals("")) {
						try{
							int s = Integer.parseInt(season.getText());
							if(!episod.getText().equals("")) {
								try {
									int ep = Integer.parseInt(episod.getText());
									serie=ParserMovie.parserFileJSON(SearchMovies.getSeriesByEpisode(t, s, ep));
								} catch (NumberFormatException e2) {
									JOptionPane.showMessageDialog(null, "Attention! L'épisode est incorrect");
								}
							}else {
								serie=ParserMovie.parserFileJSON(SearchMovies.getSeriesBySeason(t, s));
							}
					    } 
						catch (NumberFormatException e1) {
							JOptionPane.showMessageDialog(null, "Attention! La saison est incorrect");
					    }
					}
					else {
						JOptionPane.showMessageDialog(null, "Attention! Quel saison vous intéresse?");
					}
					if(serie!=null) {
						System.out.println("Voici la série: "+serie);
						resultArea.setText(serie.toString());
					} else {
						JOptionPane.showMessageDialog(null, "Aucune serie correspondante");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Attention! Quel est le titre de la série");
				}
			}
		});
	    
	   
	    // Page Panel
 		GridBagConstraints constraintsPan = new GridBagConstraints();
 		constraintsPan.anchor = GridBagConstraints.WEST;
 		constraintsPan.insets = new Insets(10, 10, 10, 10);
 		constraintsPan.gridx = 0;
 		constraintsPan.gridy = 0;
 		pan.add(panFilm, constraintsPan);
 		constraintsPan.gridx = 0;
 		constraintsPan.gridy = 1;
 		pan.add(panSerie, constraintsPan);
 		constraintsPan.gridx = 0;
 		constraintsPan.gridy = 2;
 		pan.add(panresulat, constraintsPan);
 		
	 		
	    this.add(pan);
	    this.pack();
	    this.setVisible(true);
	 }       

	 public static void main(String[] args) {
		SearchMoviePage p = new SearchMoviePage();
		p.Fenetre();
	 }
}
