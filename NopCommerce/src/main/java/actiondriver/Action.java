package actiondriver;
import base.BaseClass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;

import actionInterface.ActionInterface;

public class Action  implements ActionInterface {

	
	@Override
	public void scrollByVisibilityOfElement(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView()",ele);
	}
	
	@Override
	public void click(WebDriver driver,WebElement ele)
	{
		Actions act=new Actions(driver);
		act.moveToElement(ele).click().build().perform();
	}
	@Override
	public boolean isElementDisplayed(WebDriver driver,WebElement ele)
	{
		boolean flag=false;
		try {
			flag=ele.isDisplayed();
			flag=true;
		}
		catch(Exception e)
		{
			flag=false;
		}
		return flag;
	}
	@Override
	public boolean isSelected(WebDriver driver,WebElement element)
	{
		boolean flag=isElementDisplayed(driver,element);
		
		if(flag)
		{
			flag=element.isSelected();
			
		}
		else
			flag=false;
		
		return flag;
		
	}
	@Override
	public boolean isEnabled(WebDriver driver,WebElement element)
	{
       boolean flag=isElementDisplayed(driver,element);
		
		if(flag)
		{
			flag=element.isEnabled();
			
		}
		else
			flag=false;
		
		return flag;
		
		
	}
	@Override
	public boolean typeIntoElement(WebElement ele,String text)
	{
		 boolean flag=ele.isDisplayed();
		
		 try {
			 ele.clear();
			 ele.sendKeys(text);
		 }
		 catch(Exception e){
			 
			 flag=false;
		 }
		 return true;
	}
	@Override
	public boolean selectByIndex(WebElement ele,int index)
	{
		boolean flag=false;
		try {
			Select s=new Select(ele);
			s.selectByIndex(index);
			flag=true;
			return true;
		}
		catch(Exception e)
		{
			return  false;
		}
		
	}
	@Override
public boolean selectByValue(WebElement ele,String value)
	{
		boolean flag=false;
		try {
			Select s=new Select(ele);
			s.selectByValue(value);
			flag=true;
			return true;
		}
		catch(Exception e)
		{
			return  false;
		}
		
	}
@Override
public boolean selectByVisibleText(String visibletext, WebElement ele) {
	boolean flag = false;
	try {
		Select s = new Select(ele);
		s.selectByVisibleText(visibletext);
		flag = true;
		return true;
	} catch (Exception e) {
		return false;
	} finally {
		if (flag) {
			System.out.println("Option selected by VisibleText");
		} else {
			System.out.println("Option not selected by VisibleText");
		}
	}
}

@Override
public boolean mouseHoverByJavaScript(WebDriver driver,WebElement ele) {
	boolean flag = false;
	try {
		WebElement mo = ele;
		String javaScript = "var evObj = document.createEvent('MouseEvents');"
				+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
				+ "arguments[0].dispatchEvent(evObj);";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(javaScript, mo);
		flag = true;
		return true;
	}

	catch (Exception e) {

		return false;
	} finally {
		if (flag) {
			System.out.println("MouseOver Action is performed");
		} else {
			System.out.println("MouseOver Action is not performed");
		}
	}
}

	@Override
	public boolean JSclick(WebDriver driver,WebElement ele)
	{
		boolean flag=false;
		
		try {
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",ele);
			
			flag=true;
		}
		catch (Exception e) {
			throw e;

		} finally {
			if (flag) {
				System.out.println("Click Action is performed");
			} else if (!flag) {
				System.out.println("Click Action is not performed");
			}
		}
		return flag;
	}

//	@Override
//	public boolean switchToFrameByIndex(WebDriver driver,int index) {
//		boolean flag = false;
//		try {
//			new WebDriverWait(driver, 15).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe")));
//			driver.switchTo().frame(index);
//			flag = true;
//			return true;
//		} catch (Exception e) {
//
//			return false;
//		} finally {
//			if (flag) {
//				System.out.println("Frame with index \"" + index + "\" is selected");
//			} else {
//				System.out.println("Frame with index \"" + index + "\" is not selected");
//			}
//		}
//	}
//
//	/**
//	 * This method switch the to frame using frame ID.
//	 * 
//	 * @param idValue : Frame ID wish to switch
//	 * 
//	 */
//	@Override
//	public boolean switchToFrameById(WebDriver driver,String idValue) {
//		boolean flag = false;
//		try {
//			driver.switchTo().frame(idValue);
//			flag = true;
//			return true;
//		} catch (Exception e) {
//
//			e.printStackTrace();
//			return false;
//		} finally {
//			if (flag) {
//				System.out.println("Frame with Id \"" + idValue + "\" is selected");
//			} else {
//				System.out.println("Frame with Id \"" + idValue + "\" is not selected");
//			}
//		}
//	}
//	

