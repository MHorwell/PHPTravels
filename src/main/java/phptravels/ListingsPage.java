package phptravels;


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

	@FindBy(css = "a[href='https://www.phptravels.net/hotels/detail/*']")
	private WebElement location;

	public void findHotel(WebDriver driver) {
		
		if (location == null){
			nextPage.click();
			nextPage = (new WebDriverWait(driver, 10).until(ExpectedConditions.presenceOfElementLocated(By.partialLinkText("href=\"https://www.phptravels.net/hotels/detail/\""))));
		}
		else {
			location.click();
		}
		
		


	}
}
