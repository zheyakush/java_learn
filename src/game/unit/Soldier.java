package game.unit;

public class Soldier extends Abstract {
    public Soldier() {
        this.setName("Soldier");
        try {
            this.setSpeed(522);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setHealth(250);
        this.setX(0);
        this.setY(0);
        this.setArmor(10);
        this.setAttack(10);
        this.setAttackSpeed(1000);
        this.setCanBuild(false);
    }
}

