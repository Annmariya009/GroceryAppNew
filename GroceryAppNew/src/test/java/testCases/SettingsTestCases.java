package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.CONSTANT;
import elementRepository.LoginPage;
import elementRepository.SettingsPage;
import utilities.ExcelReadUtils;

public class SettingsTestCases extends BaseClass {
	LoginPage lp;
	SettingsPage sp;

	@Test
	public void verifySaveButtonandInputTextfieldsofMenuManagementofSettingsTab() throws IOException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0, "Sheet1"), ExcelReadUtils.read(1, 1, "Sheet1"));
		sp = new SettingsPage(driver);
		sp.clickSettings();
		sp.clickManageMenu();
		sp.clickNew();
		sp.inputText(ExcelReadUtils.read(1, 0, "Sheet2"), ExcelReadUtils.read(1, 1, "Sheet2"),
				ExcelReadUtils.readIntegerData(1, 2, "Sheet2"), ExcelReadUtils.read(1, 3, "Sheet2"));
		sp.getScrollDown();
		sp.clickSave();
		String actual = sp.alerttext();
		String expected = CONSTANT.alertText;
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);
	}
}
