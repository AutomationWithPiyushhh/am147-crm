package advance_reports;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

//@Listeners(listeners_practice.List_Imp.class)
public class LoginTest {
	ExtentReports report;

	@BeforeSuite
	public void repConfig() {
		ExtentSparkReporter spark = new ExtentSparkReporter("./extentReport/extentReport.html");
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Functional Testing");
		spark.config().setTheme(Theme.DARK);

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows 10");
		report.setSystemInfo("Author", "Selenium Team");
		report.setSystemInfo("Browser", "Chrome");
		report.setSystemInfo("Java Version", "1.8");
	}

	public static WebDriver sdriver;

	@Test
	public void fbLoginTest() {
		WebDriver driver = new ChromeDriver();
		sdriver = driver;

		driver.get("https://www.facebook.com/");

		Assert.assertTrue(false);
	}

	@Test(dependsOnMethods = "fbLoginTest")
	public void xLoginTest() {
	}

	@Test
	public void instaLoginTest() {

	}

	@AfterSuite
	public void repBackup() {
		report.flush();
	}
}
