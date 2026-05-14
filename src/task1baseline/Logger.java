package task1baseline;

public class Logger {
    public static boolean ENABLED = true;

    public static void log(String message) {
        if (ENABLED) {
            System.out.println(message);
        }
    }
}