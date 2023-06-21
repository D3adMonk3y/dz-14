package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public abstract class AbstractPageObject {
    private final static int DURATION_TO_WAIT_DEFAULT = 4;
    protected WebDriver driver;

    public AbstractPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(By by, int waitForSeconds){
        return new WebDriverWait(driver, Duration.ofSeconds(waitForSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement getElement(By by){
        return new WebDriverWait(driver, Duration.ofSeconds(DURATION_TO_WAIT_DEFAULT))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public List<WebElement> getElements(By by, int waitForSeconds){
        return new WebDriverWait(driver, Duration.ofSeconds(waitForSeconds))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public List<WebElement> getElements(By by){
        return new WebDriverWait(driver, Duration.ofSeconds(DURATION_TO_WAIT_DEFAULT))
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public void waitTillAppears(By by, int waitForSeconds){
        new WebDriverWait(driver, Duration.ofSeconds(waitForSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitTillAppears(By by){
        new WebDriverWait(driver, Duration.ofSeconds(DURATION_TO_WAIT_DEFAULT))
                .until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void waitTillDisappear(By by, int waitForSeconds){
        new WebDriverWait(driver, Duration.ofSeconds(waitForSeconds))
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public void waitTillDisappear(By by){
        new WebDriverWait(driver, Duration.ofSeconds(DURATION_TO_WAIT_DEFAULT))
                .until(ExpectedConditions.invisibilityOfElementLocated(by));
    }

}
