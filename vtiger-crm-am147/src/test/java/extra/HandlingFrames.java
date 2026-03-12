package extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingFrames {
	@Test
	public void awpFrames() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.get("https://automationwithpiyush.vercel.app/frames.html");
		
		driver.switchTo().frame("frame_d");

		driver.switchTo().frame(0); // h
		driver.switchTo().frame(0); // i
		driver.switchTo().frame(0); // j
		
		driver.findElement(By.id("secret_code")).sendKeys("123456");

//		driver.switchTo().parentFrame();
//		driver.switchTo().parentFrame();
//		driver.switchTo().parentFrame();
//		driver.switchTo().parentFrame();
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame_b");
		
		driver.findElement(By.tagName("input")).click();
		
		Thread.sleep(5000);
		driver.quit();
	}
}
