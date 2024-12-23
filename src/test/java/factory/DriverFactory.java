package factory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utils.CommonUtils;

public class DriverFactory {
	static WebDriver driver=null;

	public static WebDriver intializeBrowser(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			//System.setProperty("webdriver.chrome.driver", "C:\\Users\\naveenbabu.koripalli\\Desktop\\AgencyPortal_5x_Selenium_XML\\TutorialsNinjaProj\\driver\\chromedriver-win64\\chromedriver.exe");

		}else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		else {
			driver = new EdgeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(CommonUtils.PAGE_LOAD_TIME));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(CommonUtils.IMPLICIT_WAIT_TIME));
		return driver;
	}

	public static WebDriver getDriver() {

		return driver;
	}
}
