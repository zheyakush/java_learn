package game.unit;

public class Builder extends Abstract {
    public Builder() {
        this.setName("Builder");
        try {
            this.setSpeed(350);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.setHealth(100);
        this.setX(10);
        this.setY(10);
        this.setArmor(1);
        this.setAttack(1);
        this.setAttackSpeed(1500);
        this.setCanBuild(true);
    }
}
