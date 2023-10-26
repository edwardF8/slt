package friedmanprod;

//! Class processes data, most methods should be private and static to hide data from user

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;


public class Dataprocesser{

    Dataprocesser(){
        System.out.println("Dataprocessor obj called");
    }

    public static String[] newSubject(String subject){
        String[] subjectArray = new String[9];
        if(subject.equals("Math")){
            String[] mathLevelsArray = {"Math Levels","K-2nd Grade", "3rd-5th Grade", "Middle School", "Algebra 1", "Geometry", "Algebra 2 and Trigonometry", "Precalculus", "Calculus"};
            subjectArray = mathLevelsArray.clone();
        }else if(subject.equals("English")){
            String[] englishLevelsArray = {"English Levels","K-3rd Grade", "4th-5th Grade", "Middle School", "9th Grade", "10th Grade", "11th Grade", "12th Grade"};
            subjectArray = englishLevelsArray.clone();
        }else if(subject.equals("Sci")){
            String[] scienceLevelsArray = {"Science Levels","Beginner Science Concepts", "Biology", "Chemistry", "Physics","Beginner Biology/Chem/Physics", "Material Sciences", "Astrophysics", "Geology"};
            subjectArray = scienceLevelsArray.clone();
        }else if(subject.equals("History")){
            String[] historyLevelsArray = {"Social Studies Levels","Beginner Social Studies concepts", "American History", "Ancient World History", "Modern World History", "Geography", "Economics", "Government","Law"};
            subjectArray = historyLevelsArray.clone();
        }else{
            System.out.println("Subject not found, line 151 method not runnning");
        }

        return(subjectArray);
    }
}
