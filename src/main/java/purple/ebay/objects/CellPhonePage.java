package purple.ebay.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import purple.ebay.commons.CommonFunctions;

public class CellPhonePage {
	WebDriver driver;
	CommonFunctions commons;

	public CellPhonePage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}

	@FindBy(xpath = ("//h1[@class='b-pageheader']/span"))
	WebElement pageHeaderWebElement;

	@FindBy(xpath = "//*[@id=\"gh-logo\"]")
	WebElement ebayLogoElement;

	@FindBy(xpath = "//h2[contains(text(),'Shop by Brand')]")
	WebElement textOfByBrandShopElement;

	@FindBy(xpath = ("//button/i[contains(text(),'Notification')]"))
	WebElement notificationBtnElement;

	@FindBy(xpath = ("//div[contains(text(),'Unlocked Cell Phones')]"))
	WebElement uCellPhoneWebElement;

	@FindBy(xpath = ("(//*[contains(text(),'Limited Time Deals')])[1]"))
	WebElement limitedTimeDealWebElement;

	private void getCurrentUrlCpPage(String expectedUrl) {
		assertEquals(commons.getCurrentUrl(driver), expectedUrl);
	}
	
	private void getTitle() {
		commons.getTitle(driver);
	}
	
	private void getPageHeader(String expectedPageHeader) {
		assertEquals(commons.getText(pageHeaderWebElement), expectedPageHeader);
	}
	
	private void isEbayLogoDisplayed() {
		commons.isDisplayed(ebayLogoElement);
		}
	
	private void isClickableNotificationBtn() {
		commons.buttonEnabled(notificationBtnElement);
	}
	
	private void getTextBybrandShop(String expectedTextOfByBrandShop) {
		assertEquals(commons.getText(textOfByBrandShopElement), expectedTextOfByBrandShop);
		
	}
	
	private void getUcellPhoneText(String expectedUcellPhoneText) {
		assertEquals(commons.getText(uCellPhoneWebElement), expectedUcellPhoneText);	
	}
	
	private void isUcellPhoneEnabled() {
		commons.buttonEnabled(uCellPhoneWebElement);
		}
	
	private void isLimitedTimeDealDisplayed() {
		commons.isDisplayed(limitedTimeDealWebElement);
	}
	
	
	public void cellPage(String expectedUrl, String expectedPageHeader, String expectedTextOfByBrandShop,
			String expectedUcellPhoneText) {
		getCurrentUrlCpPage(expectedUrl);
		getTitle();
		getPageHeader(expectedPageHeader);
		isEbayLogoDisplayed();
		isClickableNotificationBtn();
		getTextBybrandShop(expectedTextOfByBrandShop);	
		isUcellPhoneEnabled();
		getUcellPhoneText(expectedUcellPhoneText);
		isLimitedTimeDealDisplayed();
	}
//	expected result
//	("https://www.ebay.com/b/Cell-Phones-Smart-Watches-Accessories/15032/bn_1865441",
//			"Cell Phones, Smart Watches & Accessories", "Shop by Brand", "Unlocked Cell Phones")

}
