package testng_extra;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Practice_Assertion {
	@Test
	public void hardAssertPractice() {
		
		SoftAssert sa = new SoftAssert();
		
		boolean s1 = true;
		boolean s2 = false;

		sa.assertTrue(s1);
		sa.assertFalse(s2);

		String str1 = "Shivam";
		String str2 = "Shubham";
		String str3 = "Shivam";

//		if (str1.equals(str2)) {
//			System.out.println("good to go");
//		} else {
//			System.out.println("should not go further");
//		}

//		Assert.assertTrue(str1.equals(str2));
//		Assert.assertEquals(str1, str2);
		sa.assertNotEquals(str1, str2);

		
		Object obj = null;
		Object obj2 = new Object();

		sa.assertNull(obj);
		sa.assertNotNull(obj2);

		sa.assertAll();
		System.out.println("Last line of code");
		

	}
}
