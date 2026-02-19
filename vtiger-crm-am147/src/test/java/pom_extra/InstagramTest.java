package pom_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

class InstagramLoginPage {
	public InstagramLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "email")
	private WebElement un;

	public WebElement getUn() {
		return un;
	}
	
	
//	@FindAll => OR operator
	@FindAll
	({
		@FindBy(name = "email"),
		@FindBy(name = "username")
	})
	private WebElement un1; 

	public WebElement getUn1() {
		return un1;
	}

//	@FindBys => AND operator
//	@FindBys
//	({
//		@FindBy(name = "email"),
//		@FindBy(name = "username")
//	})
//	private WebElement un2; 
//
//	public WebElement getUn2() {
//		return un2;
//	}
	
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

public class InstagramTest {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.instagram.com/");
		Thread.sleep(2000);

//		WebElement un = driver.findElement(By.name("email"));
//		WebElement pwd = driver.findElement(By.name("pass"));
//		WebElement loginBtn = driver.findElement(By.xpath("//span[text()='Log in']"));

		InstagramLoginPage lp = new InstagramLoginPage(driver);
		WebElement un = lp.getUn1();
		WebElement pwd = lp.getPwd();
		WebElement loginBtn = lp.getLoginBtn();

		driver.navigate().refresh();
		Thread.sleep(2000);

		un.sendKeys("admin");
		pwd.sendKeys("12345678");
		loginBtn.click();

		Thread.sleep(2000);
		driver.navigate().refresh();

		un.sendKeys("admin@123456");
		pwd.sendKeys("0987654321");
		loginBtn.click();

		Thread.sleep(2000);
		driver.quit();
	}
}
