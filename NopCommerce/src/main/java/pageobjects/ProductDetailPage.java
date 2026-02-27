package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import actiondriver.Action;
import base.*;
import java.util.*;

public class ProductDetailPage extends BaseClass{
	
	Action a=new Action();
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//button[@id='button-cart']")
	private WebElement addToCartButton;
	
	
	@FindBy(xpath = "//div[@id='content']//h1")
	private WebElement productHeading;
	
	@FindBy(xpath="//div[contains(@class,'alert-success')]")
	private WebElement successMessageForProductAddToCart;
	
	public ProductDetailPage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean isAddToCartButtonDisplayed()
	{
		wait.until(ExpectedConditions.visibilityOf(addToCartButton));
		return a.isElementDisplayed(driver, addToCartButton);
		
	}
	public String getproductHeading()
	{
		wait.until(ExpectedConditions.visibilityOf(productHeading));
		return productHeading.getText();
		
	}
	public void clickAddToCartButton()
	{
		wait.until(ExpectedConditions.visibilityOf(addToCartButton));
		a.click(driver, addToCartButton);
	}
	
	public boolean successMessageForProductAddToart()
	{
		// wait.until(ExpectedConditions.visibilityOf(successMessageForProductAddToCart)).getText();
		 wait.until(ExpectedConditions.visibilityOf(successMessageForProductAddToCart));
		 System.out.println(successMessageForProductAddToCart);
		 return a.isElementDisplayed(driver, successMessageForProductAddToCart);
		
	
	
	}


}