package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import actiondriver.Action;
import base.*;

public class HomePage extends BaseClass{
	
	Action a=new Action();
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	private WebElement Myaccount;
	@FindBy(xpath="//a[normalize-space()='Login']")
	private WebElement LoginButton;
	@FindBy(xpath="//a[normalize-space()='Logout']")
	private WebElement LogOutButton;
	@FindBy(xpath="//a[normalize-space()='Desktops']")
	private WebElement DesktopsIcon;
	@FindBy(xpath="//a[normalize-space()='Show AllDesktops']")
	private WebElement ShowAllDesktops;
	
	@FindBy(xpath="//li//a//span[normalize-space()='Shopping Cart']")
	private WebElement ShoopingCart;

	
	public HomePage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickLoginButton()
	{
		a.explicitWait(driver, Myaccount, wait);
		a.click(driver, Myaccount);
		a.click(driver, LoginButton);
	}
	public void clickShoppingCartIcon()
	{
		a.explicitWait(driver,ShoopingCart , wait);
		a.click(driver, ShoopingCart);
	}

	public boolean isLogOutButtonDisplayed()
	{
		a.explicitWait(driver, Myaccount, wait);
		a.click(driver, Myaccount);
		a.explicitWait(driver, LogOutButton, wait);
		return a.isElementDisplayed(driver, LogOutButton);
	}
	public void ClickOnDesktops()
	{
		a.explicitWait(driver,DesktopsIcon,wait);
		a.click(driver, DesktopsIcon);
		a.explicitWait(driver, ShowAllDesktops, wait);
		a.click(driver, ShowAllDesktops);
	}
	
	



}
