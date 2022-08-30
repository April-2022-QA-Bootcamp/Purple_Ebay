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

	@FindBy(tagName = "//h1")
	WebElement headerElement;

	@FindBy(xpath = "//span[text()='Featured']")
	WebElement featuredElement;

	@FindBy(xpath = "//span[text()='Spotlight Deal']")
	WebElement spotlightDealsElement;

	@FindBy(xpath = "//span[text()='Trending Deals']")
	WebElement treadingDealsElement;

	@FindBy(xpath = "//span[text()='Featured Deals']")
	WebElement featuredDealsElement;

	@FindBy(css = "input.gh-tb.ui-autocomplete-input")
	WebElement searchFieldElement;

	@FindBy(id = "gh-btn")
	WebElement searchButtnElement;

	@FindBy(xpath = "//span[text()='laptop']")
	WebElement header2textElement;

	@FindBy(css = "div.slashui-image-cntr>img[src='https://i.ebayimg.com/images/g/4EgAAOSwYsxi2GWu/s-l300.jpg']")
	WebElement lenovoIdeaPad5iElement;

	@FindBy(xpath = "//span[text()='Buy It Now']")
	WebElement buyItNowWebElement;

	@FindBy(xpath = "//button[text()='No thanks']")
	WebElement noThanksElement;

	@FindBy(xpath = "input#userid")
	WebElement userIdElement;

	@FindBy(id = "signin-continue-btn")
	WebElement continueElement;

	@FindBy(id = "//p[@id='errormsg']")
	WebElement errorTextElement;

	private void headerTagName(String expectedHeader) {
		assertEquals(commons.getText(headerElement), expectedHeader);
	}

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

	private void inputSearch(String value) {
		commons.inputValues(searchFieldElement, value);
	}

	private void clickSearch() {
		commons.click(searchButtnElement);

	}

	private void verifyHeader2Text(String expectedSubHeader) {
		assertEquals(commons.getText(header2textElement), expectedSubHeader);
	}

	private void clickLenovoIdeaPad5i() {
		commons.click(lenovoIdeaPad5iElement);
	}

	private void clickBuy() {
		commons.click(buyItNowWebElement);
	}

	private void clickNo() {
		commons.click(noThanksElement);
	}

	private void inputUserId(String value2) {
		commons.inputValues(userIdElement, value2);
	}

	private void clickContinue() {
		commons.click(continueElement);
	}

	private void verifyErrorText(String expectedErrorText) {
		assertEquals(commons.getText(errorTextElement), expectedErrorText);
	}

	public void homePageDailyDealsSteps(String expectedHeader, String expectedText1, String expectedText2,
			String expectedText3, String value, String expectedSubHeader, String value2, String expectedErrorText) {
		headerTagName(expectedHeader);
		clickFeature();
		verifySpotlightText(expectedText1);
		verifyTrendingText(expectedText2);
		verifyFeaturedDealsText(expectedText3);
		inputSearch(value);
		clickSearch();
		verifyHeader2Text(expectedSubHeader);
		clickLenovoIdeaPad5i();
		clickBuy();
		clickNo();
		inputUserId(value2);
		clickContinue();
		verifyErrorText(expectedErrorText);

	}
	

/*
@FindBy(xpath = "//a[contains(text(),'Daily Deals')]")
	WebElement dailyDealsElement;
	

	private void clickDailyDeal() {
		commons.click(dailyDealsElement);
		
	}
	
	public void HomePageDealsStep() {	
		clickDailyDeal();
	}
	

*/

}
