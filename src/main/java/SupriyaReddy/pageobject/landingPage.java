package SupriyaReddy.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import SupriyaReddy.AbstractComponents.AbstractComponent;

public class landingPage extends AbstractComponent{
	
	WebDriver driver;
	
	public landingPage(WebDriver driver) {
		   super(driver);
           this.driver=driver;
           PageFactory.initElements(driver, this);
	}
	//WebElement UserEmail=driver.findElement(By.id("userEmail"));
	//pageFactory
	@FindBy(id="userEmail")
	WebElement UserEmail;
	
	@FindBy(css="input[type='password']")
	WebElement Userpassword;
	
	@FindBy(xpath="//input[@id='login']")
	WebElement submit;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement ErrorMessage;
	
	public productCatalogue loginApplication(String email,String password)
	{
        UserEmail.sendKeys(email);
        Userpassword.sendKeys(password);
        submit.click();
        productCatalogue productCatalogue =new productCatalogue(driver);
        return productCatalogue;
    }
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	public String getErrorMessage()
	{
		waitForWebElementToAppear(ErrorMessage);
		return ErrorMessage.getText();
	}
	}
