package fr.dauphine.sia.display;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;


import fr.dauphine.sia.parser.MusicModel;
import fr.dauphine.sia.parser.ParserMusic;
import fr.dauphine.sia.search.SearchMusics;


public class SearchMusicPage extends JPanel {
	private static String image = "sparks.jpg";
	private static final long serialVersionUID = 1L;

	private JPanel panArtist = new JPanel();
	private JPanel panAlbum = new JPanel();
	private JPanel panTrack = new JPanel();
	private JPanel panLabel = new JPanel();
	private JPanel panresulat = new JPanel();

	private JLabel labelArtist = new JLabel("Name : ");
	private JFormattedTextField artist = new JFormattedTextField();
	private JButton searchButton1 = new JButton("OK");
	private JLabel labelAlbum = new JLabel("Album : ");
	private JFormattedTextField album = new JFormattedTextField();
	private JButton searchButton2 = new JButton("OK");
	private JLabel labelTrack = new JLabel("Track : ");
	private JFormattedTextField track = new JFormattedTextField();
	private JButton searchButton3 = new JButton("OK");
	private JLabel labelLabel = new JLabel("Label : ");
	private JFormattedTextField label = new JFormattedTextField();
	private JButton searchButton4 = new JButton("OK");

	private JTextPane resultArea = new JTextPane();
	private JFrame jFrame = new JFrame();

	public SearchMusicPage() {
		jFrame.setTitle("Search Musics Page");
		jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		panArtist.setBackground(Color.white);
		panArtist.setLayout(new GridBagLayout());
		panArtist.setOpaque(false);
		panAlbum.setBackground(Color.white);
		panAlbum.setLayout(new GridBagLayout());
		panAlbum.setOpaque(false);
		panTrack.setBackground(Color.white);
		panTrack.setLayout(new GridBagLayout());
		panTrack.setOpaque(false);
		panLabel.setBackground(Color.white);
		panLabel.setLayout(new GridBagLayout());
		panLabel.setOpaque(false);
		panresulat.setLayout(new GridBagLayout());
		panresulat.setOpaque(false);
		this.setLayout(new GridBagLayout());
	}

	private void Fenetre() {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) screenSize.getWidth();
		int screenHeight = (int) screenSize.getHeight();
		resultArea.setOpaque(false);
		resultArea.setFont(new Font("Arial", Font.LAYOUT_LEFT_TO_RIGHT, 14));
		resultArea.setPreferredSize(new Dimension(screenWidth - 120, screenHeight - 500));
		resultArea.setEditable(false);

		artist.setFont(new Font("Arial", Font.BOLD, 14));
		artist.setPreferredSize(new Dimension(screenWidth - 300, 30));
		artist.setForeground(Color.BLUE);

		album.setFont(new Font("Arial", Font.BOLD, 14));
		album.setPreferredSize(new Dimension(screenWidth - 300, 30));
		album.setForeground(Color.BLUE);

		track.setFont(new Font("Arial", Font.BOLD, 14));
		track.setPreferredSize(new Dimension(screenWidth - 300, 30));
		track.setForeground(Color.BLUE);

