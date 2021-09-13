package org.personal.dataprovidertests;

import org.personal.dataprovider.DataProviderDemo;
import org.testng.annotations.Test;

public class DemoTest {

	
	@Test(dataProvider="getData" , dataProviderClass=DataProviderDemo.class)
	public void test1(String username)
	{
		System.out.println(username);
	}
}
