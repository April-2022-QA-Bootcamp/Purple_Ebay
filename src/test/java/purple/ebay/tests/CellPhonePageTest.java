package purple.ebay.tests;

import org.testng.annotations.Test;

import purple.ebay.base.BaseClass;

public class CellPhonePageTest extends BaseClass {
	@Test
	public void cellPhonePageTest() {
		homePage.homepageShopByCategory();
		cellPhonePage.cellPage("https://www.ebay.com/b/Cell-Phones-Smart-Watches-Accessories/15032/bn_1865441", "Cell Phones, Smartphones, Smart Watches & Accessories for Sale - eBay",
				"Cell Phones, Smart Watches & Accessories", "Shop by Brand", "Unlocked Cell Phones");
	}

}
