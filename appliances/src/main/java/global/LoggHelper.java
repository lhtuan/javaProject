package global;

import java.util.logging.Logger;
public class LoggHelper {
	private static Logger logger =Logger.getLogger(LoggHelper.class.getName());
	public static void info(String log)
	{
		logger.info(log);
	}
	public static void waring(String log)
	{
		logger.warning(log);
	}
}
