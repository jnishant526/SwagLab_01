package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties prop;
	
	public ReadConfig() {
		File src = new File("./Configrution\\config.properties");
		try {
			FileInputStream F_io = new FileInputStream(src);
			prop = new Properties();
			prop.load(F_io);
		}
		catch(Exception e) {
			System.out.println("Configrution Exception occurs "+e.getMessage());
		}
	}
	
	public String GetBaseUrl() {
		String url = prop.getProperty("Baseurl");
		return url;
	}
	
	public String GetChromepath() {
		String Chromepath = prop.getProperty("chromepath");
		return Chromepath;
	}
	
	public String GetUsername() {
		String Username = prop.getProperty("Username");
		return Username;
	}
	
	public String GetPassword() {
		String Password = prop.getProperty("Password");
		return Password;
	}
	
	public String GetHomeUrl() {
		String Homeurl = prop.getProperty("Home");
		return Homeurl;
	}
	
	public String GetCheckoutURL() {
		String checkoutURL = prop.getProperty("checkoutURL");
		return checkoutURL;
	}
	
	public String PlaceOrderTest() {
		String OrderText = prop.getProperty("placedOrderTest");
		return OrderText;
	}
	
	public String UserFName() {
		String Fname = prop.getProperty("Fname");
		return Fname;
	}
	public String UserLname() {
		String Lname = prop.getProperty("Lname");
		return Lname;
	}
	public String UserPostalCode() {
		String code = prop.getProperty("PostalCode");
		return code;
	}
}
