package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserLunch {
	
	public static WebDriver CheromeDriver() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		return driver;
	}
	
	public static WebDriver FireFoxDriver() {
		System.setProperty("webdriver.gecko.driver", "E:\\selenimum\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver EdgeDriver() {
		System.setProperty("webdriver.gecko.driver", "E:\\selenimum\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
	public static WebDriver OperaDriver() {
		System.setProperty("webdriver.gecko.driver", "E:\\selenimum\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		return driver;
	}
	
}
