package fr.dauphine.sia.display;


import javax.swing.*;
import java.awt.*;

public class WelcomePage extends JFrame {

    WelcomePage() {
        JPanel panel = new JPanel();
        panel.setLayout(null);



        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int)screenSize.getWidth();

        JLabel userLabel = new JLabel("Welcome To Octogone Server");
        userLabel.setBounds(screenWidth/2-200, 100, 400, 25);
        panel.add(userLabel);

        JButton movieSearchButton =new JButton("Movie research");//creating instance of JButton
        JButton musicSearchButton =new JButton("Music research");//creating instance of JButton
        movieSearchButton.setBounds((screenWidth/2),400,200, 40);//x axis, y axis, width, height
        musicSearchButton.setBounds((screenWidth/2)-300,400,200, 40);//x axis, y axis, width, height

        panel.add(movieSearchButton);
        panel.add(musicSearchButton);


        JFrame frame = new JFrame("octogone Server");
        frame.setSize(300, 150);


        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.add(panel);
        frame.setVisible(true);

    }

    public static void main(String[] args)
    {
        new WelcomePage();
    }


}
