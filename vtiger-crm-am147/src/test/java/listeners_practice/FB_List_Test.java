package listeners_practice;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(listeners_practice.List_Imp.class)
public class FB_List_Test {
	
	@BeforeSuite
	public void bs() {
		System.out.println("i am @BeforeSuite");
	}
	
	@Test
	public void fb_Login() {
		System.out.println("i am @Test");
	}

	@AfterSuite
	public void as() {
		System.out.println("i am @AfterSuite");
	}
}
