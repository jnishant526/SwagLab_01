package POM;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagProductDetails {
	
	@FindBy (xpath = "//button[@id='back-to-products']")
	private WebElement BackBtn;
	
	@FindBy (xpath = "//div[@class='inventory_details_name large_size']")
	private WebElement ProductName;
	
	public SwagProductDetails(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> GetAllInventoryList(WebDriver Driver){
		List<WebElement> Elements_List = Driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
		return Elements_List;
	}
	
	public void GoBack() {
		BackBtn.click();
	}
	
	public String GetProductName() {
		return ProductName.getText();
	}
}
