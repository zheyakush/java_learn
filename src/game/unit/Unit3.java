package game.unit;

import javax.swing.*;
import java.awt.*;

public class Unit3 extends JPanel {

    protected int x = 0;
    protected int y = 0;

    public Unit3(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        g2d.setColor(Color.BLUE);       // change the drawing color
        g2d.fillOval(this.x, this.y, 10, 10);

        g2d.dispose();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(10, 10);
    }
}
