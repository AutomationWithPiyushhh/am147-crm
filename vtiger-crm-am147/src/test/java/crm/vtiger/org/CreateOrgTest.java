package crm.vtiger.org;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

public class CreateOrgTest {
	public static void main(String[] args) throws InterruptedException, IOException {

//		get the data from properties file
		FileUtility fUtil = new FileUtility();

		String BROWSER = fUtil.getDataFromPropertiesFile("bro");
		String URL = fUtil.getDataFromPropertiesFile("url");
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");

		int random = JavaUtility.generateRanNum();

//		get the data from excel file		
		String orgName = fUtil.getDataFromExcelFile("org", 7, 0) + random;

//		open the browser
		WebDriver driver = null;
//		String browser = "chrome"; // hardcoded browser
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

//		Login with valid credentials	
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);

		WebElement un = lp.getUn();
		WebElement pwd = lp.getPwd();
		WebElement loginBtn = lp.getLoginBtn();

		un.sendKeys(USERNAME);
		pwd.sendKeys(PASSWORD);
		loginBtn.click();

//		Create organization
		HomePage hp = new HomePage(driver);

		hp.getOrgLink().click();

		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();

//		String orgName = "qspiders_" + random;
		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys(orgName);

		WebElement shipAdd = driver.findElement(By.name("ship_street"));
		shipAdd.sendKeys("B-4 sector 3 noida 201301");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@value, 'Save')]")).click();

//		verification
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();

//		boolean status = actOrgName.equals(orgName + "123");

//		if (status) {
//			System.out.println("Organization created successfullyyyyy !!!!");
//		} else {
//			System.out.println("Could not create org.....");
//		}

		Assert.assertEquals(orgName, actOrgName);
		
//		logout
		WebElement profile = hp.getProfile();
		Thread.sleep(1000);
		
		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.hover(profile);
		
		Thread.sleep(2000);
		hp.getSignOutLink().click();
		
//		close the browser
		Thread.sleep(3000);
		driver.quit();

	}
}
