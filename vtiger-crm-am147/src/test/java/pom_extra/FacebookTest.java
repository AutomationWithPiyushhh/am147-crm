package pom_extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class FacebookLoginPage {

//	initialization
	public FacebookLoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);

	}

//	declaration 
	@FindBy(name = "email")
	private WebElement un;

	public WebElement getUn() {
		return un;
	}

	@FindBy(name = "pass")
	private WebElement pwd;

	public WebElement getPwd() {
		return pwd;
	}
}

class FacebookCNAPage {

}

class FBHomePage {

}

public class FacebookTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

//		utilization
		FacebookLoginPage lp = new FacebookLoginPage(driver);
		driver.navigate().refresh();
		Thread.sleep(2000);
		lp.getUn().sendKeys("admin");

		Thread.sleep(3000);
		driver.quit();
	}
}