	@Override
	public boolean switchToDefaultContent(WebDriver driver)
	{
		boolean flag=false;
		try {
			driver.switchTo().defaultContent();
			flag=true;
			return flag;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public void mouseOverElement(WebDriver driver,WebElement element) {
		boolean flag = false;
		try {
			new Actions(driver).moveToElement(element).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (flag) {
				System.out.println(" MouserOver Action is performed on ");
			} else {
				System.out.println("MouseOver action is not performed on");
			}
		}
	}
	@Override
	public boolean moveToElement(WebDriver driver, WebElement ele) {
		boolean flag = false;
		try {
			// WebElement element = driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", ele);
			Actions actions = new Actions(driver);
			// actions.moveToElement(driver.findElement(locator)).build().perform();
			actions.moveToElement(ele).build().perform();
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	@Override
	public boolean draggable(WebDriver driver,WebElement element,int x,int y)
	{
		boolean flag=false;
		try {
			new Actions(driver).dragAndDropBy(element, x, y);
			flag = true;
			return true;
		}
	catch (Exception e) {
		
		return false;
		
	} finally {
		if (flag) {
			System.out.println("Draggable Action is performed on ");
		} else if(!flag) {
			System.out.println("Draggable action is not performed on ");
		}
	}
	}
	
	@Override
	public void sendKeys(WebElement ele,String text)
	{
		ele.sendKeys(text);
	}
	@Override
	public boolean draganddrop(WebDriver driver,WebElement source, WebElement target) {
		boolean flag = false;
		try {
			new Actions(driver).dragAndDrop(source, target).perform();
			flag = true;
			return true;
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("DragAndDrop Action is performed");
			} else if(!flag) {
				System.out.println("DragAndDrop Action is not performed");
			}
		}
	}
	@Override
	public boolean rightclick(WebDriver driver,WebElement ele) {
		boolean flag = false;
		try {
			Actions clicker = new Actions(driver);
			clicker.contextClick(ele).perform();
			flag = true;
			return true;
			// driver.findElement(by1).sendKeys(Keys.DOWN);
		} catch (Exception e) {

			return false;
		} finally {
			if (flag) {
				System.out.println("RightClick Action is performed");
			} else {
				System.out.println("RightClick Action is not performed");
			}
		}
	}
	@Override
	public boolean Alert(WebDriver driver) {
		boolean presentFlag = false;
		Alert alert = null;

		try {
			// Check the presence of alert
			alert = driver.switchTo().alert();
			// if present consume the alert
			alert.accept();
			presentFlag = true;
		} catch (NoAlertPresentException ex) {
			// Alert present; set the flag

			// Alert not present
			ex.printStackTrace();
		} finally {
			if (!presentFlag) {
				System.out.println("The Alert is handled successfully");		
			} else{
				System.out.println("There was no alert to handle");
			}
		}

		return presentFlag;
	}
	@Override
	public boolean launchUrl(WebDriver driver,String url) {
		boolean flag = false;
		try {
			driver.navigate().to(url);
			flag = true;
			return true;
		} catch (Exception e) {
			return false;
		} finally {
			if (flag) {
				System.out.println("Successfully launched \""+url+"\"");				
			} else {
				System.out.println("Failed to launch \""+url+"\"");
			}
		}
	}
	@Override
	public boolean isAlertPresent(WebDriver driver) 
	{ 
		try 
		{ 
			driver.switchTo().alert(); 
			return true; 
		}   // try 
		catch (NoAlertPresentException Ex) 
		{ 
			return false; 
		}   // catch 
	}
	@Override
	public String getTitle(WebDriver driver) {
		boolean flag = false;

		String text = driver.getTitle();
		if (flag) {
			System.out.println("Title of the page is: \""+text+"\"");
		}
		return text;
	}
	@Override
	public String getCurrentURL(WebDriver driver)  {
		boolean flag = false;

		String text = driver.getCurrentUrl();
		if (flag) {
			System.out.println("Current URL is: \""+text+"\"");
		}
		return text;
	}

	@Override
	public void fluentWait(WebDriver driver, WebElement element, int timeOut) {
		  Wait<WebDriver> wait = null;
		    try {
		        wait = new FluentWait<WebDriver>((WebDriver) driver)
		        		.withTimeout(Duration.ofSeconds(20))
		        	    .pollingEvery(Duration.ofSeconds(2))
		        	    .ignoring(Exception.class);
		        wait.until(ExpectedConditions.visibilityOf(element));
		        element.click();
		    }catch(Exception e) {
		    }
		
	}
	@Override
	public void implicitWait(WebDriver driver, int timeOut) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
	}
	@Override
	public void explicitWait(WebDriver driver, WebElement element,WebDriverWait wait) {
		
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	@Override
	public void pageLoadTimeOut(WebDriver driver, int timeOut) {
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(timeOut));
	}
	@Override
	public String screenShot(WebDriver driver, String filename) {
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\ScreenShots\\" + filename + "_" + dateName + ".png";

		try {
			FileUtils.copyFile(source, new File(destination));
		} catch (Exception e) {
			e.getMessage();
		}
		// This new path for jenkins
		String newImageString = "http://localhost:8082/job/MyStoreProject/ws/MyStoreProject/ScreenShots/" + filename + "_"
				+ dateName + ".png";
		return newImageString;
	}
	@Override
	public String getCurrentTime() {
		String currentDate = new SimpleDateFormat("yyyy-MM-dd-hhmmss").format(new Date());
		return currentDate;
	}
	
};