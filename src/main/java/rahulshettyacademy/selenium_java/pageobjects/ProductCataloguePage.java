package rahulshettyacademy.selenium_java.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.selenium_java.abstractcomponents.AbstractComponent;

public class ProductCataloguePage extends AbstractComponent {

	WebDriver driver;

	public ProductCataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".ng-animating")
	WebElement spinner;

	@FindBy(css = ".mb-3")
	List<WebElement> prodElements;

	@FindBy(css = "button[routerlink*='cart']")
	WebElement cartButton;

	By prodList = By.cssSelector(".mb-3");
	By addToCart = By.cssSelector(".card-body button:last-of-type");
	By prodAddedToCartMessage = By.cssSelector("#toast-container");

	public List<WebElement> getProductElements() {
		waitForElementToAppear(prodList);
		return prodElements;
	}

	public WebElement getProductByName(String productName) {
		WebElement productElement = getProductElements().stream()
				.filter(e -> e.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return productElement;
	}

	public void addProductToCart(String productName) throws InterruptedException {
		WebElement productElement = getProductByName(productName);
		productElement.findElement(addToCart).click();
		waitForElementToAppear(prodAddedToCartMessage);
		waitForElementToDisappear(spinner);
//		cartButton.click();
	}
}
