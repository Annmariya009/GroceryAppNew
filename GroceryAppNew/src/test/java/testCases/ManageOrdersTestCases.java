package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.CONSTANT;
import elementRepository.LoginPage;
import elementRepository.ManageOrders;
import utilities.ExcelReadUtils;

public class ManageOrdersTestCases extends BaseClass {
	LoginPage lp;
	ManageOrders mo;

	@Test
	public void verifyTheAlertTextofSaveButtonandUpdateDateinmanageOrderTab() throws IOException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0, "Sheet1"), ExcelReadUtils.read(1, 1, "Sheet1"));
		mo = new ManageOrders(driver);
		mo.clickDashBoard();
		mo.clickMoreInfo();
		mo.changeDelieryDate();
		mo.enterDate();
		mo.timefrom();
		mo.timeTo();
		mo.clickUpdate();
		String actual = mo.alerttext();
		String expected = CONSTANT.alertText;
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);

	}

}
