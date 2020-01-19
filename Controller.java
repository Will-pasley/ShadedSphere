import javax.swing.*;
import java.awt.*;

public class Controller extends JFrame {

    //main class instantiates a frame, canvas, and gui
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setSize(new Dimension(600,600));
        Canvas canvas = new Canvas();
        GUI gui = new GUI(canvas);
        frame.setTitle("Shaded Sphere");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.lightGray);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.add(gui, BorderLayout.EAST);
        frame.pack();
        frame.setVisible(true);
    }
}
