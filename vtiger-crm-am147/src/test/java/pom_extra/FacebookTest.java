package pom_extra;

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

	@FindBy(xpath = "//span[text()='Log in']")
	private WebElement loginBtn;

	public WebElement getLoginBtn() {
		return loginBtn;
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
		WebElement un = lp.getUn();
		WebElement pwd = lp.getPwd();
		WebElement loginBtn = lp.getLoginBtn();

		driver.navigate().refresh();
		Thread.sleep(2000);

		un.sendKeys("admin");
		pwd.sendKeys("12345678");
		loginBtn.click();

		Thread.sleep(3000);
		driver.quit();
	}
}
