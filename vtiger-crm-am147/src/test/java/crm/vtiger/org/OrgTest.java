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
import org.testng.annotations.Test;

import base_utility.BaseClass;
import generic_utility.FileUtility;
import generic_utility.JavaUtility;
import generic_utility.WebDriverUtility;
import object_repository.HomePage;
import object_repository.LoginPage;

public class OrgTest extends BaseClass {
//	public static void main(String[] args) throws InterruptedException, IOException {

	@Test
	public void createOrgTest() throws IOException, InterruptedException {
		FileUtility fUtil = new FileUtility();
		int random = JavaUtility.generateRanNum();
		String orgName = fUtil.getDataFromExcelFile("org", 7, 0) + random;

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

//		verification
		String actOrgName = driver.findElement(By.id("dtlview_Organization Name")).getText();
		Assert.assertEquals(orgName, actOrgName);
	}
}
