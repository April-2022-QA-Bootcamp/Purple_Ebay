package purple.ebay.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import purple.ebay.commons.CommonFunctions;

public class RegisterAccountPage {

	WebDriver driver;
	CommonFunctions commons;

	public RegisterAccountPage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.commons = commons;
		this.driver = driver;

	}

	@FindBy(tagName = "h1")
	WebElement headerElement;

	@FindBy(css = "input#personalaccount-radio")
	WebElement personalCheckBoxElement;

	@FindBy(css = "input#firstname")
	WebElement firstNameElement;

	@FindBy(css = "input#lastname")
	WebElement lastNameElement;

	@FindBy(css = "input#Email")
	WebElement emailElement;

	@FindBy(css = "input#password")
	WebElement passwordElement;

	@FindBy(name = "EMAIL_REG_FORM_SUBMIT")
	WebElement createAccountElement;

	@FindBy(css = "span#Email_err")
	WebElement emailErrorElement;

	private void verifyPageTitle(String expectedTitle) {
		assertEquals(commons.getTitle(driver), expectedTitle);
	}

	private void verifyHeaderTxt(String expectedText1) {
		assertEquals(commons.getText(headerElement), expectedText1);
	}

	private void verifyPersonalCheckBoxSelected() {
		commons.isSeleceted(personalCheckBoxElement);
	}

	private void inputFirstName(String firstName) {
		commons.inputValues(firstNameElement, firstName);
	}

	private void inputLastName(String lastName) {
		commons.inputValues(lastNameElement, lastName);
	}

	private void inputEmail(String email) {
		commons.inputValues(emailElement, email);
	}

	private void inputPassword(String password) {
		commons.inputValues(passwordElement, password);
	}

	private void isCreateAccButtonEnabled() {
		commons.buttonEnabled(createAccountElement);
	}

	private void verifyEmailErrorTxt(String expectedError) {
		assertEquals(commons.getText(emailErrorElement), expectedError);
	}

	public void registerPersonalAccStepsWithFailEmail(String expectedTitle, String expectedText1, String firstName,
			String lastName, String email, String password, String expectedError) {
		verifyPageTitle(expectedTitle);
		verifyHeaderTxt(expectedText1);
		verifyPersonalCheckBoxSelected();
		inputFirstName(firstName);
		inputLastName(lastName);
		inputEmail(email);
		inputPassword(password);
		isCreateAccButtonEnabled();
		verifyEmailErrorTxt(expectedError);

	}

}
