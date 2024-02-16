package lessons.module_4.lesson_4_10;

import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class ConsoleHandlerFormatter extends Formatter {
    @Override
    public String format(LogRecord record) {
        return "\n"+record.getLoggerName()+": "+record.getMessage()+record.getInstant();
    }
}
