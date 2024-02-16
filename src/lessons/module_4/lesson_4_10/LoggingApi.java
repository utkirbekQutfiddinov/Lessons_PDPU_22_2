package lessons.module_4.lesson_4_10;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.*;

public class LoggingApi {
    private final static Logger logger = Logger.getLogger(LoggingApi.class.getName());

    public static void main(String[] args) throws IOException {

//        LogManager logManager = LogManager.getLogManager();
//
//        logManager.readConfiguration(new FileInputStream("U:\\00. Java\\02. PDP Groups\\BE-22-2\\Lessons_PDPU_22_2\\resources\\log.properties"));
//
//        Logger logger = logManager.getLogger("");
//
//        logger.severe("severe msg");


    }

    private static void fileHandler() throws IOException {
        FileHandler fileHandler = new FileHandler("log.txt", 1024 * 5, 1, true);
        fileHandler.setFormatter(new SimpleFormatter());
        fileHandler.setLevel(Level.SEVERE);


        logger.addHandler(fileHandler);

        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            logger.warning(e.getMessage() + "\n\t" + Arrays.toString(e.getStackTrace()));
        }
    }

    private static void exceptionLogging() {
        try {
            System.out.println(1 / 0);
        } catch (Exception e) {
            logger.warning(e.getMessage() + "\n\t" + Arrays.toString(e.getStackTrace()));
        }
    }

    private static void simpleLogging() {
        /**Logging frameworks:
         * SLf4j
         * Logging API
         * log4j
         */


        // Logger

        //LogRecord

        //Filter

        /**Level
         * OFF
         * SEVERE
         * WARNING
         * INFO
         * CONFIG
         * FINE
         * FINER
         * FINEST
         * ALL
         */

        //Formatter

        //Handler

        /** types of handlers:
         * ConsoleHandler
         * FileHandler
         * MemoryHandler
         * SocketHandler
         * StreamHandler
         */

        //LogManager


//        logger.log(new LogRecord(Level.INFO,"info msg"));
//        logger.log(Level.INFO,"info msg");


        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new ConsoleHandlerFormatter());
        consoleHandler.setFilter(new ConsoleHandlerFilter());


        consoleHandler.setLevel(Level.FINE);


        logger.setUseParentHandlers(false);

        logger.addHandler(consoleHandler);

        logger.info("info msg");
        logger.setLevel(Level.FINE);
        logger.fine("fine msg");
    }
}
