import entity.Product;
import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * @author: rain
 * @date: 2019-3-23 18:50
 * @description:
 */
public class Log4JTest {
    private static Logger logger = Logger.getLogger(Log4JTest.class);

    @Test
    public void testLog4J() {
        // 不是被日志记录器控制的打印不会被按照格式打印
        // System.out.println("This is println message.");
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
    }
}
