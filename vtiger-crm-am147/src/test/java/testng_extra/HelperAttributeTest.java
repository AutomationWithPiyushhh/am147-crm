package testng_extra;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HelperAttributeTest {

//	why do we go for priority?
/*  to change the order of execution */	
//	sense-less/logic-less flow
	
//	@Test(priority = -1)
//	public void createCity() {
//		System.out.println("create Okhla");
//		Assert.assertTrue(false);
//	}
//
//	@Test(priority = 0)
//	public void modifyCity() {
//		System.out.println("modify to Noida");
//	}
//
//	@Test(priority = 1)
//	public void deleteCity() {
//		System.out.println("Noida delete");
//	}
	
//	why do we go for dependsOnMethods
/*  whenever we want to create dependency between 2 test cases *
 * -> we should never ever create dependency between test cases
*/	
	@Test
	public void createCity() {
		System.out.println("create Okhla");
		Assert.assertTrue(false);
	}

	@Test
	public void modifyCity() {
		System.out.println("create Okhla");
		System.out.println("modify to Noida");
	}

	@Test
	public void deleteCity() {
		System.out.println("create Noida");
		System.out.println("Noida delete");
	}
}
