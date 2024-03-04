package SupriyaReddy.Tests;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SupriyaReddy.TestComponents.BaseTest;
import SupriyaReddy.pageobject.CartPage;
import SupriyaReddy.pageobject.CheckOutPage;
import SupriyaReddy.pageobject.ConfirmationPage;
import SupriyaReddy.pageobject.OrderPage;
import SupriyaReddy.pageobject.landingPage;
import SupriyaReddy.pageobject.productCatalogue;

public class SubmitOrderTest extends BaseTest {
	String productName = "IPHONE 13 PRO";
    @Test(dataProvider="getData",groups= {"purchase"})
	public void submitOrder(HashMap<String,String> input) throws InterruptedException, IOException {

		
		
		productCatalogue productCatalogue = landingPage.loginApplication(input.get("email"), input.get("password"));

		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(input.get("productName"));
		CartPage cartPage = productCatalogue.goToCartPage();
		
		Boolean match = cartPage.VerifyProductDisplay(input.get("productName"));
		Assert.assertTrue(match);
		CheckOutPage CheckOutPage = cartPage.goTocheckout();
		CheckOutPage.selectCountry("india");
		ConfirmationPage ConfirmationPage = CheckOutPage.submitOrder();
		String confirmMessage = ConfirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
	}
    @Test(dependsOnMethods = {"submitOrder"})
    public void OrderHistoryTest()
    {
    	productCatalogue productCatalogue = landingPage.loginApplication("SupriyaReddy@gmail.com", "Suppu@2001");
    	OrderPage orderpage =productCatalogue.goToOrdersPage();
    	Assert.assertTrue(orderpage.VerifyOrderDisplay(productName));
    }
    
    
    
    
    @DataProvider
    public Object[][]  getData() throws IOException{
  
    	
    	
    	//3
    	List<HashMap<String, String>>data=getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\SupriyaReddy\\data\\PurchaseOrder.json");
    return new Object[][] {{data.get(0)},{data.get(1)}};
    
    }}


    //1.return new Object[][]   {{"SupriyaReddy@gmail.com","Suppu@2001","IPHONE 13 PRO"},{"Vpriyatham@gmail.com","Nani@2001","ADIDAS ORIGINAL"}};
    //By 2.Hashmaps
//    HashMap<String, String>	 map=new HashMap<String, String>();
//    map.put("email", "SupriyaReddy@gmail.com");
//    map.put("password", "Suppu@2001");
//    map.put("productName", "IPHONE 13 PRO");
//    HashMap<String, String>	 map1=new HashMap<String, String>();
//    map1.put("email", "Vpriyatham@gmail.com");
//    map1.put("password", "Nani@2001");
//    map1.put("productName", "ADIDAS ORIGINAL");
    



