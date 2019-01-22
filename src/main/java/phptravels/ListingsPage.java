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

	@FindBy(css = "RTL go-text-right mt0 mb4 list_title")
	private List<WebElement> locationList;

	public void findHotel(WebDriver driver, JavascriptExecutor jse) {
		
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

		for (WebElement location : locationList) {
			if (location.getAttribute("href").contains("london")) {
				location.click();
				break;
			}

		}
		nextPage.click();
		nextPage = (new WebDriverWait(driver, 10).until(ExpectedConditions
				.presenceOfElementLocated(By.partialLinkText("href=\"https://www.phptravels.net/hotels/detail/\""))));
	}
}
