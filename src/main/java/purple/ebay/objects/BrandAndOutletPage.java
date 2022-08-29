package purple.ebay.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;

import purple.ebay.commons.CommonFunctions;

public class BrandAndOutletPage {

	WebDriver driver;
	CommonFunctions commons;

	public BrandAndOutletPage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;

	}

	@FindBy(xpath = "//span[contains(text(),'Watches')]")
	WebElement watchElement;

	@FindBy(xpath = "//a[text()='Rolex - Up to 30% off']")
	WebElement rolexDiscountElement;

	@FindBy(id = "w_1661754905524_cbx")
	WebElement selectMeElement;

	@FindBy(xpath = "//h3[text()='ROLEX 18kt Rose Gold Daytona Leather Strap Black Rose Panda 116515 SANT BLANC']")
	WebElement choose18ktRolexElement;

	@FindBy(xpath = "//a[contains(text(),'Buy It Now')]")
	WebElement buyItNowElement;

	@FindBy(tagName = "h1")
	WebElement headerElement;

	@FindBy(css = "input#userid")
	WebElement inputEmailElement;

	@FindBy(name = "signin-continue-btn")
	WebElement continuElement;

	@FindBy(xpath = "//p[@id='errormsg']")
	WebElement errorMsgElement;

	private void pageTitle(String expectedTitle) {
		assertEquals(commons.getTitle(driver), expectedTitle);
	}

	private void clickAtWatches() {
		commons.click(watchElement);
	}

	private void clickAtRolex() {
		commons.click(rolexDiscountElement);
	}

	private void clickAtMen() {
		commons.click(selectMeElement);

	}

	private void clickAt18kRolex() {
		commons.click(choose18ktRolexElement);
	}

	private void clickingBuyItNow() {
		commons.click(buyItNowElement);
	}

	private void verifyHeader(String expectedHeader) {
		assertEquals(commons.getText(headerElement), expectedHeader);
	}

	private void typeEmail(String value) {
		commons.inputValues(inputEmailElement, value);
	}

	private void verifyContinue() {
		commons.buttonEnabled(continuElement);
	}

	private void clickAtContinue() {
		commons.click(continuElement);
	}

	private void verifyErrorMsg(String expectedMsg) {
		assertEquals(commons.getText(errorMsgElement), expectedMsg);
	}

	private void verifyCurrentUrl(String expectedUrl) {
		assertEquals(commons.getCurrentUrl(driver), expectedUrl);
	}

	public void brandOuletSteps(String expectedTitle, String expectedHeader, String value, String expectedMsg,
			String expectedUrl) {
		pageTitle(expectedTitle);
		clickAtWatches();
		clickAtRolex();
		clickAtMen();
		clickAt18kRolex();
		clickingBuyItNow();
		verifyHeader(expectedHeader);
		typeEmail(value);
		verifyContinue();
		clickAtContinue();
		verifyErrorMsg(expectedMsg);
		verifyCurrentUrl(expectedUrl);
	}

}
