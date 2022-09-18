package purple.ebay.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import purple.ebay.base.BaseClass;
import purple.ebay.utils.ExcelUtil;

public class RegisterAccountExcelDataTest extends BaseClass {
	
	@DataProvider( name = "excelAccountData")
	public Object[][] accountData(){
		String pathString = configuration.get("excelPath");
		String sheetNameString = configuration.get("excelSheet");
		ExcelUtil excelUtil = new ExcelUtil(pathString, sheetNameString);
		return excelUtil.dataObjects();
	}
		
		
	@Test(enabled = true, dataProvider = "excelAccountData")
	public void excelSheetTest(String expectedTitle, String expectedText1, String firstName,
			String lastName, String email, String password, String expectedError) {
		homePage.homePageRegisterStep();
		registerPage.registerPersonalAccStepsWithFailEmail(expectedTitle, expectedText1, firstName, lastName, email, password, expectedError);
	}

}
