package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;
import utilities.RandomGeneratorUtils;

public class ManageOrders {
	GeneralUtilities gu = new GeneralUtilities();
	RandomGeneratorUtils ru = new RandomGeneratorUtils();
	WebDriver driver;

	public ManageOrders(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-th-large']")
	WebElement dashBoard;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-order']")
	WebElement listOrder;
	@FindBy(xpath = "//a[@data-target='#mymodal2704']")
	WebElement changeDate;
	@FindBy(xpath = "(//form[@action='https://groceryapp.uniqassosiates.com/admin/Order/update_date'])[1]//input[@type='date']")
	WebElement datePicker;
	@FindBy(xpath = "(//form[@action='https://groceryapp.uniqassosiates.com/admin/Order/update_date'])[1]//input[@id='basicExample']")
	WebElement time1;
	@FindBy(xpath = "(//form[@action='https://groceryapp.uniqassosiates.com/admin/Order/update_date'])[1]//input[@id='basicExample1']")
	WebElement time2;
	@FindBy(xpath = "(//form[@action='https://groceryapp.uniqassosiates.com/admin/Order/update_date'])[1]//button[@type='submit']")
	WebElement update;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alert;

	public void clickDashBoard() {
		gu.getClickElement(dashBoard);
	}

	public void clickMoreInfo() {
		gu.getClickElement(listOrder);
	}

	public void changeDelieryDate() {
		gu.getClickElement(changeDate);
	}

	public void enterDate() {
		// gu.getClickElement(changeDate);
		datePicker.sendKeys("23-05-2023");
	}

	public void timefrom() {
		time1.clear();
		time1.sendKeys("7:30pm");
	}

	public void timeTo() {
		time2.clear();
		time2.sendKeys("8:30pm");
	}

	public void clickUpdate() {
		gu.getClickElement(update);
	}

	public String alerttext() {
		return gu.getElementText(alert);
	}

}
