package TestCases;

import java.io.IOException;
import java.util.List; 
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Helper.BaseClass;
import POM.SwagLogin;
import POM.SwagProductDetails;
import Utility.ScreenShot;
public class Swag_TC0103 extends BaseClass {
	ScreenShot shot;
	SwagLogin swaglogin;
	SoftAssert softAssert;
	SwagProductDetails productDetails;
	List<WebElement> List_ofProducts;
	Actions action;
	@Test
	public void TC0103() throws InterruptedException, IOException {
		swaglogin = new SwagLogin(driver);
		action = new Actions(driver);
		productDetails = new SwagProductDetails(driver);
		//shot =new ScreenShot();
		softAssert = new SoftAssert();
		driver.get(readConfig.GetBaseUrl());
		swaglogin.SendKeysLogin(readConfig.GetUsername(), readConfig.GetPassword());
		swaglogin.SwaglLoginBtn();
		List_ofProducts=productDetails.GetAllInventoryList(driver);
		for(WebElement webelement :List_ofProducts) {
			Thread.sleep(3000);
			String ProdName=webelement.getText();
			Thread.sleep(1000);
			webelement.click();
			Thread.sleep(2000);
			if(ProdName.equals(productDetails.GetProductName())) {
				softAssert.assertTrue(true, "PASS-TC0102");
				productDetails.GoBack();
			}
			else {
				ScreenShot.TakeScreenShot(driver, "TC0103");
				softAssert.assertFalse(false,"Product @"+webelement.getText());
			}
		}
		softAssert.assertAll();
	}	
}
