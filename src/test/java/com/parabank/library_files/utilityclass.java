package com.parabank.library_files;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import net.bytebuddy.utility.RandomString;

public class utilityclass {

	WebDriver driver;
	
	public static String propertyfiledata(String key) throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\cw\\eclipse-workspace\\AAAA\\config.properties");
		Properties p = new Properties();
		p.load(file);
		String pfvalue = p.getProperty(key);
		return pfvalue;
	}

	public static void screenshot(WebDriver driver, int tcid) throws IOException {
		File sc = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String random = RandomString.make(5);
		File desc = new File(
				"C:\\Users\\cw\\eclipse-workspace\\AAAA\\screenshots\\" + random + "tcid:" + tcid + ".jpg");
		FileHandler.copy(sc, desc);
	}

	public static String exceldata(int rowid,int cellid) throws EncryptedDocumentException, IOException
	{
		FileInputStream file1=new FileInputStream("C:\\Users\\cw\\eclipse-workspace\\AAAA\\excelworkbooks\\testdata.xlsx");
		String excelvalue=WorkbookFactory.create(file1).getSheet("Sheet1").getRow(rowid).getCell(cellid).getStringCellValue();
		return excelvalue;
	}
	
	
}
