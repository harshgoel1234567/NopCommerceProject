package Product;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import actiondriver.Action;
import base.BaseClass;
import pageobjects.HomePage;
import pageobjects.ProductDetailPage;
import pageobjects.ProductsPage;
import resources.Base;

public class ProductsTest extends BaseClass{
	private WebDriver driver;
	private WebDriverWait wait;
	Action a= new Action();
	
	@BeforeMethod
	public void openApplication() throws IOException
	{
		driver=initializeDriver();
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
	@Test
	public void verify_ProductThumbnails_AreDisplayed()
	{
		HomePage homePage=new HomePage(driver, wait);
		ProductsPage productsPage=new ProductsPage(driver,wait);
		ProductDetailPage productDetailPage=new ProductDetailPage(driver,wait);
	     homePage.ClickOnDesktops();
	     Assert.assertTrue(productsPage.isDesktopsHeadingDisplayed());
	     List<WebElement> productThumbnails =productsPage.productsThumbnail();
	     
	     Assert.assertTrue(productThumbnails.size() > 0,
	             "No product thumbnails found on the page.");
	     
	     JavascriptExecutor js = (JavascriptExecutor) driver;

	     for (WebElement thumbnail : productThumbnails) {

	         Assert.assertTrue(thumbnail.isDisplayed(),
	                 "Product thumbnail is not visible.");

	         Boolean isImageLoaded = (Boolean) js.executeScript(
	                 "return arguments[0].complete && " +
	                 "typeof arguments[0].naturalWidth != 'undefined' && " +
	                 "arguments[0].naturalWidth > 0",
	                 thumbnail);

	         Assert.assertTrue(isImageLoaded,
	                 "Product thumbnail image is broken.");
	     }
	}
    
	@Test
	public void verify_UserNavigatesToCorrectProductDetailsPage() {

		ProductsPage productsPage=new ProductsPage(driver,wait);
		ProductDetailPage productDetailPage=new ProductDetailPage(driver,wait);
		List<WebElement>productList=productsPage.ReturnProductList();
		
		 WebElement firstProduct=productList.get(0);
		 
		 String expectedProductName = firstProduct.getText();
		


	    firstProduct.click();

	    String actualProductName =productDetailPage.getproductHeading();

	   

	    Assert.assertEquals(actualProductName, expectedProductName,
	            "Incorrect product details page opened.");

	   
	}
//	@Test
//	public void verify_ProductDetails_AreDisplayedCorrectly()
//	{
//		
//	}
	
	@Test
	public void verify_ProductAddedToCart_Successfully()
	{HomePage homePage=new HomePage(driver, wait);
	
    
		ProductsPage productsPage=new ProductsPage(driver,wait);
		ProductDetailPage productDetailPage=new ProductDetailPage(driver,wait);
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
	}
	
	@Test
	public void verify_ProductsSorted_ByPriceLowToHigh()
	{
		HomePage homePage=new HomePage(driver, wait); 
			ProductsPage productsPage=new ProductsPage(driver,wait);
			ProductDetailPage productDetailPage=new ProductDetailPage(driver,wait);
			 homePage.ClickOnDesktops();
			 productsPage.selectPriceLowToHigh();
				List<Double>productPrices=productsPage.getProductPrices();
				
				List<Double> actualList = productPrices;

				// Create copy
				List<Double> sortedList = new ArrayList<>(actualList);

				// Sort copy
				Collections.sort(sortedList);

				// Compare
				Assert.assertEquals(actualList, sortedList, 
				        "Products are NOT sorted in Low to High order");

				
	}
	@Test
	public void verify_ProductsSorted_ByRatingsLowToHigh()
	{
		HomePage homePage=new HomePage(driver, wait); 
		ProductsPage productsPage=new ProductsPage(driver,wait);
		ProductDetailPage productDetailPage=new ProductDetailPage(driver,wait);
		 homePage.ClickOnDesktops();
		 productsPage.selectNameFromAtoZ();
			List<String>productPrices=productsPage.getProductName();
			
			List<String> actualList = productPrices;

			// Create copy
			List<String> sortedList = new ArrayList<>(actualList);

			// Sort copy
			Collections.sort(sortedList);

			// Compare
			Assert.assertEquals(actualList, sortedList, 
			        "Products are NOT sorted in Name(A-Z)");

	}	
		
		
		@AfterMethod

	public void closure()
	{
		driver.close();
		
	}
	
}
