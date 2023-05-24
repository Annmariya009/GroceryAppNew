package elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtilities;

public class ManageLocation {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public ManageLocation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//i[@class='nav-icon fas fa-map-marker']")
	WebElement manageLocation;
	@FindBy(id = "country_id")
	WebElement country;
	@FindBy(id = "st_id")
	WebElement state;
	@FindBy(id = "location")
	WebElement location;
	@FindBy(id = "delivery")
	WebElement deliveryRate;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	
	public void clickManageLocation() {
		gu.getClickElement(manageLocation);
	}
	public void clickNew() {
		newButton.click();

	}
	public void getCountryDropdown() {
		gu.getDropDownSelect1(country, 1);
	}
	public void getStateDropDown() {
		gu.getDropDownSelect1(state, 5);
	}

}
