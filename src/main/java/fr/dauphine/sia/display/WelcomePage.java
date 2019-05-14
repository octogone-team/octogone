package fr.dauphine.sia.display;


import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.*;

public class WelcomePage extends JPanel  {
	private static String image = "bg.jpg";

    public WelcomePage() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();

        JLabel title = new JLabel("Welcome To Octogone Server");
		title.setBounds(0, 0, screenWidth, 500);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		Font font = new Font("Times", Font.BOLD, 90);
		title.setFont(font);
		title.setForeground(Color.WHITE);
		JButton movieSearchButton = new JButton("Movie research");// creating instance of JButton
		JButton musicSearchButton =new JButton("Music research");//creating instance of JButton
		try {
		    Image img_film = ImageIO.read(this.getClass().getResource("icon_film.png"));
		    Image new_img_film = img_film.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		    movieSearchButton.setIcon(new ImageIcon(new_img_film));
		    Image img_music = ImageIO.read(this.getClass().getResource("icon_music.png"));
		    Image new_img_music = img_music.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
		    musicSearchButton.setIcon(new ImageIcon(new_img_music));
		} catch (IOException e) {
			System.out.println(e);
		}
		movieSearchButton.setBounds(4*screenHeight/5, screenHeight/2, screenHeight/2, 80);
		movieSearchButton.setHorizontalAlignment(SwingConstants.CENTER);
		movieSearchButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
		movieSearchButton.setForeground(Color.BLACK);
		movieSearchButton.setFont(new Font("Arial", Font.BOLD, 28));
		movieSearchButton.setOpaque(true);
		movieSearchButton.addActionListener(e -> SearchMoviePage.main(null));
		
		musicSearchButton.setBounds(screenHeight/5,screenHeight/2 ,screenHeight/2, 80);//x axis, y axis, width, height
		musicSearchButton.setHorizontalAlignment(SwingConstants.CENTER);
		musicSearchButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
		musicSearchButton.setForeground(Color.BLACK);
		musicSearchButton.setFont(new Font("Arial", Font.BOLD, 28));
		musicSearchButton.setOpaque(true);
        musicSearchButton.addActionListener(e -> SearchMusicPage.main(null));
		
		this.add(movieSearchButton);
		this.add(musicSearchButton);
		this.add(title);


        JFrame frame = new JFrame("octogone Server");
        frame.getContentPane().add(movieSearchButton);
        frame.getContentPane().add(musicSearchButton);
        frame.getContentPane().add(title);
		//frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setAlwaysOnTop(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);

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
