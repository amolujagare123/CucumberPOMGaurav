package pages;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static stepdefinitions.SharedSD.getDriver;


//import com.gargoylesoftware.htmlunit.ElementNotFoundException;


public class BasePage {
          static WebDriver driver = getDriver();



	// This is the most common wait function used in selenium
	public static WebElement webAction(final By locator) {


		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)

				.withTimeout(Duration.ofSeconds(50))
				.pollingEvery(Duration.ofSeconds(5))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class)
				.ignoring(ElementClickInterceptedException.class)
				.withMessage(
						"Webdriver waited for 50 seconds but still could not find the element therefore Timeout Exception has been thrown");

		WebElement element = wait.until(new Function<WebDriver, WebElement>() {
					public WebElement apply(WebDriver driver) {
				return driver.findElement(locator);
			}
		});

		return element;
	}


	public ArrayList<String> getElementTextList(By locator)
	{
		List<WebElement> elements = driver.findElements(locator);

		ArrayList<String> txtList = new ArrayList<>();

		for(int i=0;i<elements.size();i++)
			txtList.add(elements.get(i).getText());

		return txtList;

	}

	public void clickOn(By locator) {


		webAction(locator).click();

		//SharedSD.getDriver().findElement(locator).click();
	}

	public void setValue(By locator, String value) {
		webAction(locator).sendKeys(value);
	}

	public String getValueFromElement(By locator) {
		return webAction(locator).getAttribute("value");
	}


	public String getTextFromElement(By locator) {
		return webAction(locator).getText();
	}

	public boolean isElementDisplayed(By locator) {
		return webAction(locator).isDisplayed();
	}

	public boolean isElementSelected(By locator) {
		return webAction(locator).isSelected();
	}

	public void selectFromDropdown(By locator, String dropdownText) {
		WebElement wb = webAction(locator);
		Select select = new Select(wb);
		//select element by visible text
		select.selectByVisibleText(dropdownText);
	}

	public void selectFromDropdown(By locator, int index) {
		WebElement wb = webAction(locator);
		Select select = new Select(wb);
		//select element by index
		select.selectByIndex(index);
	}


}
