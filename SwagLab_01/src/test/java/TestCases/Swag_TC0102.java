package TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Helper.BaseClass;
import POM.SwagHome;
import POM.SwagLogin;
import Utility.ScreenShot;

public class Swag_TC0102 extends BaseClass{
	
	ScreenShot shot;
	SwagLogin swaglogin;
	SoftAssert softAssert;
	SwagHome swaghome;
	List<WebElement> List_ofEements;
	Actions action;
	@Test
	public void TC0102() throws InterruptedException, IOException {
		swaglogin = new SwagLogin(driver);
		swaghome = new SwagHome(driver);
		int ProductAddToCart=0;
		action = new Actions(driver);
		//shot =new ScreenShot();
		softAssert = new SoftAssert();
		driver.get(readConfig.GetBaseUrl());
		swaglogin.SendKeysLogin(readConfig.GetUsername(), readConfig.GetPassword());
		swaglogin.SwaglLoginBtn();
		List_ofEements=swaghome.GatAllAddToCartBtn(driver);
		for(WebElement webelement :List_ofEements) {
			Thread.sleep(3000);
			webelement.click();
			ProductAddToCart++;
		}
		if(ProductAddToCart !=swaghome.GetCartCount()) {
			ScreenShot.TakeScreenShot(driver, "TC0102");
			Assert.fail();
		}
		else {
			softAssert.assertTrue(true, "PASS-TC0102");
		}
		softAssert.assertAll();
	}
}
