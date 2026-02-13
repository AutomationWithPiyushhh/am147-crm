package crm.vtiger.org;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateOrgTest {
	public static void main(String[] args) throws InterruptedException, IOException {

//		get the data from properties file
		FileInputStream fis1 = new FileInputStream("./src/test/resources/commondata.properties");

		Properties pObj = new Properties();
		pObj.load(fis1);

		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");

		int random = (int) (Math.random() * 999);

		
//		get the data from excel file
		FileInputStream fis2 = new FileInputStream("./src/test/resources/testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis2);
		Cell cell = wb.getSheet("org").getRow(7).getCell(0);
		String orgName = cell.getStringCellValue() + random;
		
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
//		driver.get("http://localhost:8888/");  // hardcoded
		driver.get(URL);					   // DDT

		WebElement un = driver.findElement(By.name("user_name"));
		un.sendKeys(USERNAME);

		WebElement pwd = driver.findElement(By.name("user_password"));
		pwd.sendKeys(PASSWORD);

		WebElement loginBtn = driver.findElement(By.id("submitButton"));
		loginBtn.click();

//		Create organization
		driver.findElement(By.linkText("Organizations")).click();

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
		boolean status = actOrgName.equals(orgName);

		if (status) {
			System.out.println("Organization created successfullyyyyy !!!!");
		} else {
			System.out.println("Could not create org.....");
		}

//		logout
		WebElement profile = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
		Thread.sleep(1000);
		Actions act = new Actions(driver);
		act.moveToElement(profile).build().perform();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Sign Out")).click();

//		close the browser
		Thread.sleep(3000);
		driver.quit();

	}
}
