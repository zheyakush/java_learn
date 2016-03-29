package game.unit;

import game.Game;
import game.unit.Command.Move.To;

import java.util.LinkedList;
import java.util.Queue;

public abstract class Abstract {
    private String name = "";
    private int health;
    private int armor;
    private int attack;
    private int attackSpeed;
    private boolean canBuild;

    private int x = 0;
    private int y = 0;
    private double speed = 0;
    private game.unit.Command.Abstract currentAction = null;
    private Queue<game.unit.Command.Abstract> actionQueue = new LinkedList<>();

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public boolean getCanBuild() {
        return canBuild;
    }

    public void setCanBuild(boolean canBuild) {
        this.canBuild = canBuild;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) throws Exception {
        int maxSpeedLimit = 601;
        if(100 < speed && speed < 600){
            this.speed = maxSpeedLimit - speed;
        } else {
            throw new Exception("wrong speed value.");
        }
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getPosition() {
        return this.getX() + ";" + this.getY();
    }

    public void execute(String commandName, int newX, int newY) {
        To action = null;
        switch (commandName) {
            case "To":
                action = new To(this, newX, newY);
                break;
        }

        if (this.getCurrentAction() != null && !this.getCurrentAction().isInterrupted()) {
            Game.log("Interapted on position " + this.getPosition());
            this.getCurrentAction().cancel();
        }

        actionQueue.add(action);
        while (!actionQueue.isEmpty()) {
            this.setCurrentAction(actionQueue.poll());
            this.getCurrentAction().start();
        }
    }

    public game.unit.Command.Abstract getCurrentAction() {
        return currentAction;
    }

    public void setCurrentAction(game.unit.Command.Abstract currentAction) {
        this.currentAction = currentAction;
    }
}