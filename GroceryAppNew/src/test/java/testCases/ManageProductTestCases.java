package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.CONSTANT;
import elementRepository.LoginPage;
import elementRepository.ManageProduct;
import utilities.ExcelReadUtils;

public class ManageProductTestCases extends BaseClass {
	LoginPage lp;
	ManageProduct mp;

	@Test
	public void verifyNonvegRadioButtoninManageProductTab() throws IOException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0, "Sheet1"), ExcelReadUtils.read(1, 1, "Sheet1"));
		mp = new ManageProduct(driver);	
		mp.enterManageProduct();
		mp.clickNew();
		mp.clickRadioButton();
		boolean actual = mp.verifyRadioButton();
		boolean expected = true;
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertionRadioButton);
	}
}
