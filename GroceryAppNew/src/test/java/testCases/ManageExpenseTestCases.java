package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constants.CONSTANT;
import elementRepository.LoginPage;
import elementRepository.ManageExpense;
import utilities.ExcelReadUtils;

public class ManageExpenseTestCases extends BaseClass {
	LoginPage lp;
	ManageExpense me;

	@Test(enabled = false)
	public void verifyTextofNewinExpenseCategoryofManageExpenseTab() throws IOException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0, "Sheet1"), ExcelReadUtils.read(1, 1, "Sheet1"));
		me = new ManageExpense(driver);
		me.enterManageExpense();
		me.enterExpenseCaregory();
		String actual = me.newText();
		String expected = CONSTANT.manageExpenseNewText;
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);

	}

	@Test(enabled = false)
	public void verifyDropdownofUserinManageExpenseSubmenu() throws IOException {
		lp = new LoginPage(driver);
		lp.getUserName(ExcelReadUtils.read(1, 0, "Sheet1"));
		lp.getPassword(ExcelReadUtils.read(1, 1, "Sheet1"));
		lp.enterSignIn();
		me = new ManageExpense(driver);
		me.enterManageExpense();
		me.enterManageExpensesub();
		me.clickNew();
		String actual = me.selectuserDropDown();
		String expected = CONSTANT.manageExpenseDropDownText;
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertionDropDown);

	}

	@Test(priority = 2)
	public void verifyViewMoreisExpandableinListExpenseofManageExpensetab() throws IOException, InterruptedException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0, "Sheet1"), ExcelReadUtils.read(1, 1, "Sheet1"));
		me = new ManageExpense(driver);
		me.enterManageExpense();
		me.enterManageExpensesub();
		me.scrolldown();
		boolean actual = me.clickViewMore();
		boolean expected = true;
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);

	}

	@Test(priority = 1)
	public void verifyTitleinExpenseCategoryinManageExpenseTab() throws IOException {
		lp = new LoginPage(driver);
		lp.performLogin(ExcelReadUtils.read(1, 0, "Sheet1"), ExcelReadUtils.read(1, 1, "Sheet1"));
		me = new ManageExpense(driver);
		me.enterManageExpense();
		me.enterExpenseCaregory();
		me.clickNew();
		me.getRandom();
		me.clickSave();
		String actual = me.alerttext();
		String expected = CONSTANT.alertText;
		Assert.assertEquals(actual, expected, CONSTANT.errorMessageAssertion);

	}

}
