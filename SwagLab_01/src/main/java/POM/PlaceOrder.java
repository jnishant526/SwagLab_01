package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrder {
	@FindBy (xpath = "(//button[text()='Add to cart'])[1]")
	private WebElement product1;
	
	@FindBy (xpath = "//button[@id='back-to-products']")
	private WebElement BackToHome;
	
	@FindBy (xpath = "//a[@class='shopping_cart_link']")
	private WebElement Cart;
	
	@FindBy (xpath = "//button[@name='checkout']")
	private WebElement CheckoutBtn;
	
	@FindBy (xpath = "//input[@name='firstName']")
	private WebElement FirstName;
	
	@FindBy (xpath = "//input[@name='lastName']")
	private WebElement LastName;
	
	@FindBy (xpath = "//input[@name='postalCode']")
	private WebElement PostalCode;
	
	@FindBy (xpath = "//input[@name='continue']")
	private WebElement ContinueBtn;
	
	@FindBy (xpath = "//button[@id='finish']")
	private WebElement FinishBtn;
	
	@FindBy (xpath = "//h2[@class='complete-header']")
	private WebElement OrderPlaced;
	
	//button[@id='finish']
	public PlaceOrder(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void AddToCart() {
		product1.click();
	}
	
	public void GoTOCart() {
		Cart.click();
	}
	
	public boolean IsCartEmpty() {
		if(Cart.getText()!="") {
			return false;
		}
		return true;
	}
	public void SetData(String firstName, String lastName, String postalcode) {
		FirstName.sendKeys(firstName);
		LastName.sendKeys(lastName);
		PostalCode.sendKeys(postalcode);
	}
	
	public void Checkout() {
		CheckoutBtn.click();
	}
	
	public void Continue() {
		ContinueBtn.click();
	}
	
	public void Finish() {
		FinishBtn.click();
	}
	
	public String getOrderPlacedTest() {
		return OrderPlaced.getText();
	}
	
	public void Home() {
		BackToHome.click();
	}
}
