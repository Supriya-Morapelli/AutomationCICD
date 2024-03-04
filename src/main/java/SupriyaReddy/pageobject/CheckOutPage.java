package SupriyaReddy.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import SupriyaReddy.AbstractComponents.AbstractComponent;

public class CheckOutPage extends AbstractComponent {
 WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		 PageFactory.initElements(driver, this);
	}

	
	@FindBy(css="input[placeholder='Select Country']")
	WebElement Country;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement selectCountry;
	
	By results=By.cssSelector("[class*='ta-results']");
	
	
	public void selectCountry(String countryName)
	{
		Actions a=new Actions(driver);
		a.sendKeys(Country,countryName).build().perform();
		waitForElementToAppear(results);
	
		selectCountry.click();
	}
	public ConfirmationPage submitOrder()
	{
		submit.click();
		return new ConfirmationPage(driver);
	}
		
	
}
