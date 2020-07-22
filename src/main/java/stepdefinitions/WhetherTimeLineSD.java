package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DarkSkyHome;

import java.util.ArrayList;
import java.util.Collections;

public class WhetherTimeLineSD {

    DarkSkyHome darkSkyHome = new DarkSkyHome();

    @Given("I am on Darksky Home Page")
    public void i_am_on_Darksky_Home_Page() {
        Assert.assertEquals("Dark Sky - Range Hills Road, Pune, Maharashtra",
                SharedSD.getDriver().getTitle());
    }

    @Then("I verify current temp is not greater or less then temps from daily timeline")
    public void i_verify_current_temp_is_not_greater_or_less_then_temps_from_daily_timeline() {


        System.out.println(darkSkyHome.getCurrTemp());
        System.out.println(darkSkyHome.getTimeLineTemp());

        Assert.assertEquals("tempratures are not equal",darkSkyHome.getCurrTemp(),darkSkyHome.getTimeLineTemp());

    }


    @Then("^I verify timeline is displayed with two hours incremented$")
    public void i_verify_timeline_is_displayed_with_two_hours_incremented() throws Throwable {

            ArrayList<Integer> timeList =  darkSkyHome.getTimeListInt();

            /*ArrayList<Integer> expteced = new ArrayList<>();
            for(int i=0;i<10;i++)
                expteced.add(2);
*/
            ArrayList<Integer> actual = new ArrayList<>();

            for(int i=0;i<timeList.size()-1;i++) // 11
            {
                int time1 = timeList.get(i);
                int time2 = timeList.get(i+1);

                int timeDiff=0;

                 if(time2>time1)
                 timeDiff= time2-time1;

                 if(time2<time1)
                     timeDiff= (time2+12)-time1;

                 actual.add(timeDiff);
            }


       // System.out.println("Expected List:"+expteced);
        System.out.println("Actual List:"+actual);

        int occarance= Collections.frequency(actual,2);
        int size = actual.size();

        System.out.println(occarance==size); // this value should be true in order to pass the test

        Assert.assertTrue("time difference is not correct",occarance==size);

        // it gives the occarance of an element in the list

       // Assert.assertEquals("time difference is not correct",expteced,actual);

    }


    @Then("^I verify lowest and highest temp is displayed correctly$")
    public void i_verify_lowest_and_highest_temp_is_displayed_correctly() throws Throwable {
          darkSkyHome.clickExpanderIcon();
    }
}
