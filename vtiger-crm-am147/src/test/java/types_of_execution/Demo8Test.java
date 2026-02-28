package types_of_execution;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Demo8Test {
	@Test(groups = "regression")
	public void case8() {
		System.out.println("this is case1");
		WebDriver driver = new ChromeDriver();
		driver.quit();
	}
	
	@Test(groups = {"smoke","regression"})
	public void case88() {
		System.out.println("this is case11");
		WebDriver driver = new ChromeDriver();
		driver.quit();		
	}
	
	@Test(groups = "regression")
	public void case888() {
		System.out.println("this is case111");
		WebDriver driver = new ChromeDriver();
		driver.quit();}
}
