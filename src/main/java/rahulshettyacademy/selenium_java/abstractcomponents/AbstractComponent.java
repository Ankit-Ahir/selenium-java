package rahulshettyacademy.selenium_java.abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.selenium_java.pageobjects.CartPage;
import rahulshettyacademy.selenium_java.pageobjects.OrderPage;

public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "button[routerlink*='cart']")
	WebElement cartButton;
	
	@FindBy(css = "button[routerlink*='myorders']")
	WebElement ordersButton;

	public void waitForElementToAppear(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForWebElementToAppear(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(webElement));
	}

	public void waitForElementToDisappear(WebElement webElement) throws InterruptedException {
		Thread.sleep(2000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//		wait.until(ExpectedConditions.invisibilityOf(webElement));
	}

	public CartPage goToCartPage() {
		cartButton.click();
		CartPage CartPage = new CartPage(driver);
		return CartPage;
	}

	public OrderPage goToOrderPage() {
		ordersButton.click();
		return new OrderPage(driver);
	}
}
