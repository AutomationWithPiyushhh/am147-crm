package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo7Test {
	@Test(groups = "regression")
	public void case7() {
		System.out.println("this is case2");
		WebDriver driver = new ChromeDriver();
		driver.quit();
	}
	
	@Test(groups = "smoke")
	public void case77() {
		System.out.println("this is case22");
		WebDriver driver = new ChromeDriver();
		driver.quit();		
	}
	
	@Test(groups = "regression")
	public void case777() {
		System.out.println("this is case222");
		WebDriver driver = new ChromeDriver();
		driver.quit();
	}
}
