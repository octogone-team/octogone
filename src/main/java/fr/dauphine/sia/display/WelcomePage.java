package fr.dauphine.sia.display;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WelcomePage extends JPanel  {
	private static String image = "movies_music_background.jpg";

    WelcomePage() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();

        JLabel userLabel = new JLabel("Welcome To Octogone Server");
		userLabel.setBounds(screenWidth/2-200, 100, 400, 25);
		userLabel.setHorizontalAlignment(SwingConstants.CENTER);
		Font font = new Font("Arial", Font.BOLD, 16);
		userLabel.setFont(font);
		this.add(userLabel);

		JButton movieSearchButton = new JButton("Movie research");// creating instance of JButton
        JButton musicSearchButton =new JButton("Music research");//creating instance of JButton
		// movieSearchButton.setBounds((screenWidth / 2), 800, 200, 40);// x axis, y
		// axis, width, height
		// movieSearchButton.setLocation(new Point(50, 50));
		// movieSearchButton.setVerticalAlignment(SwingConstants.CENTER);

		// musicSearchButton.setBounds((screenWidth / 2) - 300, 800, 200, 40);// x axis,
		// y axis, width, height
//		musicSearchButton.setVerticalAlignment(SwingConstants.CENTER);

		this.add(movieSearchButton);
		this.add(musicSearchButton);

        movieSearchButton.addActionListener(e -> MoviePage.main(null));

        JFrame frame = new JFrame("octogone Server");
		frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
		// frame.pack();
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

    public static void main(String[] args)
    {
        WelcomePage welcomePage= new WelcomePage();
    }


}