package StepDefinitions;

import org.junit.Assert;
import MyPages.JioMartHomePage;
import QAFactory.DriverFactory;
import io.cucumber.java.en.*;

public class JioMartHomePageSteps {

	JioMartHomePage jioMartHomePage = new JioMartHomePage(DriverFactory.getDriver());

	@Given("user should be on the Application Url {string}")
	public void user_should_be_on_the_application_url(String string) {
		DriverFactory.getDriver().get(string);
		jioMartHomePage.addStepLog("This Url " + string + " is Launched");

	}

	@When("click all the Slider pages visible on WebPage")
	public void click_all_the_slider_pages_visible_on_web_page() {
		try {
			boolean sliders = jioMartHomePage.clickAllSliderOption();
			if (sliders == true) {
				Assert.assertTrue("Clicked on all Active Silders is:- ", sliders);
				jioMartHomePage.addStepLog("Clicked all Active Silders is:-" + sliders);
			} else {
				Assert.assertFalse("Clicked on all UnActive Silders is- ", sliders);
				jioMartHomePage.addStepLog("Clicked on all UnActive Silders is:-" + sliders);
			}
		} catch (Exception e) {
			jioMartHomePage.addStepLog("Some Exception occured :- " + e.getMessage());

		}
	}

	@Then("Check the prevoius Arrow button is displayed and is Clickable")
	public void check_the_prevoius_arrow_button_is_displayed_and_is_Clickable() {

		try {
			boolean activePreviousButtton = jioMartHomePage.checkPreviousArrowButtonIsDislplayed();
			boolean isPreviousButttonClickable = jioMartHomePage.checkPreviousArrowButtonIsClickable();

			if (activePreviousButtton == true && isPreviousButttonClickable == true) {
				Assert.assertTrue("Previous Slider  Arrow Buttton is Displayed", activePreviousButtton);
				Assert.assertTrue(isPreviousButttonClickable);
				jioMartHomePage.addStepLog("Previous Slider  Arrow Buttton is Displayed :-" + activePreviousButtton
						+ "  and is Clickable :-" + isPreviousButttonClickable);
			} else {
				Assert.assertFalse("Previous Slider  Arrow Buttton is Displayed", activePreviousButtton);
				Assert.assertFalse(isPreviousButttonClickable);
				jioMartHomePage.addStepLog("Previous Slider  Arrow Buttton is Displayed :-" + activePreviousButtton
						+ "  and is Clickable :-" + isPreviousButttonClickable);
			}
		} catch (Exception e) {
			jioMartHomePage.addStepLog("Some Exception occured :- " + e.getMessage());
		}
	}

	@And("Check the Next Arrow button is displayed and is Clickable")
	public void check_the_next_arrow_button_is_displayed_and_is_Clickable() {

		try {
			boolean activeNextButtton = jioMartHomePage.checkNextArrowButtonIsDislplayed();
			boolean isNextButttonClickable = jioMartHomePage.checkNextArrowButtonIsClickable();
			if (activeNextButtton == true && isNextButttonClickable == true) {
				Assert.assertTrue("Next Slider Arrow Buttton is Displayed", activeNextButtton);
				Assert.assertTrue(isNextButttonClickable);
				jioMartHomePage.addStepLog("Next Slider  Arrow Buttton is Displayed:-- " + activeNextButtton
						+ "  and is Clickable :-" + isNextButttonClickable);
			} else {
				Assert.assertFalse("Next Slider Arrow Buttton is Displayed", activeNextButtton);
				Assert.assertFalse(isNextButttonClickable);
				jioMartHomePage.addStepLog("Next Slider  Arrow Buttton is Displayed:-- " + activeNextButtton
						+ "  and is Clickable :-" + isNextButttonClickable);
			}
		} catch (Exception e) {
			jioMartHomePage.addStepLog("Some Exception occured :- " + e.getMessage());

		}
	}

}
