package lessons.module_4.lesson_4_10;

import java.time.Instant;
import java.util.logging.Filter;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class ConsoleHandlerFilter implements Filter {
    @Override
    public boolean isLoggable(LogRecord record) {
        return record.getInstant().isBefore(Instant.now()) && record.getLevel().intValue() >= Level.WARNING.intValue();
    }
}
