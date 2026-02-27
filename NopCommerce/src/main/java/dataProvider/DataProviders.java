package dataProvider;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="email")
	public Object[][] getEmail()
	{
		return new Object[][]{{"harsh.goel@nagarro.com"},{"goel.@gmail.com"}};
	}
	
	@DataProvider(name="product")
	public Object[][] Product()
	{
		return new Object[][]{{"iphone"},{"Samsung Tab s4"}};
	}
}
