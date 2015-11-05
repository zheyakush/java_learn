import game.unit.Unit2;
import game.unit.Unit3;

import javax.swing.*;
import java.awt.*;
import java.awt.Frame;

/**
 * Custom Drawing Code Template
 */
// Graphics application extends JFrame
public class App extends JFrame {
    private static final int CANVAS_SIZE = 600;
    private JPanel canvas;

    /** Constructor to set up the GUI components */
    public App() {
        Unit2 unit = new Unit2(canvas, 100, 100);
        canvas = unit.draw();
//        canvas.setPreferredSize(new Dimension(CANVAS_SIZE, CANVAS_SIZE));
        this.setSize(CANVAS_SIZE, CANVAS_SIZE);
        this.setContentPane(canvas);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Test drawImage()");
        this.setVisible(true);
    }

    /** The entry main method */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
    }
}