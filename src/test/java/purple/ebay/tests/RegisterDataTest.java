package purple.ebay.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import purple.ebay.base.BaseClass;
import purple.ebay.utils.RegisterData;

public class RegisterDataTest extends BaseClass {
	
	@DataProvider(name = "accountDataIterator")
	public Iterator<RegisterData> accountDataIterator() {
		List<RegisterData> list = new ArrayList<RegisterData>();
		RegisterData accountData1 = new RegisterData("Register: Create a personal account", "Create an account", "John", "Wick", "Wick420", "Class420", "Email address is invalid. Please enter a valid email address.");
		RegisterData accountData2 = new RegisterData("Register: Create a personal account", "Create an account", "Jayden", "Mack", "Mack420", "Class420", "Email address is invalid. Please enter a valid email address.");
		list.add(accountData1);
		list.add(accountData2);
		return list.iterator();

	}

	@DataProvider(name = "accountDataObject")
	public Object[][] accountDataObject() {
		RegisterData accountData1 = new RegisterData("Register: Create a personal account", "Create an account", "John", "Wick", "Wick420", "Class420", "Email address is invalid. Please enter a valid email address.");
		RegisterData accountData2 = new RegisterData("Register: Create a personal account", "Create an account", "Jayden", "Mack", "Mack420", "Class420", "Email address is invalid. Please enter a valid email address.");
		return new Object[][] { { accountData1 }, { accountData2 } };
	}
	
	@Test(enabled = true, dataProvider = "accountDataObject")
	public void accountDataTest(RegisterData registerData) {
		homePage.homePageRegisterStep();
		registerPage.registerPersonalAccStepsWithFailEmail(registerData);
	}

}


