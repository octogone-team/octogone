package fr.dauphine.sia.display;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class WelcomePage extends JFrame {

    WelcomePage() {
        JPanel panel = new JPanel();
        panel.setLayout(null);



        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int)screenSize.getWidth();

        JLabel userLabel = new JLabel("Welcome To Octogone Server");
        userLabel.setBounds(screenWidth/2-200, 100, 400, 25);
        userLabel.setForeground(Color.RED);
        userLabel.setBorder(new LineBorder(Color.BLACK));
        panel.add(userLabel);

        JButton movieSearchButton =new JButton("Movie research");//creating instance of JButton
        JButton musicSearchButton =new JButton("Music research");//creating instance of JButton
        movieSearchButton.setBounds((screenWidth/2),400,200, 40);//x axis, y axis, width, height

        musicSearchButton.setBounds((screenWidth/2)-300,400,200, 40);//x axis, y axis, width, height

        panel.add(movieSearchButton);
        panel.add(musicSearchButton);

        movieSearchButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SearchMoviePage.main(null);

            }
        });


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