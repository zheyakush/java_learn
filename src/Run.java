import game.unit.Abstract;
import game.unit.Unit1;

public class Run {
    // @todo: Have to implement smart multi-threading
    public static void main(String args[]) throws InterruptedException {

        /** Unit 3 */
        Thread myThready1 = new Thread(() -> {
            Abstract unit1 = new Unit1();
            unit1.setName("Unit1");
            unit1.setSpeed(500);
            unit1.setX(5);
            unit1.setY(5);
            try {
                unit1.execute("To", 5, 2);
                Thread.sleep(1000);
                unit1.execute("To", 7, 1);
                Thread.sleep(1000);
                unit1.execute("To", 9, 2);
                Thread.sleep(1000);
                unit1.execute("To", 7, 3);
                Thread.sleep(1000);
                unit1.execute("To", 5, 5);
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        Thread myThready2 = new Thread(() -> {
            Abstract unit2 = new Unit1();
            unit2.setName("Unit2");
            unit2.setSpeed(1000);
            unit2.setX(4);
            unit2.setY(4);

            try {
                unit2.execute("To", 5, 2);
                Thread.sleep(1000);
                unit2.execute("To", 7, 1);
                Thread.sleep(300);
                unit2.execute("To", 9, 2);
                Thread.sleep(300);
                unit2.execute("To", 7, 3);
                Thread.sleep(300);
                unit2.execute("To", 4, 4);
                Thread.sleep(300);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        });

        myThready1.start();
        myThready2.start();
    }
}
