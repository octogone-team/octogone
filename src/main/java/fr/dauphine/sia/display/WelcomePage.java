package fr.dauphine.sia.display;


import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.*;

public class WelcomePage extends JPanel  {
	private static String image = "octogoneServer.jpg";

    WelcomePage() {

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int)screenSize.getWidth();
        int screenHeight = (int)screenSize.getHeight();

        JLabel title = new JLabel("Welcome To Octogone Server");
		title.setBounds(screenWidth/2-400, 90, 700, 100);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		Font font = new Font("Times", Font.BOLD, 40);
		title.setFont(font);
		title.setForeground(Color.WHITE);

		JButton movieSearchButton = new JButton("Movie research");// creating instance of JButton
		movieSearchButton.setBounds((screenWidth / 2) +90 , screenHeight/3, 200, 40);// x axis, y
		movieSearchButton.setVerticalAlignment(SwingConstants.CENTER);
		movieSearchButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
		movieSearchButton.setForeground(Color.BLACK);
		movieSearchButton.setBackground(Color.WHITE);
		movieSearchButton.addActionListener(e -> MoviePage.main(null));

		JButton musicSearchButton =new JButton("Music research");//creating instance of JButton
		musicSearchButton.setBounds((screenWidth/2)-350,screenHeight/3 ,200, 40);//x axis, y axis, width, height
		musicSearchButton.setVerticalAlignment(SwingConstants.CENTER);
		musicSearchButton.setBorder(BorderFactory.createLineBorder(Color.WHITE, 5));
		musicSearchButton.setForeground(Color.BLACK);
		musicSearchButton.setBackground(Color.WHITE);

		this.add(movieSearchButton);
		this.add(musicSearchButton);
		this.add(title);


        JFrame frame = new JFrame("octogone Server");
        frame.getContentPane().add(movieSearchButton);
        frame.getContentPane().add(musicSearchButton);
        frame.getContentPane().add(title);
		frame.setSize(1280, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
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