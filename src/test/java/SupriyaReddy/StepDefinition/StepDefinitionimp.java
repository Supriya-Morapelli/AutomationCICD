package SupriyaReddy.StepDefinition;

import java.io.IOException;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import SupriyaReddy.TestComponents.BaseTest;
import SupriyaReddy.pageobject.CartPage;
import SupriyaReddy.pageobject.CheckOutPage;
import SupriyaReddy.pageobject.ConfirmationPage;
import SupriyaReddy.pageobject.landingPage;
import SupriyaReddy.pageobject.productCatalogue;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionimp extends BaseTest {
	public landingPage landinpage;
	public productCatalogue productCatalogue;
	public ConfirmationPage ConfirmationPage;
	public CheckOutPage CheckOutPage;
	public CartPage cartPage;

	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException {
		landingPage = launchApplication();

	}

	@Given("^Logged in with username (.+) and password (.+)$")
	public void Logged_in_with_username_password(String username, String password) {
		productCatalogue = landingPage.loginApplication(username, password);
	}

	@When("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String productname) throws InterruptedException {
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productname);
	}

	@And("^Checkout (.+) and submit the order$")
	public void Checkout_and_submit_order(String productname) throws InterruptedException {
		productCatalogue.addProductToCart(productname);
		cartPage = productCatalogue.goToCartPage();

		Boolean match = cartPage.VerifyProductDisplay(productname);
		Assert.assertTrue(match);
		CheckOutPage = cartPage.goTocheckout();
		CheckOutPage.selectCountry("india");
		ConfirmationPage = CheckOutPage.submitOrder();
	}

	@Then("{string} message is displayed on confirmation page")
	public void message_is_displayed_on_confirmation_page(String string) {
		String confirmMessage = ConfirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}

	@Then("{string} message is displayed.")
	public void message_is_displayed(String string) {
		Assert.assertEquals(string, landingPage.getErrorMessage());
		driver.close();
	}
}
