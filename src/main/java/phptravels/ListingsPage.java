package phptravels;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ListingsPage {

	@FindBy(xpath = "/html/body/div[5]/div[5]/div/div[3]/div[2]/ul/li[4]/a")
	private WebElement nextPage;



	public void findHotel(WebDriver driver, JavascriptExecutor jse, WebDriverWait wait) {
		
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		List<WebElement> locationList = driver.findElements(By.tagName("h4"));

		for (WebElement location : locationList) {
			System.out.println("Work.");
			System.out.println(location.getText());
			
//			if (href.contains("london")) {
//				location.click();
//				break;
//			} else {
//				System.out.println("notLondon");
//			}
		}
		this.nextPage();

	}

	public void nextPage() {
		nextPage.click();
	}
}
