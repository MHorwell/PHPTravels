package phptravels;

import org.junit.After;
import org.junit.Before;
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

public class PHPTravelsTest {

	WebElement element;
	WebDriver driver;
	Actions action;

	@Before
	public void setup() {
		System.setProperty("webdriver.gecko.driver", "C:\\drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		action = new Actions(driver);
		
	}

	@After
	public void teardown() {
		driver.quit();
	}

	@Test
	public void BookForTwoNights() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		driver.manage().window().maximize();
		driver.get("https://www.phptravels.net/");

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		homePage.locationSearch("London");
		homePage.setCheckInDate("23/01/2019");
		homePage.setCheckOutDate("25/01/2019");
		homePage.setAdults("3");
		homePage.submitSearch(driver);
		
		ListingsPage listingsOne = PageFactory.initElements(driver, ListingsPage.class);
		listingsOne.findHotel(driver, jse);
//		listingsOne.goToNextPage();
//		Thread.sleep(5000);
//		ListingsPage listingsTwo = PageFactory.initElements(driver, ListingsPage.class);
//		Thread.sleep(5000);
//		Thread.sleep(2000);

	}

}
