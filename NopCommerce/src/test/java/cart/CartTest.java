package cart;


import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import actiondriver.Action;
import base.BaseClass;

import pageobjects.*;
import java.util.*;
public class CartTest extends BaseClass{

	
	private WebDriver driver;
	private WebDriverWait wait;
	Action a= new Action();
	//ftyfth
	@BeforeMethod
	public void openApplication() throws IOException
	{
		driver=initializeDriver();
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
//	
//	@Test
//	public void Cart_VerifyProductAddedSuccessfully()
//	{
//
//		HomePage homePage=new HomePage(driver, wait);
//		
//	    
//			ProductsPage productsPage=new ProductsPage(driver,wait);
//			ProductDetailPage productDetailPage=new ProductDetailPage(driver,wait);
//			 homePage.ClickOnDesktops();
//			List<WebElement>productList=productsPage.ReturnProductList();
//			
//			int m=productList.size();
//			 WebElement Product=productList.get(3);
//			 
//			 String expectedProductName = Product.getText();
//			
//	
//	
//		    Product.click();
//	
//		    String actualProductName =productDetailPage.getproductHeading();
//	
//		   
//	
//		    Assert.assertEquals(actualProductName, expectedProductName,
//		            "Incorrect product details page opened.");
//		    productDetailPage.clickAddToCartButton();
//		    Assert.assertTrue(productDetailPage.successMessageForProductAddToart());
//		  
//	}
//	
	@Test
	public void Cart_VerifyProductQuantityUpdate() throws InterruptedException
	{

		HomePage homePage=new HomePage(driver, wait);
		
	    
			ProductsPage productsPage=new ProductsPage(driver,wait);
			ProductDetailPage productDetailPage=new ProductDetailPage(driver,wait);
			CartPage cartPage=new CartPage(driver,wait);
			 homePage.ClickOnDesktops();
			List<WebElement>productList=productsPage.ReturnProductList();
			
			int m=productList.size();
			 WebElement Product=productList.get(3);
			 
			 String expectedProductName = Product.getText();
			
	
	
		    Product.click();
	
		    String actualProductName =productDetailPage.getproductHeading();
	
		   
	
		    Assert.assertEquals(actualProductName, expectedProductName,
		            "Incorrect product details page opened.");
		    productDetailPage.clickAddToCartButton();
		    Assert.assertTrue(productDetailPage.successMessageForProductAddToart());
		    
		    homePage.clickShoppingCartIcon();
		    Thread.sleep(3000);
		    cartPage.updateproductquantityfield("3");
		    Thread.sleep(3000);
		    cartPage.clickupdateQuantityButton();
		    Thread.sleep(3000);
		    Assert.assertTrue(cartPage.verifySuccessMessage());
		    Double unitprice=   Double.parseDouble(cartPage.getUnitPrice().replace("$","").trim());
		    Double totalprice=   Double.parseDouble(cartPage.getTotalPrice().replace("$","").trim());
		    System.out.println(unitprice);
		    System.out.println(totalprice);
		    
		Assert.assertEquals(unitprice*3,totalprice);
		    
		    
		  
	}
	@Test
	public void Cart_VerifyProductRemovalFromCart() throws InterruptedException
	{
		HomePage homePage=new HomePage(driver, wait);
		
	    
		ProductsPage productsPage=new ProductsPage(driver,wait);
		ProductDetailPage productDetailPage=new ProductDetailPage(driver,wait);
		CartPage cartPage=new CartPage(driver,wait);
		 homePage.ClickOnDesktops();
			List<WebElement>productList=productsPage.ReturnProductList();
			
			int m=productList.size();
			 WebElement Product=productList.get(3);
			 
			 String expectedProductName = Product.getText();
			
	
	
		    Product.click();
	
		    String actualProductName =productDetailPage.getproductHeading();
	
		   
	
		    Assert.assertEquals(actualProductName, expectedProductName,
		            "Incorrect product details page opened.");
		    productDetailPage.clickAddToCartButton();
		    Assert.assertTrue(productDetailPage.successMessageForProductAddToart());
		    
		    homePage.clickShoppingCartIcon();
		    cartPage.clickRemoveProductButton();
		    Assert.assertTrue(cartPage.isCartEmptyHeadingDisplayed());
	}
	
//	@AfterMethod
//	public void closure()
//	{
//		driver.close();
//		
//	}
	
	
}
