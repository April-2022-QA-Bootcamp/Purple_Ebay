package purple.ebay.objects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import purple.ebay.commons.CommonFunctions;

public class DailyDealPage {
	
	
	WebDriver driver;
	CommonFunctions commons;
	
	public DailyDealPage(WebDriver driver, CommonFunctions commons) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.commons = commons;
	}
	
	
	@FindBy(tagName = "//h1")
	WebElement headerElement;
	
	@FindBy(css = "input.gh-tb.ui-autocomplete-input")
	WebElement searchFieldElement;
	
	@FindBy(id = "gh-btn")
	WebElement searchButtnElement;
	
	@FindBy(xpath = "//span[text()='car models']")
	WebElement header2textElement;
	
	@FindBy(xpath = "//a[@id='nav_1430963']")
	WebElement featuredElement;
	
	@FindBy(xpath = "//span[text()='Spotlight Deal']")
	WebElement spotlightHeaderElement;
	
	@FindBy(xpath = "//span[text()='Trending Deals']")
	WebElement treadingDealsElement;
	
	
	
	private void headerTagName(String expectedHeader) {
		assertEquals(commons.getText(headerElement),expectedHeader );
	}
	
	private void inputSearch(String value) {
		commons.inputValues(searchFieldElement, value);
	}
	
	private void clickSearch() {
		commons.click(searchButtnElement);
		
	}
	private void verifyHeader2Text(String expectedSubHeader) {
		assertEquals(commons.getText(header2textElement), expectedSubHeader);
	}
	
	private void clickFeature() {
		commons.click(featuredElement);
	}
	
	
		
	
	
}
