package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class SettingsPage {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public SettingsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon sidebar-item-icon fa fa-cog']")
	WebElement settings;
	@FindBy(xpath = "//p[text()='Manage Menu']")
	WebElement manageMenu;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(id = "name")
	WebElement menuName;
	@FindBy(id = "url")
	WebElement urlName;
	@FindBy(id = "menu_order")
	WebElement menuOrder;
	@FindBy(id = "menu_color")
	WebElement menuColor;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alert;
	@FindBy(name = "create")
	WebElement save;

	public void clickSettings() {
		gu.getClickElement(settings);
	}

	public void clickManageMenu() {
		gu.getClickElement(manageMenu);
	}

	public void clickNew() {
		gu.getClickElement(newButton);

	}

	public  void inputText(String menu, String url, String enterMenuOrder, String color) {
		menuName.sendKeys(menu);
		urlName.sendKeys(url);
		menuOrder.clear();
		menuOrder.sendKeys(enterMenuOrder);
		menuColor.sendKeys(color);

	}
	public String alerttext() {
		return gu.getElementText(alert);
	}
	public void getScrollDown() {
		gu.getPageScroll(driver, 0, 4000);
	}
	public void clickSave() {
		gu.getClickElement(save);
	}

}
