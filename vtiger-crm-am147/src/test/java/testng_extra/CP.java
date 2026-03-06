package testng_extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CP {

	public static void main(String[] args) throws InterruptedException {

		String appUrl = "http://localhost:8888/";
		Cookie sessionCookie = null;

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(appUrl);

		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();

		Thread.sleep(2000);

		sessionCookie = driver.manage().getCookieNamed("PHPSESSID");

		driver.quit();

		driver = new ChromeDriver();

		driver.get(appUrl);

		driver.manage().addCookie(sessionCookie);

		driver.navigate().refresh();

		Thread.sleep(3000);

		driver.quit();
	}

}