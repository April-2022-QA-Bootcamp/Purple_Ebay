package purple.ebay.objects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import purple.ebay.commons.CommonFunctions;

public class HomePage {

	WebDriver driver;
	CommonFunctions commons;

	public HomePage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}

	
	
	@FindBy(xpath = "//a[contains(text(),'Daily Deals')]")
	WebElement dailyDealsElement;
	
	// su1
	@FindBy(xpath = ("//button[contains(text(),'Shop by category')]"))
	WebElement shopByBtnWebElement;
	// su2
	@FindBy(xpath = ("//a[contains(text(),'Cell Phones, Smart Watches & Accessories')]"))
	WebElement cellBtnWebElement;

	@FindBy(xpath = "//a[contains(text(),'Brand Outlet')]")
	WebElement brandAndoutletElement;

	@FindBy(xpath = "//a[contains(text(),'Help & Contact') and @class='gh-p']")
	WebElement helpAndContactElement;

	// su3
	private void clickShopByCategoryBtn() {
		commons.click(shopByBtnWebElement);
	}

	// su4
	private void clickCellBtn() {
		commons.click(cellBtnWebElement);
	}

	private void verifyBrandandOutlet() {
		commons.buttonEnabled(brandAndoutletElement);
	}

	private void clickBrandAndOutlet() {
		commons.click(brandAndoutletElement);
	}

	private void verifyHelpAndContact() {
		commons.buttonEnabled(helpAndContactElement);
	}

	private void clickingHelpAndContact() {
		commons.click(helpAndContactElement);
	}
  
  	private void clickDailyDeal() {
		commons.click(dailyDealsElement);
		
	}
	
	public void HomePageDealsStep() {	
		clickDailyDeal();
	}

	// su5
	public void homepageShopByCategory(String expectedSubTitle) {
		clickShopByCategoryBtn();
		clickCellBtn();

	}

	public void homepageBrandSteps() {
		verifyBrandandOutlet();
		clickBrandAndOutlet();

	}

	public void homepageHelpSteps() {
		verifyHelpAndContact();
		clickingHelpAndContact();
	}


}
