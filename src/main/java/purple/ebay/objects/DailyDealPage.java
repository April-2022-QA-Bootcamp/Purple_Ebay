package purple.ebay.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import purple.ebay.commons.CommonFunctions;

public class DailyDealPage {

	WebDriver driver;
	CommonFunctions commons;

	public DailyDealPage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}


	@FindBy(xpath = "//span[text()='Featured']")
	WebElement featuredElement;

	@FindBy(xpath = "//span[text()='Spotlight Deal']")
	WebElement spotlightDealsElement;

	@FindBy(xpath = "//span[text()='Trending Deals']")
	WebElement treadingDealsElement;

	@FindBy(xpath = "//span[text()='Featured Deals']")
	WebElement featuredDealsElement;

	private void clickFeature() {
		commons.click(featuredElement);

	}

	private void verifySpotlightText(String expectedText1) {
		assertEquals(commons.getText(spotlightDealsElement), expectedText1);
	}

	private void verifyTrendingText(String expectedText2) {
		assertEquals(commons.getText(treadingDealsElement), expectedText2);
	}

	private void verifyFeaturedDealsText(String expectedText3) {
		assertEquals(commons.getText(featuredDealsElement), expectedText3);
	}
	
	private void verifyCurrentUrl(String expextedUrl) {
		assertEquals(commons.getCurrentUrl(driver), expextedUrl);
	}


	public void homePageDailyDealsSteps(String expectedText1, String expectedText2,
			String expectedText3, String expectedUrl) {
		clickFeature();
		verifySpotlightText(expectedText1);
		verifyTrendingText(expectedText2);
		verifyFeaturedDealsText(expectedText3);
		verifyCurrentUrl(expectedUrl);
	}
	



}
