package singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

class Logger {
    private static Logger instance;
    private static final Object lock = new Object();
    private PrintWriter writer;

    Logger() {
        try {
            writer = new PrintWriter(new FileWriter("app.log", true), true);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new Logger();
                }

            }
        }
        return instance;
    }

    public void log(String message) {
        writer.println(message);
    }

}

public class SingletonProblem_1 {
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        logger1.log("This is first Message");
        Logger logger2 = Logger.getInstance();
        logger2.log("This is second Message");
        System.out.println(logger1 == logger2);
    }
}
