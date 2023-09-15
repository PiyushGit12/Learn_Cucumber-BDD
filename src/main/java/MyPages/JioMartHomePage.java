package MyPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JioMartHomePage extends BasePage {

	public JioMartHomePage(WebDriver driver) {
		super(driver);
		if (!isPageLoaded()) {
			throw new IllegalStateException("Page not loaded successfully");
		}

	}

	private By SliderLinks = By
			.xpath("//div[contains(@class,'swiper-pagination customise-pagination main-home-pagination6313')]/span");

	private By previousSlideArrow = By
			.xpath("//*[contains(@class,'swiper-button-prev swiper-home-btn-prev swiper-home-btn-prev6313')]");
	private By nextSlideArrow = By
			.xpath("//*[contains(@class,'swiper-button-next swiper-home-btn-next swiper-home-btn-next6313')]");

	public boolean clickAllSliderOption() {

		boolean flag = false;
		List<WebElement> allSliderOptions = getListElement(SliderLinks);
		for (WebElement e : allSliderOptions) {
			e.click();
			String slide = e.getAttribute("class");
			String label = e.getAttribute("aria-label");

			if (slide.contains("swiper-pagination-bullet-active")) {
				System.out.println("Clciked on - " + label);
				addStepLog("Clciked on - " + label);
				flag = true;
			}

		}
		return flag;

	}

	public boolean checkPreviousArrowButtonIsDislplayed() {
		boolean flag = false;
		WebElement previousSliderArrow = getElement(previousSlideArrow);
		boolean ispreviousSlideArrowDislplayed = previousSliderArrow.isDisplayed();
		if (ispreviousSlideArrowDislplayed == true) {
			previousSliderArrow.click();
			flag = true;
		} else {
			System.out.println("Previous Slider Arrow Button is Not Displayed on WebPage");
		}
		return flag;
	}

	public boolean checkNextArrowButtonIsDislplayed() {
		boolean flag = false;
		WebElement nextSliderArrow = getElement(nextSlideArrow);
		boolean isNextSlideArrowDislplayed = nextSliderArrow.isDisplayed();
		if (isNextSlideArrowDislplayed == true) {
			nextSliderArrow.click();
			System.out.println("previousSliderArrow Button is Displayed");
			flag = true;
		} else {
			System.out.println("previousSliderArrow Button is Not Displayed on WebPage");
		}
		return flag;
	}

	public boolean checkNextArrowButtonIsClickable() {
		boolean flag = false;
		List<WebElement> allSliderOptions = getListElement(SliderLinks);
		for (WebElement e : allSliderOptions) {
			waitForElementPresent(nextSlideArrow);
			getElement(nextSlideArrow).click();
			flag = true;
			String slide = e.getAttribute("class");
			String label = e.getAttribute("aria-label");

			if (slide.contains("swiper-pagination-bullet-active")) {
				System.out.println("Clicked Using Next Slider Button on - " + label);

			}

		}
		return flag;
	}

	public boolean checkPreviousArrowButtonIsClickable() {
		boolean flag = false;
		List<WebElement> allSliderOptions = getListElement(SliderLinks);
		for (WebElement e : allSliderOptions) {
			waitForElementPresent(previousSlideArrow);
			getElement(previousSlideArrow).click();
			flag = true;
			String slide = e.getAttribute("class");
			String label = e.getAttribute("aria-label");

			if (slide.contains("swiper-pagination-bullet-active")) {
				System.out.println("Clicked Using Previous Slider Button on - " + label);
			}

		}
		return flag;
	}

}
