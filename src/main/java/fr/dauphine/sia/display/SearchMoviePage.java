package fr.dauphine.sia.display;
import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import fr.dauphine.sia.SearchMovies;
import fr.dauphine.sia.Parser.MovieModel;
import fr.dauphine.sia.Parser.ParserMovie;

public class SearchMoviePage extends JFrame {
	private static final long serialVersionUID = 1L;
	
	 private JPanel panFilm = new JPanel();
	 private JPanel panresulat = new JPanel();
	 private JPanel pan = new JPanel();
	 private JFormattedTextField movieTitle = new JFormattedTextField();
	 private JLabel label = new JLabel("Entre le titre du film que vous voulez chercher : ");
	 private JButton searchButton = new JButton ("OK");

	  public void Fenetre(){
	    this.setTitle("Search Movies Page");
	    this.setSize(300, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    panFilm.setBackground(Color.white);
	    panFilm.setLayout(new GridBagLayout()); 
	    
	   
	    panresulat.setBackground(Color.white);
	    panresulat.setLayout(new GridBagLayout());
	    
	    pan.setLayout(new GridBagLayout());
	    
	    
	    
	    GridBagConstraints constraints = new GridBagConstraints();
		constraints.anchor = GridBagConstraints.WEST;
		constraints.insets = new Insets(10, 10, 10, 10);
		
		constraints.gridx = 0;
		constraints.gridy = 0;		
		panFilm.add(label, constraints);
		
		constraints.gridx = 1;
		panFilm.add(movieTitle, constraints);
	      
	    movieTitle.setFont(new Font("Arial", Font.BOLD, 14));
	    movieTitle.setPreferredSize(new Dimension(150, 30));
	    movieTitle.setForeground(Color.BLUE);
	    
	    constraints.gridx = 0;
		constraints.gridy = 2;
		constraints.gridwidth = 2;
		constraints.anchor = GridBagConstraints.CENTER;
		panFilm.add(searchButton, constraints);
		
		panFilm.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Film"));
		panresulat.setBorder(BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder(), "Result"));
		
	    //searchButton.setPreferredSize(new Dimension(10,10 ));
	    
	    searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("TEXT : title " + movieTitle.getText());
				MovieModel film=ParserMovie.parserFileJSON(SearchMovies.getSpecificMoviesOrSeriesByTitle(movieTitle.getText()));
				System.out.println(" voici le film: "+film);
				panresulat.add(new JTextArea(film.toString()));
				//panresulat.add(new JLabel(film.getCountry()));
			}
		});
	    
	   
		 pan.add(panFilm);
	     pan.add(panresulat);  
	     add(pan);
	     pack();
	     this.setVisible(true);
	  }       

	  public static void main(String[] args) {
		SearchMoviePage p = new SearchMoviePage();
		p.Fenetre();
	}
}
