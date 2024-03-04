package SupriyaReddy.Tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import SupriyaReddy.TestComponents.BaseTest;
import SupriyaReddy.TestComponents.Retry;
import SupriyaReddy.pageobject.CartPage;
import SupriyaReddy.pageobject.productCatalogue;

public class ErrorValidationsTest extends BaseTest {
    @Test(groups = {"ErrorHandling"},retryAnalyzer = Retry.class)
	public void LoginErrorValidations() throws InterruptedException, IOException {

		
		
		landingPage.loginApplication("SupriyaReddy@gmail.com", "Sppu@2001");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
		
	}
    @Test
    public void ProductErrorValidations() throws InterruptedException, IOException {

           String productName = "IPHONE 13 PRO";
		
		productCatalogue productCatalogue = landingPage.loginApplication("Vpriyatham@gmail.com", "Nani@2001");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.VerifyProductDisplay("IPHONE 13 PRO Max");
		Assert.assertFalse(match);
		
	}
}


