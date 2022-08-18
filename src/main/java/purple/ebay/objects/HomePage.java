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
	//su1
	@FindBy(xpath = ("//button[contains(text(),'Shop by category')]"))
	WebElement shopByBtnWebElement;
	//su2
	@FindBy(xpath = ("//a[contains(text(),'Cell Phones, Smart Watches & Accessories')]"))
	WebElement cellBtnWebElement;
	
	
	//su3
	private void clickShopByCategoryBtn() {
		commons.click(shopByBtnWebElement);
	}
	//su4
	private void clickCellBtn() {
		commons.click(cellBtnWebElement);
	}
	
	
	
	//su5
public void homepageShopByCategory(String expectedSubTitle) {
		clickShopByCategoryBtn();
		clickCellBtn();

	}
	
}
