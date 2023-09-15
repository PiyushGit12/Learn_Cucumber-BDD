package StepDefinitions;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import QAFactory.DriverFactory;
import io.cucumber.java.en.*;

public class stepDefs {

	@Given("I open the Browser and  navigate to the URL {string}")
	public void i_open_the_browser_and_navigate_to_the_url(String string) {
		DriverFactory.getDriver().get(string);
		ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "Navigated_to_the_URL:- " + string);

	}

	@Then("capture the Title of the Page")
	public void capture_the_title_of_the_page() {
		String title = DriverFactory.getDriver().getTitle();
		System.out.println("Title of the page is :-> " + title);
		ExtentCucumberAdapter.getCurrentStep().log(Status.PASS, "Captured the Title Of the Page:- " + title);

	}

}
