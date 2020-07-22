package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import stepdefinitions.SharedSD;

import java.util.ArrayList;

public class DarkSkyHome extends  BasePage{

    By currTemp = By.xpath("//span[@class='summary swap']");
    By timeLine = By.xpath("//span[@class='first']//span");
    By timeTextList = By.xpath("//span[@class='hour']/span");
    By  expanderIcon = By.xpath("//a[@data-day='0']");

    // write a method that will give us a list of number (time)

    public void  clickExpanderIcon()
    {
        JavascriptExecutor js = (JavascriptExecutor) SharedSD.getDriver();
        js.executeScript("window. scrollBy(0,1200)", "");

        clickOn(expanderIcon);

       // js.executeScript("arguments[0].click",driver.findElement(expanderIcon));
    }


    public ArrayList<Integer> getTimeListInt()
    {
        ArrayList<Integer> timeListInt = new ArrayList<>();


        System.out.println(getElementTextList(timeTextList));

        ArrayList<String> timeListStr = getElementTextList(timeTextList);

        for (int i=0;i<timeListStr.size();i++)
        {
             int l = timeListStr.get(i).length();

            timeListInt.add(Integer.parseInt(timeListStr.get(i).substring(0,l-2)));


        }

        System.out.println(timeListInt);


        return  timeListInt;
    }

    public String getCurrTemp()
    {
        String temp = getTextFromElement(currTemp); // 78˚ Humid and Overcast.

        return temp.split("˚")[0];
    }

    public String getTimeLineTemp()
    {
        String temp = getTextFromElement(timeLine); // 78°

        return temp.split("°")[0];
    }




}
