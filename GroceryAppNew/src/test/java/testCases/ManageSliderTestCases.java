package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.CONSTANT;
import elementRepository.LoginPage;
import elementRepository.ManageSlider;
import utilities.ExcelReadUtils;

public class ManageSliderTestCases extends BaseClass {
	LoginPage lp;
	ManageSlider ms;

	@Test(enabled = false)
	public void verifyAlertinAddSliderofManageTab() throws IOException, AWTException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0, "Sheet1"), ExcelReadUtils.read(1, 1, "Sheet1"));
		ms = new ManageSlider(driver);
		ms.clickManangeSlider();
		ms.clickNew();
		ms.clickChoosefile();
		ms.enterLink();
		ms.clicksave();
		String actual = ms.alerttext();
		String expected = CONSTANT.alertText;
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);

	}

	@Test
	public void verifyAndChangesStatusinManageSliderTab() throws IOException, InterruptedException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0, "Sheet1"), ExcelReadUtils.read(1, 1, "Sheet1"));
		ms = new ManageSlider(driver);
		ms.clickManangeSlider();
		ms.pageScroll();
		ms.clickStatus();
		String actual = ms.alerttext();
		String expected = CONSTANT.alertText;
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);

	}

}
