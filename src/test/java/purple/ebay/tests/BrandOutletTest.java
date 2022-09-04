package purple.ebay.tests;

import org.testng.annotations.Test;

import purple.ebay.base.BaseClass;

public class BrandOutletTest extends BaseClass {

	@Test

	public void buyRolexWatch() {
		homePage.homepageBrandSteps();
		brandAndOutletPage.brandOuletSteps("Brand Outlet products for sale | eBay", "Up to 30% off Rolex", "https://www.ebay.com/e/fashion/rolex-021720");

	}

}
