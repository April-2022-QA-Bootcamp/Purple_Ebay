package purple.ebay.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static purple.ebay.utils.RegisterDataMap.*;

import java.util.Map;

import purple.ebay.base.BaseClass;
import purple.ebay.utils.ExcelUtil;

public class RegisterEnumMapTest extends BaseClass {

	@DataProvider(name = "dataMapEnum")

	public Object[][] mapData() {
		String pathString = configuration.get("excelPath");
		String sheetNameString = configuration.get("excelSheetMap");
		ExcelUtil excelUtil = new ExcelUtil(pathString, sheetNameString);
		int size = excelUtil.dataMap().size();
		Object[][] objects2d = new Object[size][1];
		/*
		 * objects2d is an two-dimensional array Object[][] objects2d = new
		 * Object[size][1] define size = basically that many number of rows in dataMap 1
		 * = is basically each dataMap index has one map
		 */
		for (int i = 0; i < size; i++) {
			objects2d[i][0] = excelUtil.dataMap().get(i);
		}
		return objects2d;
	}

	@Test(enabled = true, dataProvider = "dataMapEnum")

	public void registerFailUsingEnum(Map<String, String> map) {
		homePage.homePageRegisterStep();
		registerPage.registerPersonalAccStepsWithFailEmail(map);
	}

}
