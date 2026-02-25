package testng_extra;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo1Test {
	
	@Test
	public void case1() {
		Reporter.log("Hi",true);
	}
	
	@Test
	public void case2() {
		Reporter.log("Hello",true);
	}
}
