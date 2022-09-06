package purple.ebay.tests;

import org.testng.annotations.Test;

import purple.ebay.base.BaseClass;

public class RegisterAccountTest extends BaseClass{

	@Test
	public void accountRegisterTest() {
		homePage.homePageRegisterStep();
		registerPage.registerPersonalAccStepsWithFailEmail("Register: Create a personal account", "Create an account", "John", "Wick", "Wick420", "Class420", "Email address is invalid. Please enter a valid email address.");
	}
}
