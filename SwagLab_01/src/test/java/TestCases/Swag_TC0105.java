package TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Helper.BaseClass;
import POM.PlaceOrder;
import POM.SwagHome;
import POM.SwagLogin;
import POM.SwagProductDetails;
import Utility.ScreenShot;

public class Swag_TC0105 extends BaseClass{
	ScreenShot shot;
	SwagLogin swaglogin;
	SwagHome swagHome;
	SoftAssert softAssert;
	PlaceOrder order;
	SwagProductDetails productDetails;
	List<WebElement> List_ofProducts;
	Actions action;
	@Test
	public void TC0105() throws InterruptedException, IOException {
		swaglogin = new SwagLogin(driver);
		swagHome = new SwagHome(driver);
		order = new PlaceOrder(driver);
		action = new Actions(driver);
		productDetails = new SwagProductDetails(driver);
		//shot =new ScreenShot();
		softAssert = new SoftAssert();
		driver.get(readConfig.GetBaseUrl());
		swaglogin.SendKeysLogin(readConfig.GetUsername(), readConfig.GetPassword());
		swaglogin.SwaglLoginBtn();
		Thread.sleep(2000);
		order.GoTOCart();
		//order.AddToCart();
		if(order.IsCartEmpty()) {
			order.Checkout();
			if(driver.getCurrentUrl().equals(readConfig.GetCheckoutURL())) {
				ScreenShot.TakeScreenShot(driver, "TC0105");
				Assert.fail("User Not able to place order without adding product into the cart");
			}
		}
	}
}
