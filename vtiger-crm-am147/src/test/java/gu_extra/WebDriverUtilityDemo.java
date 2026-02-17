package gu_extra;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtilityDemo {
	
	WebDriver driver = null;
	Actions act = null;
	WebDriverWait wait = null;

	
	public WebDriverUtilityDemo(WebDriver driver) {
		this.driver = driver;
		this.act = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	}
	
	public void maxWin() {
		driver.manage().window().maximize();
	}
	
	public void waitForEleToClickable(WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForAlertToBePresent(WebElement element) {
		wait.until(ExpectedConditions.alertIsPresent());
	}
	

	public void waitForFrameToBeAvailable(int index) {
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(index));
	}
	
	public void hover(WebDriver driver, WebElement element) {
		System.out.println(act);
		act.moveToElement(element).build().perform();
	}

	public void leftClick(WebDriver driver, WebElement element) {
		act.click(element).build().perform();
	}

	public void rightClick(WebDriver driver, WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();
	}

	public void clickAndHold(WebDriver driver, WebElement element) {
		act.clickAndHold(element).build().perform();
	}

	public void doubleClick(WebDriver driver, WebElement element) {
		act.doubleClick(element).build().perform();
	}

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver(); 

		

		driver.get("https://automationwithpiyush.vercel.app/actions.html");

		WebElement eleToHover = driver.findElement(By.xpath("//button[contains(text(),'Hover')]"));
		WebElement eleToClick = driver.findElement(By.id("click-text"));
		WebElement eleToRC = driver.findElement(By.xpath("//p[contains(text(),'Right')]"));

		Thread.sleep(1000);

//		Actions act = new Actions(driver);
//		
//		act.moveToElement(eleToHover).build().perform();
//		act.click(eleToClick).build().perform();
//		act.contextClick(eleToRC).build().perform();
		WebDriverUtilityDemo wdUtil = new WebDriverUtilityDemo(driver);

		wdUtil.maxWin();
		
		wdUtil.hover(driver, eleToHover);
		wdUtil.leftClick(driver, eleToClick);
		wdUtil.rightClick(driver, eleToRC);

		Thread.sleep(3000);
		driver.quit();
	}
}
