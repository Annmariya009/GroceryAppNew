package elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.RandomGeneratorUtils;

public class ManageExpense {
	GeneralUtilities gu = new GeneralUtilities();
	RandomGeneratorUtils ru = new RandomGeneratorUtils();
	WebDriver driver;

	public ManageExpense(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this); // page factory

	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-money-bill-alt']")
	WebElement ManageExpense;
	@FindBy(xpath = "//p[text()='Manage Expense']")
	WebElement clickOnManageExpense;
	@FindBy(xpath = "//p[text()='Expense Category']")
	WebElement expenseCategory;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//select[@id='user_id']")
	WebElement userDropDown;
	@FindBy(xpath = "//tr[@class='detail-row open']")
	WebElement open;
	@FindBy(id = "name")
	WebElement title;
	@FindBy(name = "Create")
	WebElement save;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alert;

	public void enterManageExpense() {
		ManageExpense.click();
	}

	public void enterExpenseCaregory() {
		expenseCategory.click();
	}

	public String newText() {
		return gu.getElementText(newButton);
	}

	public void enterManageExpensesub() {
		clickOnManageExpense.click();
	}

	public void clickNew() {
		newButton.click();

	}

	public String selectuserDropDown() {
		return gu.getDropDownSelect(userDropDown, 2);
	}

	public boolean clickViewMore() throws InterruptedException {
		int rowValue = gu.getDynamicTable(driver,
				"//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]",
				"Fruits436335261 (Dwd-DB)");
		String locator = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[" + rowValue
				+ "]//td[8]//a[1]";
		WebElement viewMore = driver.findElement(By.xpath(locator));
		viewMore.click();

		boolean value = false;
		// String s=open.getAttribute("class");

		if (open.getAttribute("class").contains("detail-row open")) {
			value = true;
		} else {
			value = false;

		}
		return value;

	}

	public void getRandom() {
		title.sendKeys( ru.getRandomstring(3));
	}

	public void clickSave() {
		gu.getClickElement(save);
	}

	public String alerttext() {
		return gu.getElementText(alert);
	}
	public void scrolldown() {
		gu.getPageScroll(driver, 0, 4000);
	}
}
