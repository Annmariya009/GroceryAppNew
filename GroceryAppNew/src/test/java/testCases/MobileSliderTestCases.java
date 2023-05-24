package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import elementRepository.LoginPage;
import elementRepository.MobileSlider;
import utilities.ExcelReadUtils;

public class MobileSliderTestCases extends BaseClass {
	LoginPage lp;
	MobileSlider ms;

	@Test
	public void verifyAlertTextinMobileSliderTab() throws AWTException, IOException, InterruptedException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0, "Sheet1"), ExcelReadUtils.read(1, 1,"Sheet1"));
		ms = new MobileSlider(driver);
		ms.clickMobileSlider();
		ms.clickNew();
		ms.selectCategory();
		//ms.imageUpload(null);
		ms.fileUpload();
		
		Thread.sleep(3000);
		ms.clickSave();
		String actual = ms.alerttext();
		String expected = "Alert!";
		Assert.assertEquals(actual, expected, "Text is not matching");

	}
}
