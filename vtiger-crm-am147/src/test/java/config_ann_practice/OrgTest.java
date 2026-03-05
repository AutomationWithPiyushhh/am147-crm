package config_ann_practice;

import org.testng.annotations.Test;

import base_utility.BaseClass;

public class OrgTest extends BaseClass {
	@Test
	public void createOrgTest() {
		System.out.println("Org created successfully!!!");
	}
	
	@Test
	public void modifyOrgTest() {
		System.out.println("Org modified successfully!!!");
	}
	
	@Test
	public void deleteOrgTest() {
		System.out.println("Org deleted successfully!!!");
	}
}
