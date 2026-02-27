package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import actiondriver.Action;
import base.*;

public class RegisterPage extends BaseClass{
	
	Action a=new Action();
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//input[@id='FirstName']")
	private WebElement FirstNameField;
	
	@FindBy(xpath="//input[@id='LastName']")
	private WebElement LastNameField;
	
	@FindBy(xpath="//input[@id='Email']")
	private WebElement EmailField;
	
	@FindBy(xpath="//input[@id='Password']")
	private WebElement PasswordField;
	
	@FindBy(xpath="//input[@id='ConfirmPassword']")
	private WebElement ConfirmPasswordField;
	
	
	
	@FindBy(xpath="//button[@id='register-button']")
	private WebElement RegisterButton;
	
	public RegisterPage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickRegisterButton()
	{
		a.explicitWait(driver, RegisterButton, wait);
		a.click(driver, RegisterButton);
	}

   
	public void FirstNameField(String text)
	{
	    a.explicitWait(driver,FirstNameField, wait);
		a.sendKeys(FirstNameField, text);
	}
	public void LastNameField(String text)
	{
	    a.explicitWait(driver,LastNameField, wait);
		a.sendKeys(LastNameField, text);
	}
	public void  EmailField(String text)
	{
	    a.explicitWait(driver, EmailField, wait);
		a.sendKeys( EmailField, text);
	}
	public void  PasswordField(String text)
	{
	    a.explicitWait(driver, PasswordField, wait);
		a.sendKeys(PasswordField, text);
	}
	public void  ConfirmPasswordField(String text)
	{
	    a.explicitWait(driver,  ConfirmPasswordField, wait);
		a.sendKeys( ConfirmPasswordField, text);
	}
	 


}
