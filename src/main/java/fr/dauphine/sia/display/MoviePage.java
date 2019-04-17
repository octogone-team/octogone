package fr.dauphine.sia.display;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MoviePage extends JFrame {
	private static final long serialVersionUID = 1L;

	private JPanel container = new JPanel();
	private JButton boutonSeries = new JButton("Series");
	private JButton buttonMovies = new JButton("Movies");
	
	public void fenetre() {
		this.setTitle("Search Films");
		this.setSize(500, 500);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		container.setBackground(Color.WHITE);
		container.setLayout(new BorderLayout());
		
		JPanel pan = new JPanel();
		pan.add(boutonSeries);
		container.add(pan, BorderLayout.CENTER);
		pan.add(buttonMovies);
		buttonMovies.addActionListener(e -> SearchMoviePage.main(null));
		container.add(pan, BorderLayout.CENTER);
		this.setContentPane(container);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		MoviePage p = new MoviePage();
		p.fenetre();
	}
}
