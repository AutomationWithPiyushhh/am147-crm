package generic_utility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	
	WebDriver driver = null;
	Actions act = null;
	WebDriverWait wait = null;

	
	public WebDriverUtility(WebDriver driver) {
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
	
	public void hover( WebElement element) {
		act.moveToElement(element).build().perform();
	}

	public void leftClick(WebElement element) {
		act.click(element).build().perform();
	}

	public void rightClick( WebElement element) {
		Actions act = new Actions(driver);
		act.contextClick(element).build().perform();
	}

	public void clickAndHold( WebElement element) {
		act.clickAndHold(element).build().perform();
	}

	public void doubleClick( WebElement element) {
		act.doubleClick(element).build().perform();
	}
	
	public void switchToWindowByUrl(String partialUrl) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
			if (driver.getCurrentUrl().contains(partialUrl)) {
				break;
			}
		}
	}


}
