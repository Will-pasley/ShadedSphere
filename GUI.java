import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JPanel implements ChangeListener, ActionListener {

    //Instance variables
    private Canvas canvas;
    private JSlider xSlider;
    private JSlider ySlider;
    private JSlider zSlider;
    private JLabel  xLabel;
    private JLabel  yLabel;
    private JLabel  zLabel;
    private JLabel  colorLabel;
    private JComboBox<String> colorComboBox;

    //Gui constructor creates sliders, labels, comboBox, panel
    public GUI(Canvas canvas)
    {
        this.canvas = canvas;

        xLabel = new JLabel("Change X:");
        xSlider = new JSlider();
        xSlider.setOrientation(JSlider.HORIZONTAL);
        xSlider.addChangeListener(this);
        xSlider.setMinimum(-canvas.getRadius()*5);
        xSlider.setMaximum(canvas.getRadius()*5);
        xSlider.setValue(-canvas.getRadius()*5);

        yLabel = new JLabel("Change Y:");
        ySlider = new JSlider();
        ySlider.setOrientation(JSlider.HORIZONTAL);
        ySlider.addChangeListener(this);
        ySlider.setMinimum(-canvas.getRadius()*5);
        ySlider.setMaximum(canvas.getRadius()*5);
        ySlider.setValue(-canvas.getRadius()*5);

        zLabel = new JLabel("Change Z:");
        zSlider = new JSlider();
        zSlider.setOrientation(JSlider.HORIZONTAL);
        zSlider.addChangeListener(this);
        zSlider.setMinimum(canvas.getRadius());
        zSlider.setMaximum(canvas.getRadius()*5);
        zSlider.setValue(canvas.getRadius()*5);

        colorLabel = new JLabel("Choose Color:");
        colorComboBox = new JComboBox<>();
        colorComboBox.addItem("Gray");
        colorComboBox.addItem("Red");
        colorComboBox.addItem("Blue");
        colorComboBox.addItem("Green");
        colorComboBox.addItem("Yellow");
        colorComboBox.addItem("Magenta");
        colorComboBox.addItem("Teal");
        colorComboBox.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2, 1, 100));
        panel.setBackground(new Color(240,240,240));
        panel.add(xLabel);
        panel.add(xSlider);
        panel.add(yLabel);
        panel.add(ySlider);
        panel.add(zLabel);
        panel.add(zSlider);
        panel.add(colorLabel);
        panel.add(colorComboBox);
        add(panel);
    }

    //state changed function handles sliders
    @Override
    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == xSlider)
        {
            canvas.getSphere().setViewX(xSlider.getValue());
        }
        if (e.getSource() == ySlider)
        {
            canvas.getSphere().setViewY(ySlider.getValue());
        }
        if(e.getSource() == zSlider)
        {
            canvas.getSphere().setViewZ(zSlider.getValue());
        }
        canvas.repaint();
    }

    //action performed function handles comboBox
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == colorComboBox)
        {
            canvas.getSphere().setColorInput((String) colorComboBox.getSelectedItem());
        }
        canvas.repaint();
    }
}
