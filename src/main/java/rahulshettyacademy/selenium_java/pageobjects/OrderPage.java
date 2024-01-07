package rahulshettyacademy.selenium_java.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import rahulshettyacademy.selenium_java.abstractcomponents.AbstractComponent;

public class OrderPage extends AbstractComponent {

	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//tr/td[2]")
	List<WebElement> prodElements;

	public boolean verifyOrderDisplay(String productName) {

		boolean match = prodElements.stream().anyMatch(p -> p.getText().equalsIgnoreCase(productName));
		return match;
	}

}
