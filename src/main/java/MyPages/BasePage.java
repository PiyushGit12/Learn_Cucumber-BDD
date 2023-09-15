package MyPages;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;

	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageHeader(By locator) {
		return getElement(locator).getText();

	}

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = waitForElementPresent(locator);
			element = driver.findElement(locator);
			return element;
		} catch (Exception e) {
			System.out.println("Some error occurred while creating Element " + locator.toString());
			// e.printStackTrace();
		}
		return element;
	}

	public WebElement waitForElementPresent(By locator) {

		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			return wait.until((ExpectedConditions.presenceOfElementLocated(locator)));
		} catch (Exception e) {
			System.out.println(
					"Some errorException occurred in BasePage Method (waitForElementPresent) while Waiting for the  Element "
							+ locator.toString() + "With Message:-" + e.getLocalizedMessage());
			return null;
		}

	}

	public void waitForPageTitle(String title) {

		try {
			wait.until((ExpectedConditions.titleContains(title)));
		} catch (Exception e) {
			System.out.println(
					"Some errorException occurred in method waitForPageTitle while Waiting for the page title " + title);
			// e.printStackTrace();
		}

	}

	public List<WebElement> getListElement(By locator) {

		List<WebElement> element = null;
		try {
			element = driver.findElements(locator);
			return element;
		} catch (Exception e) {
			System.out.println("Some error occurred in method getListElement while creating List of Elements "
					+ locator.toString());
			
		}

		return element;
	}

	public void waitForImplicitWait(By locator) {

		try {
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		} catch (Exception e) {
			 System.out.println("Some error occurred while waitForImplicitWait finding Elements " + locator.toString());
			e.printStackTrace();
		}

	}

	public void refreshPage() {
		driver.navigate().refresh();

	}

	public <TPage extends BasePage> TPage getInstance(Class<TPage> pageClass) {

		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	protected boolean isPageLoaded() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		// Check if the document state is 'complete'
		boolean isPageLoaded = jsExecutor.executeScript("return document.readyState").equals("complete");

		return isPageLoaded;

	}
	
	public void addStepLog(String Message)
	{
	ExtentCucumberAdapter.addTestStepLog(Message);
	}

}
