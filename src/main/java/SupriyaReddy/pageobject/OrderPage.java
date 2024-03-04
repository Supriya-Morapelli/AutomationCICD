package SupriyaReddy.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SupriyaReddy.AbstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent {
	WebDriver driver;
	@FindBy(css=".totalRow button")
	WebElement Checkout;
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;

	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> OrderName;
	
	public OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	 }
	 
	
	public  Boolean VerifyOrderDisplay(String productName)
	{
		Boolean match=OrderName.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
		return match;
	}

	
	
	

}
