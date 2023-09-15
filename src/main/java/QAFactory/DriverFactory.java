package QAFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class DriverFactory {

	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	public WebDriver init_driver(String browser) {
		System.out.println("Launching Browser : " + browser);

		if (browser.equals("chrome")) {

			tlDriver.set(new ChromeDriver());
		} else if (browser.equals("firefox")) {

			tlDriver.set(new FirefoxDriver());
		} else if (browser.equals("InternetExplorer")) {

			tlDriver.set(new InternetExplorerDriver());
		} else {
			System.out.println("Please pass the Correct Browser Value: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
	}
	/*
	 * This is used to get the driver with ThreadLocal
	 * 
	 */

	public static synchronized WebDriver getDriver() {

		return tlDriver.get();

	}

}
