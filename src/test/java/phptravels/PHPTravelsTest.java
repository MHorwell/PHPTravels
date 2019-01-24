package phptravels;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


public class PHPTravelsTest {

	WebElement element;
	WebDriver driver;
	Actions action;
	ExtentTest test;
	static ExtentReports report;
	WebDriverWait wait;



	
	@BeforeClass 
	public static void startReport() {

		report = new ExtentReports("C:\\Users\\Admin\\Documents\\eclipse-workspace\\PHPTravels\\Reports\\report.html", true);
		
	}
	
	@AfterClass
	public static void endReport() {
		report.flush();
	}

	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		action = new Actions(driver);
		wait = new WebDriverWait(driver, 10);
		
	}

	@After
	public void teardown() {
		driver.quit();
		
	}

	@Test
	public void BookForTwoNights() throws InterruptedException {
		
		test = report.startTest("Checking Booking System");
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/");

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		test.log(LogStatus.INFO, "Browser started");
		homePage.locationSearch("London", driver, wait);
		homePage.setCheckInDate("23/01/2019");
		homePage.setCheckOutDate("25/01/2019");
		homePage.setAdults("3");
		homePage.submitSearch(driver, wait);
		test.log(LogStatus.INFO, "Search submitted");
		

		
		ListingsPage listingsOne = PageFactory.initElements(driver, ListingsPage.class);
		listingsOne.findHotel(driver, jse, wait);
		ListingsPage listingsTwo = PageFactory.initElements(driver, ListingsPage.class);
		listingsTwo.findHotel(driver, jse, wait);
//		listingsOne.goToNextPage();
//		Thread.sleep(5000);
//		ListingsPage listingsTwo = PageFactory.initElements(driver, ListingsPage.class);
//		Thread.sleep(5000);
//		Thread.sleep(2000);
		report.endTest(test);
	}

}
