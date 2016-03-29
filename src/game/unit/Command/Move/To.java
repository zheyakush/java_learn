package game.unit.Command.Move;

import game.Game;

public class To extends Abstract {

    private game.unit.Abstract unit;
    private int newX = 0;
    private int newY = 0;

    public To(game.unit.Abstract unit, int newX, int newY) {
        this.unit = unit;
        this.newX = newX < 0 ? 0 : newX;
        this.newY = newY < 0 ? 0 : newY;
    }

    public void run() {
        this.move();
    }

    @Override
    public void move() {
        Vector Vector = new Vector();

        Vector.setX(this.newX - this.unit.getX());
        Vector.setY(this.newY - this.unit.getY());
        Vector.calculateLen();

        int steps = Vector.getDelta();
        long delay = Math.round((this.unit.getSpeed() * Vector.getLen()) / Vector.getDelta());
//        Game.log(this.unit.getSpeed() + "*" + Vector.getLen() + "/" + Vector.getDelta());
        while (steps > 0) {
            if (steps == 1) {
                this.unit.setX(this.newX);
                this.unit.setY(this.newY);
            } else {
                int newX = (int) Math.round(this.unit.getX() + (Vector.getLen() / Vector.getDelta()) * Vector.getDeltaX());
                int newY = (int) Math.round(this.unit.getY() + (Vector.getLen() / Vector.getDelta()) * Vector.getDeltaY());
                this.unit.setX(newX < 0 ? this.newX : newX);
                this.unit.setY(newY < 0 ? this.newY : newY);
            }
            try {
//                Game.log(steps + ": " + this.unit.getName() + " - " + this.unit.getPosition());
                Game.log(this.unit.getPosition());
                sleep(delay);
            } catch (InterruptedException e) {
                interrupt();
//                Game.log(e.getMessage());
                return;
            }
            steps--;

        }
//        Game.log(this.unit.getName() + " - " + this.unit.getPosition());

        this.unit.setY(this.unit.getY());
        this.unit.setX(this.unit.getX());
    }

    @Override
    public void cancel() {
        interrupt();
    }

    /**
     * Realizes way by which moves object
     */
    protected class Vector {
        double x = 0;
        double y = 0;
        double len = 0;
        double deltaY = 0;
        double deltaX = 0;

        public double getDeltaY() {
            if (this.deltaY == 0) {
                this.setDeltaY(this.getY() / this.getLen());
            }

            return this.deltaY;
        }

        public void setDeltaY(double deltaY) {
            this.deltaY = deltaY;
        }

        public double getDeltaX() {

            if (this.deltaX == 0) {
                this.setDeltaX(this.getX() / this.getLen());
            }

            return this.deltaX;
        }

        public void setDeltaX(double deltaX) {
            this.deltaX = deltaX;
        }

        public double getLen() {
            return len;
        }

        public void setLen(double len) {
            this.len = len;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public double calculateLen() {
            if (this.getLen() == 0) {
                this.setLen(Math.sqrt(this.getX() * this.getX() + this.getY() * this.getY()));
            }

            return this.getLen();
        }

        public int getDelta() {
            return 50;
        }
    }
}
