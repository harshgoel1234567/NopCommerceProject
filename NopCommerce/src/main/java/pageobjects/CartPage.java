package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import actiondriver.Action;

public class CartPage {

	
Action a=new Action();
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//button[@data-original-title='Update']")
	private WebElement updateQuantityButton;
	
	@FindBy(xpath="//button[@data-original-title='Remove']")
	private WebElement removeProductButton;
	
	
	@FindBy(xpath="//input[starts-with(@name,'quantity')]")
	private WebElement productQuantityField;
	
	@FindBy(xpath="//div[contains(@class,'alert-success')]")
	private WebElement successMessage;
	
	@FindBy(xpath="//td[normalize-space()='Product 1']/parent::tr/td[@class='text-right'][1]")
	private WebElement unitprice;
	
	@FindBy(xpath="//td[normalize-space()='Product 1']/parent::tr/td[@class='text-right'][2]\r\n")
	private WebElement totalPrice;
	
	
	@FindBy(xpath="//div[@id='content']//p[normalize-space()='Your shopping cart is empty!']")
	private WebElement cartEmptyHeading;
	
	
	
	
	public CartPage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		
		PageFactory.initElements(driver, this);
	}
	public void updateproductquantityfield(String text)
	{
		a.explicitWait(driver, productQuantityField , wait);
		productQuantityField.clear();
		a.sendKeys(productQuantityField, text);
	}
	public void clickupdateQuantityButton()
	{
		a.explicitWait(driver,updateQuantityButton , wait);
		a.click(driver, updateQuantityButton);
	}
	public void clickRemoveProductButton()
	{
		a.explicitWait(driver,removeProductButton, wait);
		a.click(driver, removeProductButton);
	}
	public boolean verifySuccessMessage()
	{
		a.explicitWait(driver,successMessage, wait);
		return a.isElementDisplayed(driver, successMessage);
	}
	public String getUnitPrice()
	{
		a.explicitWait(driver, unitprice, wait);
		return unitprice.getText();
	}
	public String getTotalPrice()
	{
		a.explicitWait(driver, totalPrice, wait);
		return totalPrice.getText();
	}
	
	public boolean isCartEmptyHeadingDisplayed()
	{
		a.explicitWait(driver,cartEmptyHeading, wait);
		return a.isElementDisplayed(driver, cartEmptyHeading);
	}
	
	
	
}
