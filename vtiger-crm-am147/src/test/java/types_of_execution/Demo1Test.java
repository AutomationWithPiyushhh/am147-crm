package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo1Test {
	@Test
	public void case1() {
		System.out.println("this is case1");
		WebDriver driver = new ChromeDriver();
		driver.quit();
	}
	
	@Test
	public void case11() {
		System.out.println("this is case11");
		WebDriver driver = new ChromeDriver();
		driver.quit();		
	}
	
	@Test
	public void case111() {
		System.out.println("this is case111");
		WebDriver driver = new ChromeDriver();
		driver.quit();}
}
