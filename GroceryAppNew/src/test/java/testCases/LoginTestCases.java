package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.CONSTANT;

import elementRepository.LoginPage;

public class LoginTestCases extends BaseClass {
	LoginPage lp;

	@Test(groups = { "High" })
	public void verifyLoginButtonText() {
		lp = new LoginPage(driver);
		String actual = lp.signInText();
		String expected = "Sign In";
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);
	}

	@Test(groups = { "Critical" })
	public void verifyLoginButtonBackgroundColor() {
		lp = new LoginPage(driver);
		String actual = lp.getBackgroundcolorofSignIn();
		String expected = CONSTANT.loginButtonBackgroundColor;
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);

	}

	@Test(dataProvider = "loginPageSuccessfullogin",dataProviderClass=DataProviderTestCase.class)
	public void verifySucessFullLogin(String username, String password) {
		lp = new LoginPage(driver);
		lp.getUserName(username);
		lp.getPassword(password);
		lp.enterSignIn();
		boolean actual = lp.titleDisplay();
		boolean expected = true;
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);

	}

	@Test(dataProvider = "loginPageUnsuccessfullogin",dataProviderClass =DataProviderTestCase.class)
	public void verifyUnSucessFullLogin(String username1, String password1) {
		lp = new LoginPage(driver);
		lp.getUserName(username1);
		lp.getPassword(password1);
		lp.enterSignIn();
		boolean actual = lp.failedfLoginAlert();
		boolean expected = true;
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);

	}

}
