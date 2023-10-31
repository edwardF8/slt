// TODO Make back button and text for level choice page, set allat up and test, only for math rn



package friedmanprod;

import friedmanprod.dataprocesser;
import java.io.File;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.lang.Thread.*;
import java.util.Arrays;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

//using jlatexmath we can parse equations

public class GUI implements ActionListener, ItemListener,ChangeListener {




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
    static JButton level1Button, level2Button, level3Button, level4Button,level5Button, level6Button,level7Button,level8Button;
    static JButton exitLevelButton;
    static JLabel gradeChoiceText;
    static JFrame frame;

    // ! Topic Choce
    static JPanel topicChoicePanel;
    static JCheckBox t1CB, t2CB,t3CB,t4CB,t5CB,t6CB;
    static JLabel topicLabel;
    static JButton topicBackButton, topicSubmitButton;
    static JPanel numQuestionPanel;
    static JLabel numQuestionLabel;
    static JSlider numQuestionSlider;

    //! Setup screen

    //Has to be in construcutor so we can use inheret this for Action Listners
    /**
     * 
     */
    GUI(){
        //Fraem setup.
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
        

        //! SUBJECT OPTION SCREEN

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

        level1Button.addActionListener(this);
        level2Button.addActionListener(this);
        level3Button.addActionListener(this);
        level4Button.addActionListener(this);
        level5Button.addActionListener(this);
        level6Button.addActionListener(this);
        level7Button.addActionListener(this);
        level8Button.addActionListener(this);


        gradeChoicePanel.setLayout(new GridLayout(4, 2, 50, 50));
        gradeChoicePanel.add(level1Button);
        gradeChoicePanel.add(level2Button);
        gradeChoicePanel.add(level3Button);
        gradeChoicePanel.add(level4Button);
        gradeChoicePanel.add(level5Button);
        gradeChoicePanel.add(level6Button);
        gradeChoicePanel.add(level7Button);
        gradeChoicePanel.add(level8Button);
        gradeChoicePanel.setBounds(100,150,600,300);
        gradeChoicePanel.setVisible(false);
        gradeChoiceText.setVisible(false);
        gradeChoiceText.setBounds(225,50,350,75);
        gradeChoiceText.setFont(new Font("Serif", Font.PLAIN, 45));
        exitLevelButton.setText("Back");
        exitLevelButton.addActionListener(this);
        exitLevelButton.setBounds(350,500,100,50);
        exitLevelButton.setVisible(false);


        //! Topics choice page
        topicChoicePanel = new JPanel();
        topicLabel = new JLabel();
        topicBackButton = new JButton();
        topicSubmitButton = new JButton();
        t1CB = new JCheckBox();
        t2CB = new JCheckBox();
        t3CB = new JCheckBox();
        t4CB = new JCheckBox();
        t5CB = new JCheckBox();
        t6CB = new JCheckBox();

        topicLabel.setBounds(225,25,600,100);
        topicLabel.setFont(new Font("Serif", Font.PLAIN, 35));

        topicChoicePanel.setLayout(new GridLayout(2,3,40,60));
        topicChoicePanel.setBounds(50,125,700,250);

        numQuestionLabel = new JLabel();
        numQuestionPanel = new JPanel();
        numQuestionSlider = new JSlider(0,1);
        numQuestionSlider.setMajorTickSpacing(5);
        numQuestionSlider.setMinorTickSpacing(1);


        numQuestionPanel.setBounds(200,385,400,100);
        numQuestionPanel.setLayout(new GridLayout(2, 1, 0, 15));
        
        numQuestionLabel.setText("Amount of Questions: 0");
        numQuestionLabel.setFont(new Font("Serif", Font.PLAIN, 35));
        numQuestionSlider.setPaintTrack(true);
        numQuestionSlider.setPaintTicks(true);
        numQuestionSlider.setPaintLabels(true);
        numQuestionSlider.addChangeListener(this);
        numQuestionPanel.add(numQuestionLabel);
        numQuestionPanel.add(numQuestionSlider);
        numQuestionPanel.setVisible(false);

        //500 - 385 = 115
        
        topicBackButton.setText("Back");
        topicBackButton.setBounds(100,500,250,50);

        topicSubmitButton.setText("Select Topics");
        topicSubmitButton.setBounds(450,500,250,50);


        t1CB.addItemListener(this);
        t2CB.addItemListener(this);
        t3CB.addItemListener(this);
        t4CB.addItemListener(this);
        t5CB.addItemListener(this);
        t6CB.addItemListener(this);
        topicBackButton.addActionListener(this);
        topicSubmitButton.addActionListener(this);
        
        topicChoicePanel.add(t1CB);
        topicChoicePanel.add(t2CB);
        topicChoicePanel.add(t3CB);
        topicChoicePanel.add(t4CB);
        topicChoicePanel.add(t5CB);
        topicChoicePanel.add(t6CB);

        topicChoicePanel.setVisible(false);
        topicBackButton.setVisible(false);
        topicLabel.setVisible(false);
        topicSubmitButton.setVisible(false);
        


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

        frame.add(topicBackButton);
        frame.add(topicChoicePanel);
        frame.add(topicLabel);
        frame.add(topicSubmitButton);
        frame.add(numQuestionPanel);
        //Display the window.
        frame.setVisible(true);
        
    }
    //* Item State Changed @remind
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
    static boolean[] topicCheckedList = {false,false,false,false,false,false};

    
    public static void levelSetup(String subject, String level){
        Arrays.fill(topicCheckedList, false);
        String[] topicArray = dataprocesser.newLevels(level, subject);
        numQuestionSlider.setMaximum(1);
        t1CB.setText(topicArray[0]);
        t2CB.setText(topicArray[1]);
        t3CB.setText(topicArray[2]);
        t4CB.setText(topicArray[3]);
        t5CB.setText(topicArray[4]);
        t6CB.setText(topicArray[5]);
        topicLabel.setText(level + "Topics");
    }

    


