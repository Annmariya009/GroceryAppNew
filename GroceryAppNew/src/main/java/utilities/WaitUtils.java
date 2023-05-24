package utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	public void waitClick(WebDriver driver, WebElement element) {
		WebDriverWait waitAlert = new WebDriverWait(driver, Duration.ofMillis(5000));
		waitAlert.until(ExpectedConditions.elementToBeClickable(element));
	}

}
