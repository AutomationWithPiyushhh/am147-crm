package base_utility;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	@BeforeClass
	public void openBrowser() {
		System.out.println("Browser opened");
	}

	@BeforeMethod
	public void login() {
		System.out.println("Logged in");
	}

	@AfterMethod
	public void logout() {
		System.out.println("logged out");
	}

	@AfterClass
	public void closeBrowser() {
		System.out.println("Browser closed");
	}


}
