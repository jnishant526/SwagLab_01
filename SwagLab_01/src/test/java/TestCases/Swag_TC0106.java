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
import POM.SwagLogin;
import POM.SwagProductDetails;
import Utility.ScreenShot;

public class Swag_TC0106 extends BaseClass{
	ScreenShot shot;
	SwagLogin swaglogin;
	SoftAssert softAssert;
	PlaceOrder order;
	SwagProductDetails productDetails;
	List<WebElement> List_ofProducts;
	Actions action;
	@Test
	public void TC0106() throws InterruptedException, IOException {
		swaglogin = new SwagLogin(driver);
		order = new PlaceOrder(driver);
		action = new Actions(driver);
		productDetails = new SwagProductDetails(driver);
		//shot =new ScreenShot();
		softAssert = new SoftAssert();
		driver.get(readConfig.GetBaseUrl());
		swaglogin.SendKeysLogin(readConfig.GetUsername(), readConfig.GetPassword());
		swaglogin.SwaglLoginBtn();
		Thread.sleep(2000);
		order.AddToCart();
		order.GoTOCart();
		Thread.sleep(2000);
		order.Checkout();
		Thread.sleep(2000);
		order.SetData(readConfig.UserFName(),readConfig.UserLname(), readConfig.UserPostalCode());
		Thread.sleep(2000);
		order.Continue();
		Thread.sleep(2000);
		order.Finish();
		order.Home();
		Thread.sleep(2000);
		if(driver.getCurrentUrl().equals(readConfig.GetHomeUrl())) {
			softAssert.assertTrue(true,"PASS-TC0106");
		}
		else {
			ScreenShot.TakeScreenShot(driver, "TC0106");
			Assert.fail("URL is not matched");
		}
	}
}
