package rahulshettyacademy.selenium_java.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import rahulshettyacademy.selenium_java.pageobjects.CartPage;
import rahulshettyacademy.selenium_java.pageobjects.CheckoutPage;
import rahulshettyacademy.selenium_java.pageobjects.ConfirmationPage;
import rahulshettyacademy.selenium_java.pageobjects.OrderPage;
import rahulshettyacademy.selenium_java.pageobjects.ProductCataloguePage;
import rahulshettyacademy.selenium_java.testcomponents.BaseTest;

public class StandAloneTest extends BaseTest {
	String productName = "ADIDAS ORIGINAL";

	@Test(dataProvider = "getData", groups = { "Purchase" })
	public void submitOrderTest(HashMap<String, String> input) throws IOException, InterruptedException {

		String countryName = "India";
//		LandingPage landingPage = launchingApplications();

		ProductCataloguePage productCataloguePage = landingPage.loginApplication(input.get("username"),
				input.get("password"));
		productCataloguePage.addProductToCart(input.get("productName"));

		CartPage CartPage = productCataloguePage.goToCartPage();
		boolean match = CartPage.verifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);

		CheckoutPage checkoutPage = CartPage.goToCheckoutPage();
		checkoutPage.selectCountry(countryName);

		ConfirmationPage confirmationPage = checkoutPage.goToConfirmationPage();
		String confirmationMessage = confirmationPage.getConfirmationMessage();

//		Assert.assertEquals(confirmationMessage, "THANKYOU FOR THE ORDER.");
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
//		driver.close();
	}

	@Test(dependsOnMethods = "submitOrderTest")
	public void orderHistoryTest() {
		ProductCataloguePage productCataloguePage = landingPage.loginApplication("test07@qa.com", "Test@123");
		OrderPage orderPage = productCataloguePage.goToOrderPage();
		Assert.assertTrue(orderPage.verifyOrderDisplay("ZARA COAT 3"));
	}

	@DataProvider
	public Object[][] getData() throws IOException {

//		return new Object[][] { { "test07@qa.com", "Test@123", "ZARA COAT 3" },
//				{ "test10@qa.com", "Test@789", "ADIDAS ORIGINAL" } };

//		Object[][] object = new Object[2][3];
//		object[0][0] = "test07@qa.com";
//		object[0][1] = "Test@123";
//		object[0][2] = "ZARA COAT 3";
//		object[1][0] = "test10@qa.com";
//		object[1][1] = "Test@789";
//		object[1][2] = "ADIDAS ORIGINAL";
//		return object;

//		HashMap<String, String> map1 = new HashMap<String, String>();
//		map1.put("username", "test07@qa.com");
//		map1.put("password", "Test@123");
//		map1.put("productName", "ZARA COAT 3");
//
//		HashMap<String, String> map2 = new HashMap<String, String>();
//		map2.put("username", "test10@qa.com");
//		map2.put("password", "Test@789");
//		map2.put("productName", "ADIDAS ORIGINAL");
//
//		return new Object[][] { { map1 }, { map2 } };

		List<HashMap<String, String>> data = getJsonDataToMap();
		return new Object[][] { { data.get(0) }, { data.get(1) } };

	}

}
