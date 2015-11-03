package game.unit;

import game.unit.Command.Move.To;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Abstract {
    private String name = "";
    private double x = 0;
    private double y = 0;
    private double speed = 0;
    private game.unit.Command.Abstract currentAction = null;
    private Queue<game.unit.Command.Abstract> actionQueue = new LinkedList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
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

    public String getPosition() {
        return this.getX() + " x " + this.getY();
    }

    public void execute(String commandName, int newX, int newY) {
        To action = null;
        switch (commandName) {
            case "To":
                action = new To(this, newX, newY);
                break;
        }

        if (this.currentAction != null && !this.currentAction.isInterrupted()) {
            this.currentAction.cancel();
        }

        actionQueue.add(action);
        while (!actionQueue.isEmpty()) {
            this.currentAction = actionQueue.poll();
            this.currentAction.start();
        }
    }

}