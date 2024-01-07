package rahulshettyacademy.selenium_java.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.selenium_java.abstractcomponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "[placeholder='Select Country']")
	WebElement selectCountryField;

	@FindBy(css = ".ta-item:nth-of-type(2)")
	WebElement selectCountry;
	
	@FindBy(css = ".action__submit")
	WebElement placeOrder ;

	By result = By.cssSelector(".ta-results");

	public void selectCountry(String country) {
		Actions a = new Actions(driver);
		a.sendKeys(selectCountryField, country).build().perform();
		waitForElementToAppear(result);
		selectCountry.click();
	}
	
	public ConfirmationPage goToConfirmationPage() {
		placeOrder.click();
		return new ConfirmationPage(driver);
	}
}
