package purple.ebay.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import purple.ebay.commons.CommonFunctions;

public class HelpPage {

	WebDriver driver;
	CommonFunctions commons;

	public HelpPage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
		this.driver = driver;

	}

	@FindBy(xpath = "//img[@id='gh-logo']")
	WebElement logoElement;

	@FindBy(xpath = "//td[text()='Customer Service']")
	WebElement headertextElement;

	@FindBy(xpath = "//input[@role='textbox']")
	WebElement searchfieldElement;

	@FindBy(xpath = "//span[text()='Your eBay account']")
	WebElement yourEbayElement;

	@FindBy(tagName = "h1")
	WebElement articleTitleElement;

	@FindBy(xpath = "//a[text()='Setting up your account']")
	WebElement setupAccountElement;

	@FindBy(xpath = "//a[text()='Signing up for an eBay account']")
	WebElement signingUpElement;

	@FindBy(tagName = "h1")
	WebElement article2TitleElement;

	@FindBy(css = "a.icon_action_btn")
	WebElement signUpButtonElement;

	private void verifyLogo() {
		commons.isDisplayed(logoElement);
	}

	private void verifyHeaderTitle(String expectedHeader) {
		assertEquals(commons.getText(headertextElement), expectedHeader);

	}

	private void inputHelpSearch(String value) {
		commons.inputValues(searchfieldElement, value);
	}

	private void clickYourEbay() {
		commons.click(yourEbayElement);
	}

	private void verifyArticleTitle(String expectedArticle) {
		assertEquals(commons.getText(articleTitleElement), expectedArticle);

	}

	private void clickSettingAccount() {
		commons.click(setupAccountElement);
	}

	private void clickSigningUpAccount() {
		commons.click(signingUpElement);
	}

	private void verifyArticle2Title(String expectedArticle2) {
		assertEquals(commons.getText(article2TitleElement), expectedArticle2);

	}

	private void verifySignUpButton() {
		commons.buttonEnabled(signUpButtonElement);
	}

	private void clickSignUpButton() {
		commons.click(signUpButtonElement);
	}

	private void verifyCurruntUrl(String expectedUrl) {
		assertEquals(commons.getCurrentUrl(driver), expectedUrl);
	}

	public void HelpPageSteps(String expectedHeader, String value, String expectedArticle, String expectedArticle2,
			String expectedUrl) {
		verifyLogo();
		verifyHeaderTitle(expectedHeader);
		inputHelpSearch(value);
		clickYourEbay();
		verifyArticleTitle(expectedArticle);
		clickSettingAccount();
		clickSigningUpAccount();
		verifyArticle2Title(expectedArticle2);
		verifySignUpButton();
		clickSignUpButton();
		verifyCurruntUrl(expectedUrl);

	}

}
