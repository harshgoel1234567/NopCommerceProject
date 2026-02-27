package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import actiondriver.Action;
import base.*;
import java.util.*;

public class ProductsPage extends BaseClass{
	
	Action a=new Action();
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath="//h2[text()='Desktops']")
	private WebElement desktopsHeading;
	

	
	@FindBy(xpath="//div[contains(@class,'product-thumb')]//img")
	private List<WebElement> productThumbnails;
	
	
	@FindBy(xpath="//div[contains(@class,'product-thumb')]//h4//a")
	private List<WebElement> productlist;
	
	@FindBy(xpath="//select[@id='input-sort']")
	private WebElement sortDropdown;
	
	@FindBy(xpath="//p[@class='price']")
	private List<WebElement> allPrices;
	
	@FindBy(xpath="//p[@class='price-new']")
	private WebElement newPrice;
	
	@FindBy(xpath="//div[@class='caption']//h4//a")
     private List<WebElement> allproductName;
	
	


	
	

	
	public ProductsPage(WebDriver driver,WebDriverWait wait)
	{
		this.driver=driver;
		this.wait=wait;
		
		PageFactory.initElements(driver, this);
	}
	

	public List<WebElement> productsThumbnail()
	{
		return wait.until(ExpectedConditions.visibilityOfAllElements(productThumbnails));
		
	}
	
	
	public List<WebElement> ReturnProductList()
	{
		return wait.until(ExpectedConditions.visibilityOfAllElements(productlist));

		  
		
	}
	public boolean isDesktopsHeadingDisplayed()
	{
	wait.until(ExpectedConditions.visibilityOf(desktopsHeading));
	return a.isElementDisplayed(driver, desktopsHeading);
		
	}
	public void selectPriceLowToHigh()
	{
	    wait.until(ExpectedConditions.elementToBeClickable(sortDropdown));
	    
	    Select select = new Select(sortDropdown);
	    select.selectByVisibleText("Price (Low > High)");
	}
	public void selectNameFromAtoZ()
	{
	    wait.until(ExpectedConditions.elementToBeClickable(sortDropdown));
	    
	    Select select = new Select(sortDropdown);
	   select.selectByVisibleText("Name (A - Z)");
	}
	
	public List<Double> getProductPrices()
	{
	    List<Double> priceList = new ArrayList<>();
	    List<WebElement> AllPrices =
	            wait.until(ExpectedConditions
	                    .visibilityOfAllElements(allPrices));

	    for(WebElement priceElement : AllPrices)
	    {
	        String priceText;

	        // Check if discounted price exists
	      

	        List<WebElement> newPriceList = priceElement.findElements(By.className("price-new"));

	        if (!newPriceList.isEmpty()) {
	            priceText = newPriceList.get(0).getText().split("\n")[0];
	        } else {
	            priceText = priceElement.getText().split("\n")[0];
	        }


	        
	        System.out.println(priceText);
	        // Remove $ and commas
	        priceText = priceText.replace("$", "").replace(",", "").trim();

	        priceList.add(Double.parseDouble(priceText));
	        
	    }

	    return priceList;
	}
	
	public List<String> getProductName()
	{
	    List<String> productNameList = new ArrayList<>();
	    List<WebElement> AllProductName =
	            wait.until(ExpectedConditions
	                    .visibilityOfAllElements(allproductName));

	    for(WebElement priceElement : AllProductName)
	    {
	        String productText;

	        // Check if discounted price exists
	      

	        
	      
	            productText = priceElement.getText();
	      


	        
	        System.out.println(productText);
	        // Remove $ and commas
	        productText = productText.trim();

	      
	        
	    }

	    return productNameList;
	}
	



	



}
