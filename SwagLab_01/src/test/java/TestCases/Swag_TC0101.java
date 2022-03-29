package TestCases;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import Helper.BaseClass;
import POM.SwagLogin;
import Utility.ScreenShot;

public class Swag_TC0101 extends BaseClass {
	ScreenShot shot;
	SwagLogin swaglogin;
	SoftAssert softAssert;
	@Test
	public void TC0101() throws IOException{
		swaglogin = new SwagLogin(driver);
		//shot =new ScreenShot();
		softAssert = new SoftAssert();
		driver.get(readConfig.GetBaseUrl());
		swaglogin.SendKeysLogin(readConfig.GetUsername(), readConfig.GetPassword());
		swaglogin.SwaglLoginBtn();
		if(driver.getCurrentUrl().equals(readConfig.GetHomeUrl())) {
			softAssert.assertTrue(true);
		}
		else {
			ScreenShot.TakeScreenShot(driver, "TC0101");
			Assert.fail("URl not matched");
		}
		softAssert.assertAll();
	}
}