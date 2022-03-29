package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLogin {
	@FindBy (xpath = "//input[@placeholder='Username']")
	private WebElement username;
	
	@FindBy (xpath = "//input[@placeholder='Password']")
	private WebElement Password;
	
	@FindBy (xpath = "//input[@name='login-button']")
	private WebElement  LoginBtn;
	
	@FindBy (xpath = "//h3[text()='Epic sadface: Username is required']")
	private WebElement ErrorMsg;
	
	@FindBy (xpath = "//span[@class='title']")
	private WebElement TitleHome;
	
	public void SendKeysLogin(String username, String Password) {
		this.username.sendKeys(username);
		this.Password.sendKeys(Password);
	}
	
	public SwagLogin(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void SwaglLoginBtn() {
		LoginBtn.click();
	}
	
	public String getTitle() {
		return TitleHome.getText();
	}
	
	public boolean ErrorMsg() {
		if(ErrorMsg.isDisplayed()) {
			return true;
		}
		return false;
	}
}
