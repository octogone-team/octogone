package fr.dauphine.sia.display;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	private JPanel container = new JPanel();
	  private JFormattedTextField movieTitle = new JFormattedTextField();
	  private JLabel label = new JLabel("Entre le titre du film que vous voulez chercher : ");
	  private JButton searchButton = new JButton ("OK");
	  private JPanel top = new JPanel();

	  public void Fenetre(){
	    this.setTitle("Search Movies Page");
	    this.setSize(300, 300);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    this.setLocationRelativeTo(null);
	    container.setBackground(Color.white);
	    container.setLayout(new BorderLayout());
	      
	    movieTitle.setFont(new Font("Arial", Font.BOLD, 14));
	    movieTitle.setPreferredSize(new Dimension(150, 30));
	    movieTitle.setForeground(Color.BLUE);
	    searchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("TEXT : title " + movieTitle.getText());
				MovieModel film=ParserMovie.parserFileJSON(SearchMovies.getSpecificMoviesByTitle(movieTitle.getText()));
				System.out.println(" voici le film: "+film);
				
				
				JTextArea response = new JTextArea(film.toString());
				response.setLineWrap(true);
				response.setWrapStyleWord(true);
				response.setEditable(false);
				JScrollPane scrollPane = new JScrollPane(response);
				JOptionPane.showMessageDialog(null, scrollPane);
			}
		});
	    
	    top.add(label);
	    top.add(movieTitle);
	    top.add(searchButton);
	    this.setContentPane(top);
	    this.setVisible(true);            
	  }       

	  public static void main(String[] args) {
		SearchMoviePage p = new SearchMoviePage();
		p.Fenetre();
	}
}
