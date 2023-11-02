package friedmanprod;

//! Class processes data, most methods should be private and static to hide data from user
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;


public class dataprocesser{

    dataprocesser(){
        System.out.println("Dataprocessor obj called");
    }

    static String currentSubject;
    static String[] currentTopics = new String[6];


    public static String[] newSubject(String subject){
        if(subject.equals("Math")){
            String[] mathLevelsArray = {"Math Levels","K-2nd Grade", "3rd-5th Grade", "Middle School", "Algebra 1", "Geometry", "Algebra 2 and Trigonometry", "Precalculus", "Calculus"};
            return(mathLevelsArray);
        }else if(subject.equals("English")){
            String[] englishLevelsArray = {"English Levels","K-3rd Grade", "4th-5th Grade", "Middle School", "High School English", "Journalism", "Philosophy", "Creative Language", "College Literature"};
            return(englishLevelsArray);
        }else if(subject.equals("Science")){
            String[] scienceLevelsArray = {"Science Levels","Beginner Science Concepts","Beginner Bio/Chem/Physics", "Biology", "Chemistry", "Physics", "Material Sciences", "Astrophysics", "Geology"};
            return(scienceLevelsArray);
        }else if(subject.equals("History")){
            String[] historyLevelsArray = {"Social Studies Levels","Beginner Social Studies concepts", "American History", "Ancient World History", "Modern World History", "Geography", "Economics", "Government","Law"};
            return(historyLevelsArray);
        }else{
            System.out.println("Subject not found, newSubject not working");
        }
        return(null);
    }

    public static String[] newLevels(String level, String subject){
        String[] levelArray = new String[7];
        currentSubject = subject;
        // Example list = 
        //if(subject.equals())
        if(subject.equals("Math")){
            switch(level){
                case("K-2nd Grade"):
                    break;
                case("3rd-5th Grade"):
                    break;
                case("Middle School"):
                    break;
                case("Algebra 1"):
                    String[] list = {"Algebra Fundamentals", "Solving Equations", "Functions","Quadratics", "Exponents&Radicals", "Graphs"};
                    currentTopics = list.clone();
                    return(list);    
                case("Geometry"):
                    break;
                case("Algebra 2 and Trigonometry"):
                    break;
                case("Precalculus"):
                    break;
                case("Calculus"):
                    break;
                }
        }else if(subject.equals("English/Reading")){
            switch(level){
                case("K-3rd Grade"):
                    break;
                case("4th-5th Grade"):
                    break;
                case("Middle School"):
                    break;
                case("High School English"):
                    break;
                case("Journalism"):
                    break;      
                case("Philosophy"):
                    break;
                case("Creative Language"):
                    break;
                case("College Literature"):
                    break;
            }
        }else if(subject.equals("Science")){
            switch(level){
                case("Beginner Science Concepts"):
                    break;
                case("Beginner Bio/Chem/Physics"):
                    break;
                case("Biology"):
                    break;
                case("Chemistry"):
                    break;
                case("Physics"):
                    String[] list = {"Kinematics&Motion", "Newtown's Laws&Forces", "Work&Energy", "Impulse&Momentum","Torque and Angular momentum", "Electricity and Magnetism"};
                    currentTopics = list.clone();
                    return(list);    
                case("Material Sciences"):
                    break;
                case("Astrophysics"):
                    break;
                case("Geology"):
                    break;
            }
        }else if(subject.equals("History")){
            switch(level){
                case("Beginner Social Studies concepts"):
                    break;
                case("American History"):
                    break;
                case("Ancient World History"):
                    break;
                case("Modern World History"):
                    break;
                case("Geography"):
                    break;      
                case("Economics"):
                    break;
                case("Government"):
                    break;
                case("Law"):
                    break;
            }
        }
        return(levelArray);
        }

    
//! CHANGE TO STRING AFTER
    static ArrayList<ArrayList<String>> questionList ;
    public static void nextQuestion(){
        if(GUI.currentQuestionCount < GUI.questionCount){
            ArrayList<String> curr = questionList.get(GUI.currentQuestionCount);
            questionsMode.setButtons(curr.get(0), curr.get(1), curr.get(2), curr.get(3), curr.get(4), curr.get(6));
            GUI.correctAnswer = Integer.parseInt(curr.get(5));
            GUI.currentQuestionCount++;
            GUI.mcOptions.setVisible(true);
            GUI.questionLabel.setVisible(true);
            GUI.frame.getContentPane().setBackground(new Color(238,238,238));
        }else{
            GUI.finalResultsPanel.setVisible(false);
            GUI.finalL2.setText("   You got " + GUI.amountCorrect  +" questions right out of " + GUI.questionCount + "   ");
            GUI.finalResultsPanel.setVisible(true);
            GUI.mcOptions.setVisible(false);
            GUI.questionLabel.setVisible(false);
            GUI.frame.getContentPane().setBackground(new Color(238,238,238));
        }
    }



    public static void questionSetup(int numQuestions,boolean topicChoice[]){
        GUI.amountCorrect = 0;
        GUI.questionCount = numQuestions;
        questionList = arraySetup(topicChoice);
        nextQuestion();

    }

    public static ArrayList<ArrayList<String>> arraySetup(boolean topicChoice[]){
        ArrayList<ArrayList<String>> ql = new ArrayList<ArrayList<String>>();
        // Questionable use of List, figure out better way
        for(int i = 0;i<topicChoice.length;i++){
            if(topicChoice[i] == true){
                String[][] arrayToAdd = generateArray(currentTopics[i]);
                for(int c = 0; c<arrayToAdd.length;c++){
                    ql.add(new ArrayList<String>());
                    for(int b =0; b<arrayToAdd[c].length;b++){
                        ql.get(c).add(arrayToAdd[c][b]);
                    }
                }
            }
        }
        Collections.shuffle(ql);
        return ql;
    }

    //ARRAYLIST DUMMY
    
    /* 
     * Take in binarry arry
     * find what topic we are curr on
     * combine all the elments into a 2d array
     * make temp string array
     * delete elements every itreation and store element in 2d arrry
     * 2d array intlized off amount of values, and amount per question
     * send array back to question setup
     */

    
    public static String[][] generateArray(String s){
        String noSpace = s.replaceAll(" ", "_");
        String csvFile = "src/data/" + noSpace + ".csv"; 
        try {
            FileReader fileReader = new FileReader(csvFile);
            CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT);
            List<CSVRecord> csvRecords = csvParser.getRecords();
            int numRows = csvRecords.size();
            int numCols = csvRecords.get(0).size();
            String[][] data = new String[numRows][numCols];
            for (int row = 0; row < numRows; row++) {
                for (int col = 0; col < numCols; col++) {
                    data[row][col] = csvRecords.get(row).get(col);
                }
            } 
            csvParser.close();
            return(data);
        } catch (IOException e) {
            e.printStackTrace();
        } 
        System.out.println("dataprocesser gen array returned null");
        return null;
    }

    

}