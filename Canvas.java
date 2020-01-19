import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class Canvas extends JPanel {

    private Sphere sphere;
    private int radius;

    //Canvas constructor makes a sphere and a radius
    public Canvas()
    {
        radius = 200;
        setPreferredSize(new Dimension(radius*2 + 100,radius*2+100));
        sphere = new Sphere(radius);
    }

    //Paints the buffered image sphere
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        BufferedImage sphereImage = sphere.getSphere();
        g2d.drawImage(sphereImage, 50, 50,null);
    }

    //sphere getter
    public Sphere getSphere()
    {
        return this.sphere;
    }

    //radius getter
    public int getRadius()
    {
        return radius;
    }
}
