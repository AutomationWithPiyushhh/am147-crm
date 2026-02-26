package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo3Test {
	@Test
	public void case3() {
		System.out.println("this is case3");
		WebDriver driver = new ChromeDriver();
		driver.quit();
	}
	
	@Test
	public void case33() {
		System.out.println("this is case33");
		WebDriver driver = new ChromeDriver();
		driver.quit();		
	}
	
	@Test
	public void case333() {
		System.out.println("this is case333");
		WebDriver driver = new ChromeDriver();
		driver.quit();
	}
}
