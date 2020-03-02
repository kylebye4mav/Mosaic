package shapes;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Color;

public class FaceTest {

    public static void main(String[] args) {
        
        JFrame frame = new JFrame("FaceTest");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setBounds(0,0,600,600);

        Face face = new Face(0,0,0,0,Color.BLUE, 1);
        frame.add(face);

        frame.setVisible(true);
    }

}