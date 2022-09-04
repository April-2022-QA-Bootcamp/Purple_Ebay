package purple.ebay.tests;

import org.testng.annotations.Test;

import purple.ebay.base.BaseClass;

public class HelpAndContactTest extends BaseClass {

	
	@Test
	public void verifyHelpStepToCreateAcc() {
		homePage.homepageHelpSteps();
		helpPage.helpPageSteps("Customer Service", "account", "Your eBay account", "Signing up for an eBay account", "https://www.ebay.com/help/account/signing-ebay-account/signing-ebay-account?id=4191" );
		
	}
}
