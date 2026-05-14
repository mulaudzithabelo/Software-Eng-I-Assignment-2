package task5optimised;

public class Logger {
    public static boolean ENABLED = true;

    public static void log(String message) {
        if (ENABLED) {
            System.out.println(message);
        }
    }
}