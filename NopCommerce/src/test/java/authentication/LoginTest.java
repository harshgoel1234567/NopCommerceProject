package authentication;


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
import pageobjects.HomePage;
import pageobjects.LoginPage;
import pageobjects.RegisterPage;

public class LoginTest extends BaseClass{

	
	private WebDriver driver;
	private WebDriverWait wait;
	Action a= new Action();
	
	@BeforeMethod
	public void openApplication() throws IOException
	{
		driver=initializeDriver();
		wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	
//	@Test
//	public void loginWithValidFields()
//	{
//		HomePage homePage=new HomePage(driver, wait);
//		//RegisterPage registerPage=new RegisterPage(driver,wait);
//		
//		LoginPage loginPage= new LoginPage(driver, wait);
//		
//		
//		homePage.clickLoginButton();
//		
//		loginPage.LoginField("neerajgo936@gmail.com");
//		loginPage.PasswordField("Pencil123");
//		loginPage.clickLoginButton();
//		
//		Assert.assertTrue(homePage.isLogOutButtonDisplayed());
//		
//	}
//	
//	@Test
//	public void loginWithInvalidCredentials()
//	{
//		HomePage homePage=new HomePage(driver, wait);
//	
//		LoginPage loginPage= new LoginPage(driver, wait);
//		
//		
//		homePage.clickLoginButton();
//		
//		loginPage.LoginField("neerajgo936@gmail.com");
//		loginPage.PasswordField("Pencil13");
//		loginPage.clickLoginButton();
//		
//		Assert.assertTrue(loginPage.valiateInvalidLoginCredentialAlert());
//		
//	}

	@Test
	public void loginWithEmptyCredentials()
	{
		HomePage homePage=new HomePage(driver, wait);
	
		LoginPage loginPage= new LoginPage(driver, wait);
		
		
		homePage.clickLoginButton();
		
		loginPage.LoginField("");
		loginPage.PasswordField("Pencil13");
		loginPage.clickLoginButton();
		
		Assert.assertTrue(loginPage.valiateInvalidLoginCredentialAlert());
		
	}
	
	@AfterMethod
	public void closure()
	{
		driver.close();
		
	}
	
	
}
