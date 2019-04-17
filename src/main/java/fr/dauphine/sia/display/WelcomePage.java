package fr.dauphine.sia.display;


import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.*;

public class WelcomePage extends JPanel  {
    private static Image image = Toolkit.getDefaultToolkit().getImage("/home/khoudi/Documents/M1 Dauphine/SIA2/octogone/src/main/java/fr/dauphine/sia/display/movies_music_background.jpg");

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

        JButton movieSearchButton =new JButton("Movie research");//creating instance of JButton
        JButton musicSearchButton =new JButton("Music research");//creating instance of JButton
        movieSearchButton.setBounds((screenWidth/2),400,200, 40);//x axis, y axis, width, height

        musicSearchButton.setBounds((screenWidth/2)-300,400,200, 40);//x axis, y axis, width, height

        this.add(movieSearchButton);
        this.add(musicSearchButton);

        movieSearchButton.addActionListener(e -> MoviePage.main(null));

        JFrame frame = new JFrame("octogone Server");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.pack();
        frame.setVisible(true);

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);

        g.drawImage (image, 0, 0, null);
        repaint();
    }

    public static void main(String[] args)
    {
        WelcomePage welcomePage= new WelcomePage();
    }


}