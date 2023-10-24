package friedmanprod;

import javax.swing.*;
import javafx.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.Font;   
import java.awt.GridLayout;
import java.awt.event.ActionListener;

//using jlatexmath we can parse equations

public class GUI implements ActionListener{
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */

    static JButton mainScreenButton;
    public static void createAndShowGUI() {
        //Create and set up the window.
        
        //Add the ubiquitous "Hello World" label.        

        JFrame frame = new JFrame("ExporeOffline");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,100,800,600);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //* MAIN SCREEN
        JLabel title = new JLabel("ExploreOffline",SwingConstants.CENTER); // Title Text
        title.setFont(new Font("Serif", Font.PLAIN, 65));
        title.setBounds(100,100,600,175);

        mainScreenButton = new JButton(); // Opening Button
        mainScreenButton.setBounds(300,350,200,50);
        mainScreenButton.setText("Explore!");
        mainScreenButton.addActionListener(this);
        
        // *Adds Elements to panel
        frame.add(title);
        frame.add(mainScreenButton);
        // Adds panels to Frame

        //Display the window.
        
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

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // TODO Auto-generated method stub
        
    }

}