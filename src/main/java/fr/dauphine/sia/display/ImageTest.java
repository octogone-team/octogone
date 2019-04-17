package fr.dauphine.sia.display;


import java.awt.Dimension;
        import java.awt.Graphics;
        import java.awt.Image;

        import javax.swing.ImageIcon;
        import javax.swing.JFrame;
        import javax.swing.JPanel;

public class ImageTest {

    public static void main(String[] args) {
        ImagePanel panel = new ImagePanel(new ImageIcon("/home/khoudi/Documents/M1 Dauphine/SIA2/octogone/src/main/ressources/movies_background.jpg").getImage());

        JFrame frame = new JFrame();
        frame.add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

class ImagePanel extends JPanel {

    private Image img;

    public ImagePanel(String img) {
        this(new ImageIcon(img).getImage());
    }

    public ImagePanel(Image img) {
        this.img = img;
        Dimension size = new Dimension(img.getWidth(null), img.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

}