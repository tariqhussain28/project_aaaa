package com.parabank.library_files;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class log4j {
private static Logger logs=LogManager.getLogger(log4j.class.getName());
public static void main(String[] args) {
	
	logs.info("info message displayed ");
	logs.error("error msg displayed");
	logs.debug("debug msg displayed");
	logs.fatal("fatal msg displayed");
}
}
