package purple.ebay.objects;

import org.openqa.selenium.WebDriver;
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
}