    //! FOR CHECKBOXES
    static int maxValue = 0;
    public void itemStateChanged(ItemEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == t1CB){
            if(topicCheckedList[0] == true){
                maxValue -=20;
                topicCheckedList[0] = false;
            }else{
                System.out.print(topicCheckedList[0]);
                maxValue += 20;
                topicCheckedList[0] = true;
            }
        }else if(e.getSource() == t2CB){
            if(topicCheckedList[1] == true){
                System.out.print(topicCheckedList[1]);
                maxValue -=20;
                topicCheckedList[1] = false;
            }else{
                maxValue += 20;
                topicCheckedList[1] = true;
            }
        }else if(e.getSource() == t3CB){
            if(topicCheckedList[2] == true){
                maxValue -=20;
                topicCheckedList[2] = false;
            }else{
                maxValue += 20;
                topicCheckedList[2] = true;
            }
        }else if(e.getSource() == t4CB){
            if(topicCheckedList[3] == true){
                maxValue -=20;
                topicCheckedList[3] = false;
            }else{
                maxValue += 20;
                topicCheckedList[3] = true;
            }
        }else if(e.getSource() == t5CB){
            if(topicCheckedList[4] == true){
                maxValue -=20;
                topicCheckedList[4] = false;
            }else{
                maxValue += 20;
                topicCheckedList[4] = true;
            }
        }else if(e.getSource() == t6CB){
            if(topicCheckedList[5] == true){
                maxValue -= 20;
                topicCheckedList[5] = false;
            }else{
                maxValue += 20;
                topicCheckedList[5] = true;
            }
        }
        System.out.println(maxValue);
        numQuestionSlider.setMinimum(0);
        numQuestionSlider.setMaximum(maxValue);
    }

    public void stateChanged(ChangeEvent e) {
        if(e.getSource() == numQuestionSlider){
            numQuestionLabel.setText("Amount of Questions: " + numQuestionSlider.getValue());
        }
    }

    //! FOR BUTTONS
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
            subjectSetup("Science");
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
        }else if(e.getSource() == level1Button){
            levelSetup(currentSubject, level1Button.getText());
            gradeChoicePanel.setVisible(false);
            gradeChoiceText.setVisible(false);
            exitLevelButton.setVisible(false);
            numQuestionPanel.setVisible(true);

            topicBackButton.setVisible(true);
            topicChoicePanel.setVisible(true);
            topicLabel.setVisible(true);
            topicSubmitButton.setVisible(true);
        }else if(e.getSource() == level2Button){
            levelSetup(currentSubject, level2Button.getText());
            gradeChoicePanel.setVisible(false);
            gradeChoiceText.setVisible(false);
            exitLevelButton.setVisible(false);
            numQuestionPanel.setVisible(true);

            topicBackButton.setVisible(true);
            topicChoicePanel.setVisible(true);
            topicLabel.setVisible(true);
            topicSubmitButton.setVisible(true);

        }else if(e.getSource() == level3Button){
            levelSetup(currentSubject, level3Button.getText());
            gradeChoicePanel.setVisible(false);
            gradeChoiceText.setVisible(false);
            exitLevelButton.setVisible(false);

            numQuestionPanel.setVisible(true);
            topicBackButton.setVisible(true);
            topicChoicePanel.setVisible(true);
            topicLabel.setVisible(true);
            topicSubmitButton.setVisible(true);
        }else if(e.getSource() == level4Button){
            levelSetup(currentSubject, level4Button.getText());
            gradeChoicePanel.setVisible(false);
            gradeChoiceText.setVisible(false);
            exitLevelButton.setVisible(false);
            numQuestionPanel.setVisible(true);

            topicBackButton.setVisible(true);
            topicChoicePanel.setVisible(true);
            topicLabel.setVisible(true);
            topicSubmitButton.setVisible(true);
        }else if(e.getSource() == level5Button){
            levelSetup(currentSubject, level5Button.getText());
            gradeChoicePanel.setVisible(false);
            gradeChoiceText.setVisible(false);
            exitLevelButton.setVisible(false);
            numQuestionPanel.setVisible(true);

            topicBackButton.setVisible(true);
            topicChoicePanel.setVisible(true);
            topicSubmitButton.setVisible(true);
            topicLabel.setVisible(true);
        }else if(e.getSource() == level6Button){
            levelSetup(currentSubject, level6Button.getText());
            gradeChoicePanel.setVisible(false);
            gradeChoiceText.setVisible(false);
            exitLevelButton.setVisible(false);
            numQuestionPanel.setVisible(true);

            topicBackButton.setVisible(true);
            topicSubmitButton.setVisible(true);
            topicChoicePanel.setVisible(true);
            topicLabel.setVisible(true);
        }else if(e.getSource() == topicBackButton){
            gradeChoicePanel.setVisible(true);
            gradeChoiceText.setVisible(true);
            exitLevelButton.setVisible(true);
            numQuestionPanel.setVisible(false);

            topicBackButton.setVisible(false);
            topicSubmitButton.setVisible(false);
            topicChoicePanel.setVisible(false);
            topicLabel.setVisible(false);
        }else if(e.getSource() == topicSubmitButton){
            topicBackButton.setVisible(false);
            topicChoicePanel.setVisible(false);
            topicLabel.setVisible(false);
            topicSubmitButton.setVisible(false);
            numQuestionPanel.setVisible(false);
            int num = numQuestionSlider.getValue();
        }
        else{

        }
        
    }
    /* unused method
    private static ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = GUI.class.getResource(path);
    if (imgURL != null) {
        return new ImageIcon(imgURL);
    } else {            
        System.err.println("Couldn't find file: " + path);
        return null;
    }
    }
    */

    

    }