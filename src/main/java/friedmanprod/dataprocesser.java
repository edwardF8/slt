package friedmanprod;

//! Class processes data, most methods should be private and static to hide data from user

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.util.ArrayList;

public class dataprocesser{

    dataprocesser(){
        System.out.println("Dataprocessor obj called");
    }

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
                    System.out.println("Teset");
                    String[] list = {"Algebra Fundamentals", "Solving Equations", "Functions","Quadratics", "Exponents/Radicals", "Graphs"};
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
                    String[] list = {"Kinematics/Motion", "Newtown's Laws/Forces", "Work/Energy", "Impulse/Momentum","Torque and Angular momentum", "Electricity and Magnetism"};
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
    
}

//go thru arraylisy, for each loop 
// TODO For topic question functions, you make a  list
public static void questionSetup(){

}