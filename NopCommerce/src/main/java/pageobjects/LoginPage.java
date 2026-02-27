package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import actiondriver.Action;

public class LoginPage {

	
Action a=new Action();
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//input[@id='input-email']")
	private WebElement EmailField;
	
	@FindBy(xpath="//input[@id='input-password']")
	private WebElement PasswordField;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement LogInButton;
	
	@FindBy(css="div.alert.alert-danger")
	private WebElement InvalidLoginAlert;
	
	
	
	
	public LoginPage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void LoginField(String text)
	{
		a.explicitWait(driver, EmailField, wait);
		a.sendKeys(EmailField, text);
	}
	public void PasswordField(String text)
	{
		a.explicitWait(driver, PasswordField, wait);
		a.sendKeys(PasswordField, text);
	}
	
	public void clickLoginButton()
	{
		a.explicitWait(driver, LogInButton, wait);
		a.click(driver, LogInButton);
	}
	
	public boolean valiateInvalidLoginCredentialAlert()
	{
		a.explicitWait(driver, InvalidLoginAlert, wait);
		String message =InvalidLoginAlert.getText();

		System.out.println("Login Alert Message: " + message);
		return a.isElementDisplayed(driver, InvalidLoginAlert);
	}
	
	
	
}
