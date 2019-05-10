package com.app.utils;



//import com.app.WebServer.Common;
import java.io.PrintWriter;
import java.io.StringWriter;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

class ErrorLogger{
	
}
class MetricsLog{
	
}
public class Logging {
	static Logger log = Logger.getLogger(Logging.class.getName());
	static Logger errorlog = Logger.getLogger(ErrorLogger.class.getName());
	private String logLevel;

	private Logging(){		
		init();
	}
	public static Logger getInfoLog(){
		return log;
	}
	public static Logger getErrorLog(){
		return errorlog;
	}

	public static void init(){
		PropertyConfigurator.configure(Logging.class.getResourceAsStream("/log4j.properties"));
		LogManager.getRootLogger().setLevel(Level.INFO);		
		Logging.getLogger().fatal("****************************************");
		Logging.getLogger().fatal("Starting Logger Serivce");             
		Logging.getLogger().fatal("****************************************");		
	}
	public  String  getLogLevel()
	{
		return this.logLevel;
	}
	
	public static Logger getLogger(){
		return log;
	}
	public synchronized void logDebug(String logStr){
		log.debug(logStr);
	}
	public synchronized void logInfo(String logStr){
		log.info(logStr);
	}
	public synchronized void logWarn(String logStr){
		log.warn(logStr);
	}
	public synchronized void logError( String logStr){
		log.error(logStr);
	}
	public synchronized void fatal( String logStr){
		log.fatal(logStr);
	}

	public synchronized void logException( Exception ex){
		log.fatal(getStackTrace(ex));
	}	
	public synchronized static String getStackTrace(final Throwable throwable) {
		final StringWriter sw = new StringWriter();
		final PrintWriter pw = new PrintWriter(sw, true);
		throwable.printStackTrace(pw);
		return sw.getBuffer().toString();
	}
}