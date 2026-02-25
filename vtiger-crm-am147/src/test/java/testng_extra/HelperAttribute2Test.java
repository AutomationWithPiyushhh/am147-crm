package testng_extra;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class HelperAttribute2Test {

	@Test(invocationCount = 7,threadPoolSize = 7)
	public void case1() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		Thread.sleep(500);
		driver.quit();
	}

	@Test(enabled = false)
	public void case2() throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		Thread.sleep(500);
		driver.quit();
	}

	@Test(enabled = false)
	public void case3() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		Thread.sleep(500);
		driver.quit();
	}

	@Test(enabled = false)
	public void case4() throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		Thread.sleep(500);
		driver.quit();
	}

	@Test(enabled = false)
	public void case5() throws InterruptedException {
		WebDriver driver = new FirefoxDriver();
		Thread.sleep(500);
		driver.quit();
	}
}
