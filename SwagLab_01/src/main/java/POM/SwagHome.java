package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagHome {
	
	@FindBy (xpath = "//a[@class='shopping_cart_link']")
	private WebElement Cart;
	
	//@FindBy (xpath = "//button[text()='Add to cart']")
	//private WebElement AllAddToCartBtn;
	
	@FindBy (xpath = "//span[@class='shopping_cart_badge']")
	private WebElement Shopping_Cart_badge;
	
	public SwagHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public int GetCartCount() {
		String Count = Shopping_Cart_badge.getText();
		return Integer.parseInt(Count);
	}
	
	public List<WebElement> GatAllAddToCartBtn(WebDriver Driver){
		List<WebElement> Elements_List = Driver.findElements(By.xpath("//button[text()='Add to cart']"));
		return Elements_List;
	}
}
