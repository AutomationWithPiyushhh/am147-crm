package crm.vtiger.contact;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

public class ContactTest extends BaseClass {
	@Test
	public void createContactTest() throws IOException, InterruptedException {
		FileUtility fUtil = new FileUtility();
		String lastName = fUtil.getDataFromExcelFile("contact", 2, 0);

//		Create contact
		HomePage hp = new HomePage(driver);
		hp.getConLink().click();

		driver.findElement(By.cssSelector("img[title='Create Contact...']")).click();

//		form filling
		WebElement lastNameField = driver.findElement(By.name("lastname"));
		lastNameField.sendKeys(lastName);

//		saving
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[contains(@value, 'Save')]")).click();

//		verification
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		Assert.assertEquals(lastName, actLastName);
	}
}
