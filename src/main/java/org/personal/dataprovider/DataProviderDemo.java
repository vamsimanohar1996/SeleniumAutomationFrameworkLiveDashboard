package org.personal.dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviderDemo {
	
	
	public DataProviderDemo(String a,String b)
	{
		a="Fin";
		b="K";
	}

	@DataProvider
	public static String[] getData() {
		String[] a = { "Vamsi", "Manohar", "K" };

		return a;
	}

}
