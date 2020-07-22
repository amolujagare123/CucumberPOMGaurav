package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.HotelsHome;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class StarVerify {
    HotelsHome hotelsHome =new  HotelsHome();

    @Given("^I am on default locations search result screen$")
    public void i_am_on_default_locations_search_result_screen() {

        try {
            hotelsHome.setDestinationTextBox("Mumbai, India");
            hotelsHome.clickSearchButton();
        }
        catch (Throwable e)
        {
            e.printStackTrace();
        }
    }

    @When("^I select property class (.+)$")
    public void i_select_property_class(String stars)  // 5 stars
    {

        String starNumber=stars.split(" ")[0];

       // SharedSD.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        SharedSD.getDriver().navigate().refresh();
         SharedSD.getDriver().findElement(By.xpath("//input[@id='f-star-rating-"+starNumber+"']")).click();

    }

    @Then("^I verify system displays only (.+) hotels on search result$")
    public void i_verify_system_displays_only_hotels_on_search_result(String stars) // 5 stars

    {
             String convertedStarExpected =  stars.split(" ")[0]+"-star";


             ArrayList starList = hotelsHome.getstrList() ; // 5-star

                  System.out.println(starList); // {5-star,5-star,5-star,5-star,5-star}

                  int ocarance =  Collections.frequency(starList,convertedStarExpected);
                   int size = starList.size();

              boolean result = ocarance==size;

      //Assert.assertTrue("test is failed",result);

        Assert.assertTrue("all hotels does not have:"+convertedStarExpected,result);

    }

}
