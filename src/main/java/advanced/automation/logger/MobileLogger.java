package advanced.automation.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;

public class MobileLogger {
    private static Logger logger;

    public static void initLogger(String testName, String fileName) {
        ThreadContext.put("testName", testName);
        ThreadContext.put("fileName", fileName);
        logger = LogManager.getLogger("TestLogger");
        logger.info("Test '" + testName + "' is starting...");
    }

    public static Logger getLogger() {
        return logger;
    }
}
