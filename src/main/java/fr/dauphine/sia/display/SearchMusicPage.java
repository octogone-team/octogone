package fr.dauphine.sia.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import fr.dauphine.sia.SeachMusics;
import fr.dauphine.sia.Parser.MusicModel;
import fr.dauphine.sia.Parser.ParserMusic;

public class SearchMusicPage  extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JPanel panArtist = new JPanel();
	private JPanel panAlbum = new JPanel();
	private JPanel panTrack = new JPanel();
	private JPanel panLabel = new JPanel();
	private JPanel panresulat = new JPanel();
	private JPanel pan = new JPanel();
	
	 private JLabel labelArtist = new JLabel("Artist Name : ");
	 private JFormattedTextField artist = new JFormattedTextField();
	 private JButton searchButton1 = new JButton ("OK");
	 private JLabel labelAlbum = new JLabel("Album : ");
	 private JFormattedTextField album = new JFormattedTextField();
	 private JButton searchButton2 = new JButton ("OK");
	 private JLabel labelTrack = new JLabel("Track : ");
	 private JFormattedTextField track = new JFormattedTextField();
	 private JButton searchButton3 = new JButton ("OK");
	 private JLabel labelLabel = new JLabel("Label : ");
	 private JFormattedTextField label = new JFormattedTextField();
	 private JButton searchButton4 = new JButton ("OK");
	 
	 private JTextArea resultArea = new JTextArea();
	 
	 public SearchMusicPage() {
		 this.setTitle("Search Musics Page");
		 this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 panArtist.setBackground(Color.white);
		 panArtist.setLayout(new GridBagLayout());
		 panAlbum.setBackground(Color.white);
		 panAlbum.setLayout(new GridBagLayout());
		 panTrack.setBackground(Color.white);
		 panTrack.setLayout(new GridBagLayout());
		 panLabel.setBackground(Color.white);
		 panLabel.setLayout(new GridBagLayout());
		 panresulat.setBackground(Color.white);
		 panresulat.setLayout(new GridBagLayout());
		 pan.setLayout(new GridBagLayout());
	 }
	 
	 private void Fenetre() {
		 
		resultArea.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 14));
		resultArea.setPreferredSize(new Dimension(1800, 600));
		resultArea.setEditable(false);
		
		artist.setFont(new Font("Arial", Font.BOLD, 14));
		artist.setPreferredSize(new Dimension(1600, 30));
		artist.setForeground(Color.BLUE);
		
		album.setFont(new Font("Arial", Font.BOLD, 14));
		album.setPreferredSize(new Dimension(1630, 30));
		album.setForeground(Color.BLUE);
		
		track.setFont(new Font("Arial", Font.BOLD, 14));
		track.setPreferredSize(new Dimension(1630, 30));
		track.setForeground(Color.BLUE);
		
		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setPreferredSize(new Dimension(1630, 30));
		label.setForeground(Color.BLUE);
		
		// Search Music by artist panel
		GridBagConstraints constraintsPanArtist = new GridBagConstraints();
		constraintsPanArtist.anchor = GridBagConstraints.WEST;
		constraintsPanArtist.insets = new Insets(10, 10, 10, 10);
		constraintsPanArtist.gridx = 0;
		constraintsPanArtist.gridy = 0;		
		panArtist.add(labelArtist, constraintsPanArtist);
		constraintsPanArtist.gridx = 1;
		constraintsPanArtist.gridy = 0;		
		panArtist.add(artist, constraintsPanArtist);
		constraintsPanArtist.gridx = 2;
		constraintsPanArtist.gridy = 0;
		panArtist.add(searchButton1, constraintsPanArtist);
		panArtist.setBorder(BorderFactory.createTitledBorder(
						BorderFactory.createEtchedBorder(), "Search Music By Artist"));
		
		// Search Music by album panel
		GridBagConstraints constraintsPanAlbum = new GridBagConstraints();
		constraintsPanAlbum.anchor = GridBagConstraints.WEST;
		constraintsPanAlbum.insets = new Insets(10, 10, 10, 10);
		constraintsPanAlbum.gridx = 0;
		constraintsPanAlbum.gridy = 0;		
		panAlbum.add(labelAlbum, constraintsPanAlbum);
		constraintsPanAlbum.gridx = 1;
		constraintsPanAlbum.gridy = 0;		
		panAlbum.add(album, constraintsPanAlbum);
		constraintsPanAlbum.gridx = 2;
		constraintsPanAlbum.gridy = 0;
		panAlbum.add(searchButton2, constraintsPanAlbum);
		panAlbum.setBorder(BorderFactory.createTitledBorder(
						BorderFactory.createEtchedBorder(), "Search Music By Album"));
		
		// Search Music by track panel
		GridBagConstraints constraintsPanTrack = new GridBagConstraints();
		constraintsPanTrack.anchor = GridBagConstraints.WEST;
		constraintsPanTrack.insets = new Insets(10, 10, 10, 10);
		constraintsPanTrack.gridx = 0;
		constraintsPanTrack.gridy = 0;		
		panTrack.add(labelTrack, constraintsPanTrack);
		constraintsPanTrack.gridx = 1;
		constraintsPanTrack.gridy = 0;		
		panTrack.add(track, constraintsPanTrack);
		constraintsPanTrack.gridx = 2;
		constraintsPanTrack.gridy = 0;
		panTrack.add(searchButton3, constraintsPanTrack);
		panTrack.setBorder(BorderFactory.createTitledBorder(
						BorderFactory.createEtchedBorder(), "Search Music By Track"));
		
		// Search Music by label panel
		GridBagConstraints constraintsPanLabel = new GridBagConstraints();
		constraintsPanLabel.anchor = GridBagConstraints.WEST;
		constraintsPanLabel.insets = new Insets(10, 10, 10, 10);
		constraintsPanLabel.gridx = 0;
		constraintsPanLabel.gridy = 0;		
		panLabel.add(labelLabel, constraintsPanLabel);
		constraintsPanLabel.gridx = 1;
		constraintsPanLabel.gridy = 0;		
		panLabel.add(label, constraintsPanLabel);
		constraintsPanLabel.gridx = 2;
		constraintsPanLabel.gridy = 0;
		panLabel.add(searchButton4, constraintsPanLabel);
		panLabel.setBorder(BorderFactory.createTitledBorder(
						BorderFactory.createEtchedBorder(), "Search Music By Label"));
		
		//Result Panel
		GridBagConstraints constraintsPanResult = new GridBagConstraints();
		constraintsPanResult.anchor = GridBagConstraints.WEST;
		constraintsPanResult.gridx = 0;
		constraintsPanResult.gridy = 0;
		panresulat.add(resultArea, constraintsPanResult);
		panresulat.setBorder(BorderFactory.createTitledBorder(
						BorderFactory.createEtchedBorder(), "Result"));
		 
		searchButton1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(!artist.getText().equals("")) {
						List<MusicModel> l = ParserMusic.parserArtistModel(SeachMusics.searchByArtistName(artist.getText()));
						displayMusic(l);
					} else {
						JOptionPane.showMessageDialog(null, "Veuillez saisir le nom de l'artist");
					}
				}
		});
		searchButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!album.getText().equals("")) {
					List<MusicModel> l = ParserMusic.parserArtistModel(SeachMusics.searchByAlbumName(artist.getText()));
					displayMusic(l);
				} else {
					JOptionPane.showMessageDialog(null, "Veuillez saisir l'album");
				}
			}
		});
		searchButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!track.getText().equals("")) {
					List<MusicModel> l = ParserMusic.parserArtistModel(SeachMusics.searchByTrackName(artist.getText()));
					displayMusic(l);
				} else {
					JOptionPane.showMessageDialog(null, "Veuillez saisir le track");
				}
			}
		});
		searchButton4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!label.getText().equals("")) {
					List<MusicModel> l = ParserMusic.parserArtistModel(SeachMusics.searchByLabelName(artist.getText()));
					displayMusic(l);
				} else {
					JOptionPane.showMessageDialog(null, "Veuillez saisir le label");
				}
			}
		});
		
		// Page Panel
 		GridBagConstraints constraintsPan = new GridBagConstraints();
 		constraintsPan.anchor = GridBagConstraints.WEST;
 		constraintsPan.insets = new Insets(10, 10, 10, 10);
 		constraintsPan.gridx = 0;
 		constraintsPan.gridy = 0;
 		pan.add(panArtist, constraintsPan);
 		constraintsPan.gridx = 0;
 		constraintsPan.gridy = 1;
 		pan.add(panAlbum, constraintsPan);
 		constraintsPan.gridx = 0;
 		constraintsPan.gridy = 2;
 		pan.add(panTrack, constraintsPan);
 		constraintsPan.gridx = 0;
 		constraintsPan.gridy = 3;
 		pan.add(panLabel, constraintsPan);
 		constraintsPan.gridx = 0;
 		constraintsPan.gridy = 4;
 		pan.add(panresulat, constraintsPan);
 		
	    this.add(pan);
	    this.pack();
	    this.setVisible(true);
	 }
	 
	 private void displayMusic(List<MusicModel> l) {
		if(l!=null) {
			System.out.println("Voici la musique: "+l.toString());
			StringBuilder s = new StringBuilder();
			for (MusicModel musicModel : l) {
				s.append(musicModel.toString());
				s.append("\n");
			}
			resultArea.setText(s.toString());
		} else {
			JOptionPane.showMessageDialog(null, "Music introuvable");
		}
	 }
	 
	 public static void main(String[] args) {
			SearchMusicPage p = new SearchMusicPage();
			p.Fenetre();
     }
}
