package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import stepdefinitions.SharedSD;

import java.util.ArrayList;

public class HotelsHome extends BasePage{

    By destinationTextBox = By.xpath("//input[@id='qf-0q-destination']");
    By searchButton = By.xpath("//button[@type='submit']");


   By starList = By.xpath("//span[contains(@class,'star-rating-text')]");


   public ArrayList<String> getstrList()
   {
       return getElementTextList(starList); //  5-star
   }






    public void setDestinationTextBox(String city)
    {
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("arguments[0].setAttribute('value','"+city+"')",driver.findElement(destinationTextBox));

    }

    public void clickSearchButton()
    {
        clickOn(searchButton);
    }



}
