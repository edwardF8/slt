package friedmanprod;


import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Thread.*;

//using jlatexmath we can parse equations

public class GUI implements ActionListener{
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */

    //! Main Screen
    static JButton mainScreenButton;
    static JLabel title;

    //! Subject Choice Panel
    static JPanel subjectButtonPannel;
    static JLabel subjectTextHeader;
    static JButton mathSubjectChoice;
    static JButton readingSubjectChoice;
    static JButton scienceSubjectChoice;
    static JButton historySubjectChoice;


    //Has to be in construcutor so we can use inheret this for Action Listners
    GUI(){
        //Create and set up the window.
        
        //Add the ubiquitous "Hello World" label.        

        JFrame frame = new JFrame("ExporeOffline");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(0,100,800,600);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //! MAIN SCREEN
        title = new JLabel("ExploreOffline",SwingConstants.CENTER); // Title Text
        title.setFont(new Font("Serif", Font.PLAIN, 65));
        title.setBounds(100,100,600,175);
        mainScreenButton = new JButton(); // Opening Button
        mainScreenButton.addActionListener(this);
        mainScreenButton.setBounds(300,350,200,50);
        mainScreenButton.setText("Explore!");
        

        //! SUBJECT OPTION SCREEN, ONLY ALG QUESTIONS R SETUP RN!!!

        //* Images
        ImageIcon mathIcon= new ImageIcon("src/images/math.png");
        ImageIcon readIcon = new ImageIcon("src/images/reading.png");
        ImageIcon hisIcon = new ImageIcon("src/images/socialstudy.png");
        ImageIcon sciIcon = new ImageIcon("src/images/math.png");

        
        //* Buttons Pannel
        
        subjectButtonPannel = new JPanel();
        subjectButtonPannel.setLayout(new GridLayout(2,2,50,50));
        subjectButtonPannel.setBounds(100,200,600,300);
        mathSubjectChoice = new JButton();
        readingSubjectChoice = new JButton();
        scienceSubjectChoice = new JButton();
        historySubjectChoice = new JButton();

        mathSubjectChoice.setText("Math");
        readingSubjectChoice.setText("English/Reading");
        scienceSubjectChoice.setText("Science");
        historySubjectChoice.setText("Social Studies");
        
        mathSubjectChoice.setIcon(mathIcon);
        readingSubjectChoice.setIcon(readIcon);
        scienceSubjectChoice.setIcon(hisIcon);
        historySubjectChoice.setIcon(sciIcon);
        
        
        subjectButtonPannel.add(mathSubjectChoice);
        subjectButtonPannel.add(readingSubjectChoice);
        subjectButtonPannel.add(scienceSubjectChoice);
        subjectButtonPannel.add(historySubjectChoice);
        
        subjectTextHeader = new JLabel();
        subjectTextHeader.setBounds(225,60,350,100);
        subjectTextHeader.setText("Choose a Subject!");
        subjectTextHeader.setFont(new Font("Serif", Font.PLAIN, 45));
        subjectTextHeader.setVisible(false);
        subjectButtonPannel.setVisible(false);



        // *Adds Elements to panel
        
        // *Adds panels to Frame
        frame.add(title);
        frame.add(mainScreenButton);
        frame.add(subjectTextHeader);
        frame.add(subjectButtonPannel);
        //Display the window.
        frame.setVisible(true);
        
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == mainScreenButton){
            title.setVisible(false);
            mainScreenButton.setVisible(false);
            subjectTextHeader.setVisible(true);
            subjectButtonPannel.setVisible(true);
        }
        
    }

    private static ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = GUI.class.getResource(path);
    if (imgURL != null) {
        return new ImageIcon(imgURL);
    } else {            
        System.err.println("Couldn't find file: " + path);
        return null;
    }
    }


}