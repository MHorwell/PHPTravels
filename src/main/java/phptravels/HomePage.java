package phptravels;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	@FindBy(xpath = "/html/body/div[5]/section/div[2]/div/div/div[2]/div/div[1]/form/div[1]/div/div[2]/a/span[1]")
	private WebElement locationSelect;

	@FindBy(xpath = "/html/body/div[17]/div/input")
	private WebElement locationInput;
	
	@FindBy(xpath = "/html/body/div[5]/section/div[2]/div/div/div[2]/div/div[1]/form/div[2]/div/input")
	private WebElement checkInDate;

	@FindBy(xpath = "/html/body/div[5]/section/div[2]/div/div/div[2]/div/div[1]/form/div[3]/div/input")
	private WebElement checkOutDate;

	@FindBy(id = "travellersInput")
	private WebElement totalPeople;

	@FindBy(id = "adultInput")
	private WebElement adultCount;

	@FindBy(xpath = "/html/body/div[5]/section/div[2]/div/div/div[2]/div/div[1]/form/div[5]/button")
	private WebElement searchButton;

	public void locationSearch(String location) {
		locationSelect.click();
		locationInput.sendKeys(location, Keys.ENTER);
	}

	public void setCheckInDate(String indate) {
		checkInDate.sendKeys(indate);
	}

	public void setCheckOutDate(String outdate) {
		checkOutDate.sendKeys(outdate);
	}

	public void setAdults(String adults) throws InterruptedException {
		totalPeople.clear();
		totalPeople.sendKeys(adults + " Adult 0 Child");
	}

	public void submitSearch() {
		searchButton.submit();
	}

}
