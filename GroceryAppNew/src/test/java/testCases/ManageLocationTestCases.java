package testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.ManageLocation;
import utilities.ExcelReadUtils;

public class ManageLocationTestCases extends BaseClass {
	LoginPage lp;
	ManageLocation ml;

	@Test
	public void verifyDropDownofAddLocationsinManageLocationTab() throws IOException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0, "Sheet1"), ExcelReadUtils.read(1, 1, "Sheet1"));
		ml=new ManageLocation(driver);
		ml.clickManageLocation();
		ml.clickNew();
		ml.getCountryDropdown();
		ml.getStateDropDown();
	}
}
