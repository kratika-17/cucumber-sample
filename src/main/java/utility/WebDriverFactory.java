package utility;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

@SuppressWarnings("unused")
public class WebDriverFactory {

	public static WebDriver driver;

	public static  String browserType = "chrome";

	public WebDriverFactory() throws IllegalAccessException
	{
		setWebDriver();

	}
	public  static WebDriver create(String type) throws IllegalAccessException
	{

		switch(type.toLowerCase()) {
		case "chrome":


			String exePath = System.getProperty("user.dir")+"\\src\\test\\resources\\WebDrivers\\chromedriver.exe";

			System.setProperty("webdriver.chrome.driver", exePath);

			ChromeOptions options = new ChromeOptions();

			Map<String,Object> pref = new HashMap<String, Object>();
			pref.put("profile.exit_type", "none");
			pref.put("profile.exited_cleanly", Boolean.valueOf("True"));
			options.setExperimentalOption("prefs", pref);
			options.addArguments("--disable-notifications");
			options.addArguments("disable-infobars");

			//options.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
			//options.setCapability("exit_type", "none");				
			options.addArguments("user-data-dir=C:/Users/Raghav Sukhwal/AppData/Local/Google/Chrome/User Data/Default");


			//options.addArguments("headless","window-size=1400,800"); //to execute in headless mode
			options.addArguments("--start-maximized");



			driver = new ChromeDriver(options);
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

			break;
		default:
			throw new IllegalAccessException();
		}
		return driver;
	}

	public  WebDriver setWebDriver() throws IllegalAccessException {

		WebDriver driver = create(WebDriverFactory.browserType);

		return driver;

	}
	public   WebDriver getWebDriver() throws IllegalAccessException{

		return driver;
	}

}
