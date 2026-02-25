package pom_extra;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Dynamic_Xpath {
	public static void main(String[] args) {
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.facebook.com/");

		String lt1 = "Meta Pay";
		String lt2 = "Meta Store";
		String lt3 = "Ray-Ban Meta";

//		WebElement ele1 = driver.findElement(By.xpath("//a[contains(text(), 'Ray-Ban Meta')]"));
//		WebElement ele2 = driver.findElement(By.xpath("//a[contains(text(), 'Meta Store')]"));
//		WebElement ele3 = driver.findElement(By.xpath("//a[contains(text(), 'Meta Pay')]"));

		String lt1xpath = "//a[contains(text(), '" + lt1 + "')]";
		String lt2xpath = "//a[contains(text(), '" + lt2 + "')]";
		String lt3xpath = "//a[contains(text(), '" + lt3 + "')]";

		System.out.println(lt1xpath);
		System.out.println(lt2xpath);
		System.out.println(lt3xpath);
		
		
//		WebElement ele1 = driver.findElement(By.xpath(lt1xpath));
//		WebElement ele2 = driver.findElement(By.xpath(lt2xpath));
//		WebElement ele3 = driver.findElement(By.xpath(lt3xpath));

	}
}
