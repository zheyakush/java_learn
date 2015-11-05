import game.unit.Abstract;
import game.unit.Unit1;
import game.unit.Unit2;
import game.unit.Unit3;

import java.awt.*;
import javax.swing.*;

/**
 * Custom Drawing Code Template
 */
// Graphics application extends JFrame
public class Frame {
    // Constants
    public static final int CANVAS_WIDTH = 640;
    public static final int CANVAS_HEIGHT = 480;

    public static void main(String[] args) {
        new Frame();
    }

    /**
     * Constructor to set up the GUI components
     */
    public Frame() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
                JFrame frame = new JFrame("Testing");
                frame.setSize(CANVAS_WIDTH, CANVAS_HEIGHT);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new GridLayout(0, 2));
                frame.add(new DrawCanvas());
//                frame.add(new Unit2(100, 100));
                frame.add(new Unit3(100, 100));

                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.repaint();
            }
        });
    }

    /**
     * Define a inner class called DrawCanvas which is a JPanel used for custom drawing
     */
    private class DrawCanvas extends JPanel {
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            setBackground(Color.darkGray);
        }
    }
}