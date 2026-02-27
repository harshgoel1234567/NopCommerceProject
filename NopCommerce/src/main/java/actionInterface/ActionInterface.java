package actionInterface;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface ActionInterface {

	void scrollByVisibilityOfElement(WebDriver driver, WebElement element);

	void click(WebDriver driver, WebElement ele);

	boolean isElementDisplayed(WebDriver driver, WebElement ele);

	boolean isSelected(WebDriver driver, WebElement element);

	boolean isEnabled(WebDriver driver, WebElement element);

	boolean typeIntoElement(WebElement ele, String text);

	boolean selectByIndex(WebElement ele, int index);

	boolean selectByValue(WebElement ele, String value);

	boolean selectByVisibleText(String visibletext, WebElement ele);

	

	boolean mouseHoverByJavaScript(WebDriver driver, WebElement ele);

	boolean JSclick(WebDriver driver, WebElement ele);

	boolean switchToDefaultContent(WebDriver driver);

	void mouseOverElement(WebDriver driver, WebElement element);

	boolean moveToElement(WebDriver driver, WebElement ele);

	boolean draggable(WebDriver driver, WebElement element, int x, int y);

	boolean draganddrop(WebDriver s, WebElement source, WebElement target);

	boolean rightclick(WebDriver driver, WebElement ele);

	boolean Alert(WebDriver driver);

	boolean launchUrl(WebDriver driver, String url);

	boolean isAlertPresent(WebDriver driver);

	String getTitle(WebDriver driver);

	String getCurrentURL(WebDriver driver);

	void fluentWait(WebDriver driver, WebElement element, int timeOut);

	void implicitWait(WebDriver driver, int timeOut);

	void explicitWait(WebDriver driver, WebElement element, WebDriverWait wait);

	void pageLoadTimeOut(WebDriver driver, int timeOut);

	String screenShot(WebDriver driver, String filename);

	String getCurrentTime();


	void sendKeys(WebElement ele, String text);

}
