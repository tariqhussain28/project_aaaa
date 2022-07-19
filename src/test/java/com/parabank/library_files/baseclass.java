
package com.parabank.library_files;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class baseclass {
	public ExtentSparkReporter htmlreporter;
	public ExtentReports reports;
	public ExtentTest test;
	public WebDriver driver;
	public static Logger logs=LogManager.getLogger(log4j.class.getName());
	@BeforeTest
	public void intreports() {
		htmlreporter = new ExtentSparkReporter(
				"C:\\Users\\cw\\eclipse-workspace\\AAAA\\extentreports\\report" + ".html");
		reports = new ExtentReports();
		reports.attachReporter(htmlreporter);
		// add details
		reports.setSystemInfo("machine", "pc 1");
		reports.setSystemInfo("user", "Tariq Hussain");
		reports.setSystemInfo("OS", "Windows 10");
		reports.setSystemInfo("browser", "chrome");

		// config to change look and feel
		htmlreporter.config().setDocumentTitle("EXTENT REPORT");
		htmlreporter.config().setReportName("Test report");
		htmlreporter.config().setTheme(Theme.STANDARD);
		htmlreporter.config().setTimeStampFormat("EEEE ,dd/MMMM/yyyy, hh:mm a '('zzz')'");

	}

	@BeforeClass
	public void openbrowser() throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\cw\\eclipse-workspace\\AAAA\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(utilityclass.propertyfiledata("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void getresult(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));

		}

		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
			test.fail(result.getThrowable());

		}

		if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));

		}

	}

	@AfterClass
	public void closebrowser() {
		driver.quit();
	}

	@AfterTest
	public void teardown() {
		reports.flush();
	}

}
