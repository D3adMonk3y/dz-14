package tests;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.ElementsPage;

public class ClickMeTest extends BaseTest{
    @Test
    @Description("This test check if text under button after pressing is correct")
    public void ClickMe(){

        String textUnderButton = new ElementsPage(driver).getText();
        System.out.println(textUnderButton);

        String rightText = "You have done a dynamic click";
        Assert.assertEquals(textUnderButton, rightText);
    }
}
