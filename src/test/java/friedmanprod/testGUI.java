package friedmanprod;
import javax.swing.*;
import org.scilab.forge.jlatexmath.*;

public class testGUI {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Create the Swing JFrame
            JFrame frame = new JFrame("LaTeX in Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 300);

            // Create a JMathComponent to display LaTeX content
            JMathComponent mathComponent = new JMathComponent();
            
            // Set the LaTeX content to render
            String latexExpression = "E=mc^2"; // Your LaTeX expression
            
            // Render the LaTeX expression
            mathComponent.setFormula(latexExpression);

            // Add the JMathComponent to the JFrame
            frame.add(mathComponent);

            // Display the JFrame
            frame.setVisible(true);
        });
    }
}