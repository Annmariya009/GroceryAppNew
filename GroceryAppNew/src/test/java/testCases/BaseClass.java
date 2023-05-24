package testCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import utilities.ScreenshotUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	WebDriver driver;
	ScreenshotUtils sc;
	public static Properties prop;

	public static void testBasic() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//resources//Properties//Config.properties");
		prop.load(ip);
	}

//	@BeforeMethod
//	//@Parameters("browser")
//	public void beforeMethod() throws IOException {
//		//if (browser.equals("chrome")) {
//			testBasic();
//			driver = new ChromeDriver();
//			// } else if (browser.equals("edge")) {
//			 //driver = new EdgeDriver();
//
//			driver.get(prop.getProperty("BaseURL"));
//			driver.manage().window().maximize();
//		//}
//		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
//	}
//
//	@AfterMethod
//	public void afterMethod(ITestResult itestResult) throws IOException {
//		if (itestResult.getStatus() == ITestResult.FAILURE) {
//			sc = new ScreenshotUtils();
//			sc.captureScreenshotFailures(driver, itestResult.getName());
//		}
//		driver.close();
//	}
//	}
//
	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")
	public void beforeMethod(String browser) throws IOException {
		if (browser.equals("chrome")) {
			testBasic();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			EdgeOptions ops = new EdgeOptions();
			ops.addArguments("--remote-allow-origins=*");
			driver = new EdgeDriver();

			
		}
		driver.get(prop.getProperty("BaseURL"));
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
	}

	@AfterMethod(alwaysRun = true)
	public void afterMethod(ITestResult itestResult) throws IOException {
		if (itestResult.getStatus() == ITestResult.FAILURE) {
			sc = new ScreenshotUtils();
			sc.captureScreenshotFailures(driver, itestResult.getName());
		}
		driver.close();
	}

}
