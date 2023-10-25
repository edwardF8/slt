package friedmanprod;


import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class test {
    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("src/images/math.png");
        JLabel imageLabel = new JLabel(icon);
        JFrame frame = new JFrame("Image Icon Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(imageLabel);
        frame.pack();
        frame.setVisible(true);
    }
}
