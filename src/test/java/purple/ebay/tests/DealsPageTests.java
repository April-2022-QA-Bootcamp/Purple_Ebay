package purple.ebay.tests;

import org.testng.annotations.Test;

import purple.ebay.base.BaseClass;

public class DealsPageTests extends BaseClass {

	@Test
	public void dealsPageTesting() {
		homePage.homePageDealsStep();
		dealPage.homePageDailyDealsSteps("SPOTLIGHT DEAL", "TRENDING DEALS", "FEATURED DEALS", "https://www.ebay.com/deals");
	}
}
