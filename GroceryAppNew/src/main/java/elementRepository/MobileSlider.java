package elementRepository;

import java.awt.AWTException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.GeneralUtilities;

public class MobileSlider {
	GeneralUtilities gu = new GeneralUtilities();
	WebDriver driver;

	public MobileSlider(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//p[text()='Mobile Slider']")
	WebElement mobileSlider;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement newButton;
	@FindBy(xpath = "//select[@id='cat_id']")
	WebElement catogory;
	@FindBy(xpath = ".//input[@type='file']")
	WebElement chooseFile;
	@FindBy(xpath = "//h5[text()=' Alert!']")
	WebElement alert;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement save;

	public void clickMobileSlider() {
		gu.getClickElement(mobileSlider);
	}

	public void clickNew() {
		gu.getClickElement(newButton);
	}

	public void selectCategory() {
		gu.getDropDownSelect(catogory, 3);
	}

	public void imageUpload(String path) throws AWTException  {
		
		gu.getFileUpload(driver, chooseFile, path);

	}

	public void clickSave() {
		gu.getClickElement(save);
	}

	public String alerttext() {
		return gu.getElementText(alert);
	}

	public void fileUpload() {
		chooseFile.sendKeys(System.getProperty("user.dir") + "\\src\\main\\resources\\FileUpload\\vegetable.png");
	}
}
