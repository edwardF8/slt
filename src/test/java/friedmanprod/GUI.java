// TODO Make back button and text for level choice page, set allat up and test, only for math rn



package friedmanprod;

import friedmanprod.dataprocesser;
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



    static String currentSubject;
    static String currentLevel;
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
    
    // ! Grade choice
    static JPanel gradeChoicePanel;
    static JButton level1Button;
    static JButton level2Button;
    static JButton level3Button;
    static JButton level4Button;
    static JButton level5Button;
    static JButton level6Button;
    static JButton level7Button;
    static JButton level8Button;
    static JButton exitLevelButton;
    static JLabel gradeChoiceText;
    static JFrame frame;

    //Has to be in construcutor so we can use inheret this for Action Listners
    GUI(){
        //Create and set up the window.
        
        //Add the ubiquitous "Hello World" label.        

        frame = new JFrame("ExporeOffline");
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
        
        /* 
        mathSubjectChoice.setIcon(mathIcon);
        readingSubjectChoice.setIcon(readIcon);
        scienceSubjectChoice.setIcon(hisIcon);
        historySubjectChoice.setIcon(sciIcon);
        */
        mathSubjectChoice.addActionListener(this);
        readingSubjectChoice.addActionListener(this);
        scienceSubjectChoice.addActionListener(this);
        historySubjectChoice.addActionListener(this);
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


        //! Grade choice
        gradeChoicePanel = new JPanel();
        level1Button = new JButton();
        level2Button = new JButton();
        level3Button = new JButton();
        level4Button = new JButton();
        level5Button= new JButton();
        level6Button = new JButton();
        level7Button = new JButton();
        level8Button = new JButton();
        exitLevelButton = new JButton();
        gradeChoiceText = new JLabel();

        gradeChoicePanel.setLayout(new GridLayout(4, 2, 50, 50));
        gradeChoicePanel.add(level1Button);
        gradeChoicePanel.add(level2Button);
        gradeChoicePanel.add(level3Button);
        gradeChoicePanel.add(level4Button);
        gradeChoicePanel.add(level5Button);
        gradeChoicePanel.add(level6Button);
        gradeChoicePanel.add(level7Button);
        gradeChoicePanel.add(level8Button);
        // TODO Make back button, text pannel, add all the text to this joint
        gradeChoicePanel.setBounds(100,150,600,300);
         //450 + 50 500 550
        gradeChoicePanel.setVisible(false);
        gradeChoiceText.setVisible(false);
        gradeChoiceText.setBounds(225,50,350,75);
        gradeChoiceText.setFont(new Font("Serif", Font.PLAIN, 45));
        exitLevelButton.setText("Back");
        exitLevelButton.addActionListener(this);
        exitLevelButton.setBounds(350,500,100,50);
        exitLevelButton.setVisible(false);


        //TODO Topics
        // Each button has a index, capture that index and since you already have the current Subject var
        // run it thru a process in dataprocesser and do 6 topics for each question
        // store in lists


        //gradeChoicePanel.setBounds();

        // *Adds Elements to panel
        
        // *Adds panels to Frame
        frame.add(title);
        frame.add(mainScreenButton);
        frame.add(subjectTextHeader);
        frame.add(subjectButtonPannel);

        frame.add(gradeChoicePanel);
        frame.add(gradeChoiceText);
        frame.add(exitLevelButton);
        //Display the window.
        frame.setVisible(true);
        
    }

    public static void subjectSetup(String subject){
        //set up template pannels
        gradeChoiceText.setBounds(225,50,350,75);
        gradeChoiceText.setFont(new Font("Serif", Font.PLAIN, 45));
        String[] levelArray = dataprocesser.newSubject(subject);
        String subjectText = levelArray[0];
        //uses lists to set each part depending on question
        level1Button.setText(levelArray[1]);
        level2Button.setText(levelArray[2]);
        level3Button.setText(levelArray[3]);
        level4Button.setText(levelArray[4]);
        level5Button.setText(levelArray[5]);
        level6Button.setText(levelArray[6]);
        level7Button.setText(levelArray[7]);
        level8Button.setText(levelArray[8]);
        gradeChoiceText.setText(subjectText);
        currentSubject = subject;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == mainScreenButton){
            title.setVisible(false);
            mainScreenButton.setVisible(false);
            subjectTextHeader.setVisible(true);
            subjectButtonPannel.setVisible(true);
        }else if(e.getSource() == mathSubjectChoice){
            subjectTextHeader.setVisible(false);
            subjectButtonPannel.setVisible(false);
            subjectSetup("Math");
            gradeChoicePanel.setVisible(true);
            gradeChoiceText.setVisible(true);
            exitLevelButton.setVisible(true);
        }else if(e.getSource() == readingSubjectChoice){
            subjectTextHeader.setVisible(false);
            subjectButtonPannel.setVisible(false);
            subjectSetup("English");
            gradeChoicePanel.setVisible(true);
            gradeChoiceText.setVisible(true);
            exitLevelButton.setVisible(true);
        }else if(e.getSource() == scienceSubjectChoice){
            subjectTextHeader.setVisible(false);
            subjectButtonPannel.setVisible(false);
            subjectSetup("Sci");
            gradeChoicePanel.setVisible(true);
            gradeChoiceText.setVisible(true);
            exitLevelButton.setVisible(true);
        }else if(e.getSource() == historySubjectChoice){
            subjectTextHeader.setVisible(false);
            subjectButtonPannel.setVisible(false);
            subjectSetup("History");
            gradeChoiceText.setFont(new Font("Serif", Font.PLAIN, 35));
            gradeChoicePanel.setVisible(true);
            gradeChoiceText.setVisible(true);
            exitLevelButton.setVisible(true);
        }else if(e.getSource() == exitLevelButton){
            subjectTextHeader.setVisible(true);
            subjectButtonPannel.setVisible(true);

            gradeChoicePanel.setVisible(false);
            gradeChoiceText.setVisible(false);
            exitLevelButton.setVisible(false);
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