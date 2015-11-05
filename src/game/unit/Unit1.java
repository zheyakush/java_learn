package game.unit;

import javax.swing.*;
import java.awt.*;

public class Unit1 extends Abstract {

    public Unit1() {
        this.name = "U1";
        this.x = 100;
        this.y = 100;
        this.speed = 100;
    }

    public Unit1(JPanel canvas) {
        this.canvas = canvas;
        this.name = "U1";
        this.x = 100;
        this.y = 100;
        this.speed = 100;
    }

    @Override
    public JPanel draw() {
//        Frame.can
        Graphics graphics = this.canvas.getGraphics();
        graphics.setColor(Color.RED);       // change the drawing color
        graphics.fillOval((int) this.getX(), (int) this.getY(), 10, 10);
//        // Printing texts
//        g.setColor(Color.WHITE);
//        g.setFont(new Font("Monospaced", Font.PLAIN, 12));
//        g.drawString(this.getName(), 312, 328);

//        this.canvas.repaint();
//canvas.add(graphics.fillOval((int) this.getX(), (int) this.getY(), 10, 10));
        return this.canvas;
    }
}
