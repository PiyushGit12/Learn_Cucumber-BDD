package StepDefinitions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import MyPages.JioMartFooterPage;
import QAFactory.DriverFactory;
import io.cucumber.java.en.*;


public class JioMartFooterSteps {

	JioMartFooterPage JioMartFooterPage = new JioMartFooterPage(DriverFactory.getDriver());

	@When("get all the Text present in All Categories Section")
	public void get_all_the_text_present_in_all_categories_section() {
		try {
			List<String> allActualCategoriesLinksText = JioMartFooterPage.getAllCategoriesLinksTextFromFooter();
			List<String> allExpectedCategoriesLinksText = new ArrayList<>(Arrays.asList("Grocery", "Electronics",
					"Fashion", "Beauty", "Home & Kitchen", "Premium Fruits", "Books", "Furniture"));

			ExtentCucumberAdapter.getCurrentStep().log(Status.INFO,
					"allActualCategoriesLinksText:- " + MarkupHelper.createOrderedList(allActualCategoriesLinksText));
			ExtentCucumberAdapter.getCurrentStep().log(Status.INFO, "allExpectedCategoriesLinksText:- "
					+ MarkupHelper.createOrderedList(allExpectedCategoriesLinksText));

			if (allActualCategoriesLinksText.equals(allExpectedCategoriesLinksText) == true) {
				Assert.assertEquals(allActualCategoriesLinksText, allExpectedCategoriesLinksText);
				System.out.println("Texts Dislplayed on webPage is Expected and visible on WebPage.");
				ExtentCucumberAdapter.getCurrentStep().log(Status.PASS,
						"Texts Dislplayed on webPage is Expected and visible on WebPage.");
			} else {
				Assert.assertEquals(allActualCategoriesLinksText, allExpectedCategoriesLinksText);
				System.out.println("Texts Dislplayed on webPage is NOT Expected and visible on WebPage.");
				ExtentCucumberAdapter.getCurrentStep().log(Status.FAIL,
						"Texts Dislplayed on webPage is NOT Expected and visible on WebPage.");
			}

		} catch (Exception e) {
			JioMartFooterPage.addStepLog("Some Exception occured :- " + e.getMessage());
		}

	}

	@And("get all the Links present in All Categories Section")
	public void get_all_the_links_present_in_all_categories_section() {

		try {
			System.out.println("Not Implemented");
		} catch (Exception e) {

		}
	}

	@Then("Validate the Text and Links present as Expected in UI")
	public void validate_the_text_and_links_present_as_expected_in_ui() {
		System.out.println("Not Implemented");
	}

}
