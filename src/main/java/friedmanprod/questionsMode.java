package friedmanprod;

import org.scilab.forge.jlatexmath.TeXConstants;
import org.scilab.forge.jlatexmath.TeXFormula;
import org.scilab.forge.jlatexmath.TeXIcon;

import java.awt.color.*;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import org.scilab.forge.jlatexmath.*;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class questionsMode {
    questionsMode(){

    }

    public static void renderLatex(String latex, String option) {
        if(option.equals("Button1")){
            TeXFormula formula = new TeXFormula(latex);
            TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY,15);
            BufferedImage b = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),BufferedImage.TYPE_4BYTE_ABGR);
            icon.paintIcon(GUI.mcOptionA,b.getGraphics(),0,0);
            GUI.mcOptionA.setIcon(icon);
        }else if(option.equals("Button2")){
            TeXFormula formula = new TeXFormula(latex);
            TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY,25);
            BufferedImage b = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),BufferedImage.TYPE_4BYTE_ABGR);
            icon.paintIcon(GUI.mcOptionB,b.getGraphics(),0,0);
            GUI.mcOptionB.setIcon(icon);
        }else if(option.equals("Button3")){
            TeXFormula formula = new TeXFormula(latex);
            TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY,25);
            BufferedImage b = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),BufferedImage.TYPE_4BYTE_ABGR);
            icon.paintIcon(GUI.mcOptionC,b.getGraphics(),0,0);
            GUI.mcOptionC.setIcon(icon);
        }else if(option.equals("Button4")){
            TeXFormula formula = new TeXFormula(latex);
            TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY,25);
            BufferedImage b = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),BufferedImage.TYPE_4BYTE_ABGR);
            icon.paintIcon(GUI.mcOptionD,b.getGraphics(),0,0);
            GUI.mcOptionD.setIcon(icon);
        }else if(option.equals("Question")){
            TeXFormula formula = new TeXFormula(latex);
            TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY,25);
            BufferedImage b = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),BufferedImage.TYPE_4BYTE_ABGR);
            icon.paintIcon(GUI.questionLabel,b.getGraphics(),0,0);
            GUI.questionLabel.setIcon(icon);
        }else if(option.equals("Explanation")){
            TeXFormula formula = new TeXFormula(latex);
            TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY,20);
            BufferedImage b = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),BufferedImage.TYPE_4BYTE_ABGR);
            icon.paintIcon(GUI.feedbackExplanation,b.getGraphics(),0,0);
            GUI.feedbackExplanation.setIcon(icon);
        }else if(option.equals("Correct Answer")){
            TeXFormula formula = new TeXFormula(latex);
            TeXIcon icon = formula.createTeXIcon(TeXConstants.STYLE_DISPLAY,45);
            BufferedImage b = new BufferedImage(icon.getIconWidth(), icon.getIconHeight(),BufferedImage.TYPE_4BYTE_ABGR);
            icon.paintIcon(GUI.feedbackAnswer,b.getGraphics(),0,0);
            GUI.feedbackAnswer.setIcon(icon);
        }
    }

    public static void setButtons(String ques, String op1, String op2, String op3, String op4, String explanation){
        renderLatex(ques,"Question");
        renderLatex(op1, "Button1");
        renderLatex(op2,"Button2");
        renderLatex(op3, "Button3");
        renderLatex(op4, "Button4");
        renderLatex(explanation,"Explanation");
        if(GUI.correctAnswer == 1){
            renderLatex(op1, "Correct Answer");
        }else if(GUI.correctAnswer == 2){
            renderLatex(op2, "Correct Answer");
        }else if(GUI.correctAnswer == 3){
            System.out.println("test");
            renderLatex(op3, "Correct Answer");
        }else if(GUI.correctAnswer == 4){
            renderLatex(op4, "Correct Answer");
        }
    };

    public static void feedback(int optionChose){
        String correctResult = "";
        if(optionChose == GUI.correctAnswer){
            GUI.frame.getContentPane().setBackground(Color.GREEN);
            GUI.amountCorrect++;
            correctResult += "Nice job! The answer is ";
        }else{
            GUI.frame.getContentPane().setBackground(Color.RED);
            correctResult += "That's a good effort, but the correct answer is ";
        }
        if(GUI.correctAnswer == 1){
            correctResult += "A";
        }else if(GUI.correctAnswer == 2){
            correctResult += "B";
        }else if(GUI.correctAnswer == 3){
            correctResult += "C";
        }else if(GUI.correctAnswer == 4){
            correctResult += "D";
        }
        GUI.mcOptions.setVisible(false);
        GUI.questionLabel.setVisible(false);
        GUI.feedbackText.setText(correctResult);
        GUI.feedbackExplanation.setVisible(true);
        GUI.feedbackText.setVisible(true);
        GUI.feedbackAnswer.setVisible(true);
        GUI.nextQueButton.setVisible(true);
        
    }
    
}
