package friedmanprod;

import javax.swing.*;     
import java.awt.Font;   
import java.awt.GridLayout;

public class GUI {
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public static void createAndShowGUI() {
        //Create and set up the window.
        
        //Add the ubiquitous "Hello World" label.        

        JFrame frame = new JFrame("ExporeOffline");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,100,600,400);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainScreen = new JPanel();
        JLabel title = new JLabel("ExploreOffline");
        title.setBounds(0,0,300,100);
        title.setFont(new Font("Serif", Font.PLAIN, 48));
        JButton mainScreenButton = new JButton();
        mainScreenButton.setText("Explore!");
        mainScreenButton.setBounds(250,250, 100, 50);
        mainScreen.setLayout(new GridLayout(2,1));
        
        //Adds Elements to panel
        mainScreen.add(title);
        mainScreen.add(mainScreenButton);
        // Adds panels to Frame
        frame.add(mainScreen);
        
        //Display the window.
        
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}