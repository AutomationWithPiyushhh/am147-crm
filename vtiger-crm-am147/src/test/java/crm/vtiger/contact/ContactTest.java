package crm.vtiger.contact;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

public class ContactTest {
//	@Test
//	public void createContactTest() throws IOException, InterruptedException {
//		FileUtility fUtil = new FileUtility();
//		String lastName = fUtil.getDataFromExcelFile("contact", 2, 0);
//
////		Create contact
//		HomePage hp = new HomePage(driver);
//		hp.getConLink().click();
//
//		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();
//
////		form filling
//		WebElement lastNameField = driver.findElement(By.name("lastname"));
//		lastNameField.sendKeys(lastName);
//
////		saving
//		Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[contains(@value, 'Save')]")).click();
//
////		verification
//		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
//		Assert.assertEquals(lastName, actLastName);
//	}

	@Test
	public void passMethod() {
		System.out.println("i am passed, everything is alright....");
	}
	
	
	@Test
	public void createContactWithOrgNameTest() throws InterruptedException, EncryptedDocumentException, IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");

		FileUtility fUtil = new FileUtility();
		String URL = fUtil.getDataFromPropertiesFile("url");
		String USERNAME = fUtil.getDataFromPropertiesFile("un");
		String PASSWORD = fUtil.getDataFromPropertiesFile("pwd");

		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.login(USERNAME, PASSWORD);

		int random = JavaUtility.generateRanNum();
		String orgName = fUtil.getDataFromExcelFile("org", 7, 0) + random;
		System.out.println(orgName);

//		Create organization
		HomePage hp = new HomePage(driver);
		hp.getOrgLink().click();

		driver.findElement(By.cssSelector("img[title='Create Organization...']")).click();

//		form filling
		WebElement orgField = driver.findElement(By.name("accountname"));
		orgField.sendKeys(orgName);

		WebElement shipAdd = driver.findElement(By.name("ship_street"));
		shipAdd.sendKeys("B-4 sector 3 noida 201301");

//		saving
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@value, 'Save')]")).click();

		Thread.sleep(5000); // sync issue so we need to hardcode the wait

//		Create contact
		String lastName = fUtil.getDataFromExcelFile("contact", 2, 0);
		hp.getConLink().click();

		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();

//		form filling
		WebElement lastNameField = driver.findElement(By.name("lastname"));
		lastNameField.sendKeys(lastName);

		driver.findElement(By.cssSelector("img[src='themes/softed/images/select.gif']")).click();

		WebDriverUtility wdUtil = new WebDriverUtility(driver);
		wdUtil.switchToWindowByUrl("module=Accounts");

		Thread.sleep(1000);
		driver.findElement(By.id("search_txt")).sendKeys(orgName + Keys.ENTER);

		Thread.sleep(1000);
		String dynamic_xpath = "//a[text()='" + orgName + "']";
		driver.findElement(By.xpath(dynamic_xpath)).click();
//									"//a[text()='robowaves_09878']"
		System.out.println(dynamic_xpath);
		Thread.sleep(1000);
		wdUtil.switchToWindowByUrl("module=Contacts");

//		saving
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@value, 'Save')]")).click();

	}
}
