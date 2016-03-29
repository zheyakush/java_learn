package game;

public class Game {
    public static boolean isDebugMode = false;

    public static void sleep(int milisec) {
        try {
            Thread.sleep(milisec);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return;
        }
    }

    public static void log(String msg){
        if(!isDebugMode){
            return;
        }
        System.out.println(msg);
    }
}
