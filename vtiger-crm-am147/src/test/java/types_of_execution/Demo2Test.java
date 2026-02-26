package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo2Test {
	@Test
	public void case2() {
		System.out.println("this is case2");
		WebDriver driver = new ChromeDriver();
		driver.quit();
	}
	
	@Test
	public void case22() {
		System.out.println("this is case22");
		WebDriver driver = new ChromeDriver();
		driver.quit();		
	}
	
	@Test
	public void case222() {
		System.out.println("this is case222");
		WebDriver driver = new ChromeDriver();
		driver.quit();
	}
}
