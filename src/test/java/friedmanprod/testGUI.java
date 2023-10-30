package friedmanprod;

import java.awt.GridLayout;
import javax.swing.*;

public class testGUI {
    static JFrame f;
    testGUI(){
        f = new JFrame("frame"); 
        // set layout of frame 
        f.setLayout(new GridLayout(1,2)); 
        // create checkbox 
        JCheckBox c1 = new JCheckBox(); 
        JCheckBox c2 = new JCheckBox(); 
        c1.setText("Check me!");
        c2.setText("Dont check me!");
        // create a new panel 
        JPanel p = new JPanel(); 
        // add checkbox to panel 
        p.add(c1); 
        p.add(c2);
        // add panel to frame 
        f.add(p); 

        // set the size of frame 
        f.setSize(300, 300); 

        f.show(); 

    }
}
