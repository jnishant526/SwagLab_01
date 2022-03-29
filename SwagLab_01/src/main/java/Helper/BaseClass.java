package Helper;



import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Utility.ReadConfig;

public class BaseClass {

	public String Project_path = "https://www.saucedemo.com/";
	public static WebDriver driver;
	public static Logger logger;
	public static ReadConfig readConfig;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@BeforeClass
	public void BrowserSetup() {
		reporter = new ExtentHtmlReporter("test-output"+File.separator+"ExtendReport"+File.separator+"extendReport.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
		readConfig = new ReadConfig();
		// Chrome Running in Headless Mode 
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		// Set System property for ChrmeDriver
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\BrowserExe\\chromedriver.exe");
		driver = new ChromeDriver(options);
		
		//set attribute for printing logs 
		//logger = Logger.getLogger("SwagLab");
		//PropertyConfigurator.configure("Log4j.properties");
	}
	
	@AfterClass
	public void KillResources() {
		// yet to design
	}
}
