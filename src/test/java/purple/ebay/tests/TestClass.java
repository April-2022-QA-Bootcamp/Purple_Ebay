package purple.ebay.tests;

import org.testng.annotations.Test;

import purple.ebay.base.BaseClass;

public class TestClass extends BaseClass {
	
	@Test(groups = "rolex")

	public void buyRolexWatch() {
		homePage.homepageBrandSteps();
		brandAndOutletPage.brandOuletSteps("Brand Outlet products for sale | eBay", "Up to 30% off Rolex", "https://www.ebay.com/e/fashion/rolex-021720");

	}
	
	@Test(groups = "deals")
	public void dealsPageTesting() {
		homePage.homePageDealsStep();
		dealPage.homePageDailyDealsSteps("SPOTLIGHT DEAL", "TRENDING DEALS", "FEATURED DEALS", "https://www.ebay.com/deals");
	}
	
	@Test(groups = "helps")
	public void verifyHelpStepToCreateAcc() {
		homePage.homepageHelpSteps();
		helpPage.helpPageSteps("Customer Service", "account", "Your eBay account", "Signing up for an eBay account", "https://www.ebay.com/help/account/signing-ebay-account/signing-ebay-account?id=4191" );
		
	}

}
