package rahulshettyacademy.selenium_java.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.selenium_java.pageobjects.CartPage;
import rahulshettyacademy.selenium_java.pageobjects.ProductCataloguePage;
import rahulshettyacademy.selenium_java.testcomponents.BaseTest;
import rahulshettyacademy.selenium_java.testcomponents.Retry;

public class ErrorValidationTest extends BaseTest {

	@Test(retryAnalyzer = Retry.class, groups = { "Error Validation" })
	public void loginErrorValidation() {

		landingPage.loginApplication("incorrect@qa.com", "wrongPassword@123");
		Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password.");
	}

	@Test
	public void productErrorValidation() throws InterruptedException {

		ProductCataloguePage productCataloguePage = landingPage.loginApplication("test08@qa.com", "Test@123");
		productCataloguePage.addProductToCart("ZARA COAT 3");

		CartPage CartPage = productCataloguePage.goToCartPage();
		boolean match = CartPage.verifyProductDisplay("ZARA COAT 3");
		Assert.assertTrue(match);
	}

}
