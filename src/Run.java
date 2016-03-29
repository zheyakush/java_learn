import game.Game;
import game.unit.Abstract;
import game.unit.Builder;
import game.unit.Soldier;

public class Run {
    public static final boolean isDebugMode = true;

    public static void main(String args[]) {

        Game.isDebugMode = isDebugMode;

//        /** Unit 3 */
        Thread myThready1 = new Thread(() -> {
            Abstract soldier = new Soldier();

            soldier.execute("To", 300, 300);
            Game.sleep(5000);
            soldier.execute("To", 300, 0);
            Game.sleep(5000);
            soldier.execute("To", 0, 250);
            soldier.
//            Game.sleep(10000);
//            soldier.execute("To", 300, 150);
//            Game.sleep(10000);
//            soldier.execute("To", 300, 300);
//            Game.sleep(10000);
//            soldier.execute("To", 0, 195);
            try {
                soldier.getCurrentAction().join();
            } catch (InterruptedException e) {
                Game.log(e.getStackTrace().toString());
            }

            Game.log("=== FINISH ===");
        });

        Thread myThready2 = new Thread(() -> {
            Abstract builder = new Builder();

            builder.execute("To", 5, 2);
            Game.sleep(300);
            Game.log(builder.getName() + " - " + builder.getPosition());
            builder.execute("To", 7, 1);
            Game.sleep(300);
            Game.log(builder.getName() + " - " + builder.getPosition());
            builder.execute("To", 9, 2);
            Game.sleep(300);
            Game.log(builder.getName() + " - " + builder.getPosition());
            builder.execute("To", 7, 3);
            Game.sleep(300);
            Game.log(builder.getName() + " - " + builder.getPosition());
            builder.execute("To", 4, 4);
            Game.sleep(300);
            Game.log(builder.getName() + " - " + builder.getPosition());

//            1. create
//            2. goTo(200, 200)
//            3. doSomething()
//            4. goTo(0, 0)


        });

        myThready1.start();
//        myThready2.start();
    }
}
