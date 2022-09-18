package purple.ebay.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import purple.ebay.commons.CommonFunctions;

public class BrandAndOutletPage {

	WebDriver driver;
	CommonFunctions commons;

	public BrandAndOutletPage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;

	}

	@FindBy(id = "gh-p-4")
	WebElement brandOutletElement;

	@FindBy(xpath = "//span[contains(text(),'Watches')]")
	WebElement watchElement;

	@FindBy(xpath = "//a[text()='Rolex - Up to 30% off']")
	WebElement rolexDiscountElement;

	@FindBy(xpath = "//span[text()='Up to 30% off Rolex']")
	WebElement pageTextElement;

	@FindBy(className = "title-banner__layer__info")
	WebElement imageAtLeftElement;

	@FindBy(xpath = "//div[@class='title-banner__right-image']")
	WebElement imageAtRightElement;

	private void pageTitle(String expectedTitle) {
		assertEquals(commons.getTitle(driver), expectedTitle);
	}

	private void clickingBrandOutlet() {
		commons.click(brandOutletElement);
	}

	private void clickAtWatches() {
		commons.click(watchElement);
	}

	private void clickAtRolex() {
		commons.click(rolexDiscountElement);
	}

	private void verifyText(String expectedText) {
		assertEquals(commons.getText(pageTextElement), expectedText);
	}

	private void verifyLeftImage() {
		commons.isDisplayed(imageAtLeftElement);
	}

	private void verifyRightImage() {
		commons.isDisplayed(imageAtRightElement);
	}

	private void verifyCurrentUrl(String expectedUrl) {
		assertEquals(commons.getCurrentUrl(driver), expectedUrl);
	}

	public void brandOuletSteps(String expectedTitle, String expectedText, String expectedUrl) {

		pageTitle(expectedTitle);
		clickingBrandOutlet();
		clickAtWatches();
		clickAtRolex();
		verifyText(expectedText);
		verifyLeftImage();
		verifyRightImage();
		verifyCurrentUrl(expectedUrl);
	}

}
