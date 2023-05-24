package testCases;

import org.testng.annotations.DataProvider;

public class DataProviderTestCase {

	@DataProvider(name = "loginPageSuccessfullogin")
	public Object[][] dp() {
		return new Object[][] { { "admin", "admin" } };
	}

	@DataProvider(name = "loginPageUnsuccessfullogin")
	public Object[][] dpMethod1() {
		return new Object[][] { { "adm", "adin" }, { "ad", "Ad" } };
	}

}
