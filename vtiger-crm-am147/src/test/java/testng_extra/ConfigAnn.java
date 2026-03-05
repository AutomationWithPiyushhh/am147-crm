package testng_extra;

import org.testng.annotations.Test;

import base_utility.BaseClass;

public class ConfigAnn extends BaseClass {

	@Test
	public void createAndVerify() {
		System.out.println("Created");
		System.out.println("Verified");
	}
	
//	public static void main(String[] args) {
//		System.out.println("this is main");
//	}
}
