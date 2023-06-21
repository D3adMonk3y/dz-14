package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ElementsPage extends AbstractPageObject{

    private final By buttons = By.cssSelector("#item-4");
    private final By clickMeButton = By.xpath("//button[text() =\"Click Me\"]");
    private final By textUnderButton = By.xpath("//*[@id=\"dynamicClickMessage\"]");

    public ElementsPage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/elements");
    }

    public String getText(){
        getElement(buttons, 4).click();
        getElement(clickMeButton, 4).click();
        return getElement(textUnderButton).getText();
    }
}
