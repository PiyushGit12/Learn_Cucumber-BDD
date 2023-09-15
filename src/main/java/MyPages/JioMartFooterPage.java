package MyPages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JioMartFooterPage extends BasePage {

	public JioMartFooterPage(WebDriver driver) {
		super(driver);
		if (!isPageLoaded()) {
			throw new IllegalStateException("Page not loaded successfully");
		}
	}

	private By allCategoriesLinks = By
			.xpath("//footer/descendant::div[contains(text(),'All Categories')]/following-sibling::div/child::a");
	private By popularCategoriesLinks = By
			.xpath("//footer/descendant::div[contains(text(),'Popular Categories')]/following-sibling::div/child::a");

	private By customerAccountLinks = By
			.xpath("//footer/descendant::div[contains(text(),'Customer Account')]/following-sibling::div/child::a");

	private By HelpAndSupportLinks = By
			.xpath("//footer/descendant::div[contains(text(),'Help & Support')]/following-sibling::div/child::a");

	public List<String> getAllCategoriesLinksTextFromFooter() {

		List<String> allCategoriesTextList = new ArrayList<>();

		List<WebElement> allCategoriesLinksList = getListElement(allCategoriesLinks);
		for (int i = 0; i < allCategoriesLinksList.size(); i++) {
			String categoriesLinkText = allCategoriesLinksList.get(i).getText();
			if (!categoriesLinkText.isEmpty()) {
				allCategoriesTextList.add(categoriesLinkText);
				System.out.println("categoriesLinkText:- " + categoriesLinkText);
			}
		}
		return allCategoriesTextList;
	}
	
	public List<String> getAllCategoriesLinksFromFooter() {

		List<String> allCategoriesLinkList = new ArrayList<>();

		List<WebElement> allCategoriesLinksList = getListElement(allCategoriesLinks);
		for (int i = 0; i < allCategoriesLinksList.size(); i++) {
			String categoriesLink = allCategoriesLinksList.get(i).getAttribute("href");
			if (!categoriesLink.isEmpty()) {
				allCategoriesLinkList.add(categoriesLink);
				System.out.println("categoriesLinkText:- " + categoriesLink);
			}
		}
		return allCategoriesLinkList;
	}

}
