package game.unit;

import javax.swing.*;
import java.awt.*;

public class Unit2 /*extends JPanel*/ {

    protected int x = 0;
    protected int y = 0;
    protected JPanel canvas;

    public Unit2(JPanel canvas, int x, int y) {
        this.canvas = canvas;
        this.x = x;
        this.y = y;
    }

//    @Override
//    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D) g.create();
//
//        g2d.setColor(Color.RED);       // change the drawing color
//        g2d.fillOval(this.x, this.y, 10, 10);
//
//        g2d.dispose();
//    }
//
//    @Override
//    public Dimension getPreferredSize() {
//        return new Dimension(50, 200);
//    }

    public JPanel draw() {
        JPanel cp = new JPanel();
        Graphics g = canvas.getGraphics();
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(Color.RED);       // change the drawing color
        g2d.fillOval(this.x, this.y, 10, 10);

//        canvas.add(cp);

        return cp;
    }
}
