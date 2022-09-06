package purple.ebay.base;

import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;


import io.github.bonigarcia.wdm.WebDriverManager;
import purple.ebay.commons.CommonFunctions;
import purple.ebay.commons.CommonWaits;
import purple.ebay.objects.HomePage;
import purple.ebay.objects.RegisterAccountPage;
import purple.ebay.reporting.ExtentManager;
import purple.ebay.reporting.ExtentTestManager;
import purple.ebay.objects.BrandAndOutletPage;
import purple.ebay.objects.CellPhonePage;
import purple.ebay.objects.DailyDealPage;
import purple.ebay.objects.HelpPage;
import purple.ebay.utils.Configuration;

public class BaseClass {

	public Configuration configuration = Configuration.getInstance();

	WebDriver driver;
	WebDriverWait wait;
	ExtentReports extent;

	protected CommonFunctions commons;
	CommonWaits waits;
	protected HomePage homePage;
	protected CellPhonePage cellPhonePage;
	protected BrandAndOutletPage brandAndOutletPage;
	protected DailyDealPage dealPage;
	protected HelpPage helpPage;
	protected RegisterAccountPage registerPage;
	
	@BeforeSuite
	public void initiatingReport() {
		extent = ExtentManager.initiatingReport();
	}
	
	@BeforeMethod
	public void beforeEachTest(Method method) {
		String className = method.getDeclaringClass().getSimpleName();
		ExtentTestManager.creatingTest(method.getName());
		ExtentTestManager.getTest().assignCategory(className);
	}

	@Parameters("browser")
	@BeforeMethod
	public void setUp(String browser1) {
		driver = localDriver(browser1);
		driver.manage().window().maximize();
		driver.get(configuration.get("url"));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Integer.parseInt(configuration.get("pageloadWait"))));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.parseInt(configuration.get("implicitWait"))));
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(configuration.get("explicitWait"))));
		initClasses();
	}
	
	@AfterMethod
	public void afterEachTest(Method method, ITestResult result) {
		for(String group: result.getMethod().getGroups()) {
			ExtentTestManager.getTest().assignCategory(group);
		}
		if(result.getStatus() == ITestResult.SUCCESS) {
			ExtentTestManager.getTest().log(Status.PASS, "TEST PASSED");
		}else if(result.getStatus() == ITestResult.SKIP) {
			ExtentTestManager.getTest().log(Status.SKIP, "TEST SKIPPED");
		}else {
			ExtentTestManager.getTest().log(Status.FAIL, "TEST FAILED \n" + result.getThrowable());
			ExtentTestManager.getTest().addScreenCaptureFromPath(commons.getScreenshot(method.getName()));
		}
	}

	private WebDriver localDriver(String browserName) {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			WebDriverManager.safaridriver().setup();
			driver = new SafariDriver();
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		return driver;
	}

	private void initClasses() {
		waits = new CommonWaits(wait);
		commons = new CommonFunctions(driver, waits);
		homePage = new HomePage(driver, commons);
		cellPhonePage = new CellPhonePage(driver, commons);
		brandAndOutletPage = new BrandAndOutletPage(driver, commons);
		dealPage = new DailyDealPage(driver, commons);
		helpPage = new HelpPage(driver, commons);
		registerPage = new RegisterAccountPage(driver, commons);

	}

	protected WebDriver getDriver() {
		return driver;
	}

	@AfterMethod
	public void terminate() {
		driver.quit();
	}
	
	@AfterSuite
	public void endReport() {
		extent.flush();
	}
}
