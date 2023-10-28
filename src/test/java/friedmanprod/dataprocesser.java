package friedmanprod;

//! Class processes data, most methods should be private and static to hide data from user

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class dataprocesser{

    dataprocesser(){
        System.out.println("Dataprocessor obj called");
    }

    public static String[] newSubject(String subject){
        String[] subjectArray = new String[9];
        if(subject.equals("Math")){
            String[] mathLevelsArray = {"Math Levels","K-2nd Grade", "3rd-5th Grade", "Middle School", "Algebra 1", "Geometry", "Algebra 2 and Trigonometry", "Precalculus", "Calculus"};
            subjectArray = mathLevelsArray.clone();
        }else if(subject.equals("English")){
            String[] englishLevelsArray = {"English Levels","K-3rd Grade", "4th-5th Grade", "Middle School", "High School English", "Journalism", "Philosophy", "Creative Language", "College Literature"};
            subjectArray = englishLevelsArray.clone();
        }else if(subject.equals("Sci")){
            String[] scienceLevelsArray = {"Science Levels","Beginner Science Concepts","Beginner Bio/Chem/Physics", "Biology", "Chemistry", "Physics", "Material Sciences", "Astrophysics", "Geology"};
            subjectArray = scienceLevelsArray.clone();
        }else if(subject.equals("History")){
            String[] historyLevelsArray = {"Social Studies Levels","Beginner Social Studies concepts", "American History", "Ancient World History", "Modern World History", "Geography", "Economics", "Government","Law"};
            subjectArray = historyLevelsArray.clone();
        }else{
            System.out.println("Subject not found, line 151 method not runnning");
        }
        return(subjectArray);
    }

    
    public static String[] newLevel(String level, String subject){
        String[] levelArray = new String[7];
        // Example list = {"Algebra Topics", "Solving Equations and Inequalties", "Factoring", "Polynomials", "Number Sets/ Properties/Other"}
        //if(subject.equals())
        if(subject.equals("Math")){
            switch(level){
                case("Algebra"):
                    break;
                case("K-2nd Grade"):
                    break;
                case("3rd-5th Grade"):
                    break;
                case("Middle School"):
                    break;
                case("Algebra 1"):
                break;


            }else if(level.equals("Geometry")){

            }else if(level.equals("Algebra 2 and Trigonometry")){

            }else if(level.equals("Precalculus")){

            }else if(level.equals("Calculus")){

            }
    //String[] englishLevelsArray = {"English Levels","K-3rd Grade", "4th-5th Grade", "Middle School", "High School English", "Journalism", "Philosophy", "Creative Language", "College Literature"};

        }else if(subject.equals("English/Reading")){
            if(level.equals("K-3rd Grade")){

            }else if(level.equals("4th-5th Grade")){

            }else if(level.equals("Middle School")){

            }else if(level.equals("High School")){

            }else if(level.equals("Journalism")){

            }else if(level.equals("Philosophy")){

            }else if(level.equals("Creative Language")){

            }else if(level.equals("College Literature")){

            }
        }else if(subject.equals("Science")){
                switch(subject){
                    case("hello"):

                        break;
                    case()
                }
        }
        return(levelArray);
    
    return(levelArray);
    }
    
}