		label.setFont(new Font("Arial", Font.BOLD, 14));
		label.setPreferredSize(new Dimension(screenWidth - 300, 30));
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
		panArtist.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search Music By Artist"));

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
		panAlbum.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search Music By Album"));

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
		panTrack.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search Music By Track"));

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
		panLabel.setBorder(
				BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Search Music By Label"));

		// Result Panel
		GridBagConstraints constraintsPanResult = new GridBagConstraints();
		constraintsPanResult.anchor = GridBagConstraints.WEST;
		constraintsPanResult.gridx = 0;
		constraintsPanResult.gridy = 0;
		panresulat.add(resultArea, constraintsPanResult);
		panresulat.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Result"));
		JScrollPane scroll = new JScrollPane(resultArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		searchButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!artist.getText().equals("")) {

					List<MusicModel> l = ParserMusic
							.parserArtistModel(SearchMusics.searchByArtistName(artist.getText()));
					displayMusic(l);
				} else {
					JOptionPane.showMessageDialog(null, "Veuillez saisir le nom de l'artist");
				}
			}
		});
		searchButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!album.getText().equals("")) {
					List<MusicModel> l = ParserMusic
							.parserArtistModel(SearchMusics.searchByAlbumName(artist.getText()));
					displayMusic(l);
				} else {
					JOptionPane.showMessageDialog(null, "Veuillez saisir l'album");
				}
			}
		});
		searchButton3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!track.getText().equals("")) {
					List<MusicModel> l = ParserMusic
							.parserArtistModel(SearchMusics.searchByTrackName(artist.getText()));
					displayMusic(l);
				} else {
					JOptionPane.showMessageDialog(null, "Veuillez saisir le track");
				}
			}
		});
		searchButton4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!label.getText().equals("")) {
					List<MusicModel> l = ParserMusic
							.parserArtistModel(SearchMusics.searchByLabelName(artist.getText()));
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
		this.add(panArtist, constraintsPan);
		constraintsPan.gridx = 0;
		constraintsPan.gridy = 1;
		this.add(panAlbum, constraintsPan);
		constraintsPan.gridx = 0;
		constraintsPan.gridy = 2;
		this.add(panTrack, constraintsPan);
		constraintsPan.gridx = 0;
		constraintsPan.gridy = 3;
		this.add(panLabel, constraintsPan);
		constraintsPan.gridx = 0;
		constraintsPan.gridy = 4;
		this.add(scroll, constraintsPan);
		jFrame.add(this);
		jFrame.pack();
		jFrame.setAlwaysOnTop(true);
		jFrame.setExtendedState(jFrame.MAXIMIZED_BOTH);
		jFrame.setVisible(true);
	}

	private void displayMusic(List<MusicModel> l) {
		if (l != null) {
			System.out.println("Voici la musique: " + l.toString());
			StringBuilder s = new StringBuilder();
			s.append("<html>");
			for (MusicModel musicModel : l) {
				s.append("<table>");
				s.append("<tr>");
				s.append("<td style=\"text-align:left\">");
				s.append("<img src = \"" + musicModel.getArtist().getPicture_medium()
						+ "\" style=\"width:150px;height:150px;\"/>");
				s.append("</td>");
				s.append("<td>");
				s.append(
						"<p align=\"center\" style=\"font-size:50px; font-weight:bold; text-align:center\">"
								+ musicModel.getTitle());
				s.append("<span style=\"font-size:15px;\"> - " + ((int) musicModel.getDuration() / 60) + " min "
						+ (musicModel.getDuration() % 60) + " secondes </span>");
				s.append("<br>");
				s.append("<span align=\"center\" style=\"font-size:20px; font-style:italic;\">"
						+ musicModel.getArtist().getName() + "</span>");
				s.append("</p>");
				s.append("<p>");
				s.append(
						"<span align=\"center\" style=\"font-size:18px; font-style:italic; color:blue;\">Titre raccourci : </span>");
				s.append("<span align=\"center\" style=\"font-size:20px; font-style:italic;\">"
						+ musicModel.getTitle_short() + "</span>");
				s.append("</p>");
				s.append("<p>");
				s.append(
						"<span align=\"center\" style=\"font-size:18px; font-style:italic; color:blue;\">Nom Album : </span>");
				s.append("<span align=\"center\" style=\"font-size:20px; font-style:italic;\">"
						+ musicModel.getAlbum().getTitle() + "</span>");
				s.append("</p>");
				s.append("<p>");
				s.append(
						"<span align=\"center\" style=\"font-size:18px; font-style:italic; color:blue;\">Rang : </span>");
				s.append("<span align=\"center\" style=\"font-size:20px; font-style:italic;\">" + musicModel.getRank()
						+ "</span>");
				s.append("</p>");
				s.append("<p>");
				s.append(
						"<span align=\"center\" style=\"font-size:18px; font-style:italic; color:blue;\">Lien : </span>");
				s.append("<span align=\"center\" style=\"font-size:20px; font-style:italic;\">" + musicModel.getLink()
						+ "</span>");
				s.append("</p>");
				s.append("<p>");
				s.append(
						"<span align=\"center\" style=\"font-size:18px; font-style:italic; color:blue;\">Audio : </span>");
				// s.append("<audio src= \"" + musicModel.getPreview() + "\"
				// type=\"audio/mpeg\"> </audio>");
				s.append("</p>");
				s.append("</td>");
				// s.append("<source src= \"" + musicModel.getPreview() + "\" type=\"audio/mpeg
				// \">");
				s.append("</tr>");
				s.append("</table>");
				s.append("<br>");
				s.append("<HR>");

			}
			s.append("</html>");
			resultArea.setContentType("text/html");
			resultArea.setText(s.toString());
		} else {
			JOptionPane.showMessageDialog(null, "Music introuvable");
		}
	}

	public static void main(String[] args) {
		SearchMusicPage p = new SearchMusicPage();
		p.Fenetre();
	}

	@Override
	public void paintComponent(Graphics g) {
		try (InputStream inputstream = WelcomePage.class.getResourceAsStream(image)) {
			if (inputstream == null) {
				System.out.println("File not found");
				throw new FileNotFoundException("File not found");
			}
			Image image = ImageIO.read(inputstream);
			g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
