package rahulshettyacademy.selenium_java.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.selenium_java.abstractcomponents.AbstractComponent;

public class CartPage extends AbstractComponent {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> listCartWebElements;

	@FindBy(css = ".totalRow button")
	WebElement checkoutButton;

	public boolean verifyProductDisplay(String productName) {
		List<WebElement> cartWebElements = listCartWebElements;
		return cartWebElements.stream().anyMatch(e -> e.getText().equalsIgnoreCase(productName));
	}

	public CheckoutPage goToCheckoutPage() {
		checkoutButton.click();
		return new CheckoutPage(driver);
	}

}
