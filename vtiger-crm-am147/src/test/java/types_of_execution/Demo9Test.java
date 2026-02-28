package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo9Test {
	@Test(groups = "smoke")
	public void case9() {
		System.out.println("this is case3");
		WebDriver driver = new ChromeDriver();
		driver.quit();
	}
	
	@Test(groups = "regression")
	public void case99() {
		System.out.println("this is case33");
		WebDriver driver = new ChromeDriver();
		driver.quit();		
	}
	
	@Test(groups = "regression")
	public void case999() {
		System.out.println("this is case333");
		WebDriver driver = new ChromeDriver();
		driver.quit();
	}
}
