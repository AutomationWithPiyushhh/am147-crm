package testng_extra;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginFBTest {
	
	@Test(dataProvider = "getData")
	public void login(String username, String password) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://www.facebook.com/");

//		String username = "admin";
//		String password = "admin@123";
		
		new Actions(driver)
			.pause(Duration.ofSeconds(1))
			.sendKeys(username + Keys.TAB + password + Keys.ENTER)
			.build().perform();
		
		
		Thread.sleep(1000);
		driver.quit();
	}
	
	
	
	
	@DataProvider
	public String[][] getData() {
		String[][] cred = new String[5][2];

		cred[0][0] = "Kashif";
		cred[0][1] = "KuchBhi";

		cred[1][0] = "Kanishka";
		cred[1][1] = "Honesty";

		cred[2][0] = "Harsh";
		cred[2][1] = "Harsh@123";

		cred[3][0] = "PraveshBhai";
		cred[3][1] = "12345678";

		cred[4][0] = "Swati";
		cred[4][1] = "aurlikhdo@123";
		
		return cred;
	}
	
}
