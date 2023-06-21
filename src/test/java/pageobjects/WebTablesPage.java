package pageobjects;

import model.TableRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class WebTablesPage extends AbstractPageObject{

    private final By addButton = By.cssSelector("#addNewRecordButton");
    private final By submitButton = By.cssSelector("#submit");

    private final By firstNameField = By.cssSelector("#firstName");
    private final By lastNameField = By.cssSelector("#lastName");
    private final By emailField = By.cssSelector("#userEmail");
    private final By ageField = By.cssSelector("#age");
    private final By salaryField = By.cssSelector("#salary");
    private final By departmentField = By.cssSelector("#department");


    public WebTablesPage(WebDriver driver) {
        super(driver);
        driver.get("https://demoqa.com/webtables");
    }

    public void addNewRecord(TableRecord record){
        getElement(addButton).click();

        getElement(firstNameField, 5).sendKeys(record.getFirstName());
        getElement(lastNameField).sendKeys(record.getLastName());
        getElement(emailField).sendKeys(record.getEmail());
        getElement(ageField).sendKeys(record.getAge() + "");
        getElement(salaryField).sendKeys(record.getSalary());
        getElement(departmentField).sendKeys(record.getDepartment());

        getElement(submitButton).click();
    }

    public TableRecord getRecord(String email){
        String firstPart = "//div[text() = \"" + email + "\"]/..//div[@role = \"gridcell\"][";

        return new TableRecord(
                getElement(By.xpath(firstPart + "1]"), 5).getText(),
                getElement(By.xpath(firstPart + "2]")).getText(),
                getElement(By.xpath(firstPart + "4]")).getText(),
                Integer.parseInt(getElement(By.xpath(firstPart + "3]")).getText()),
                getElement(By.xpath(firstPart + "5]")).getText(),
                getElement(By.xpath(firstPart + "6]")).getText());
    }

    //Use email for identifying record in table, because email is only one unique field
    public boolean checkIfRecordPresent(String email){
        List<WebElement> tableRows = driver.findElements(By.xpath("//div[text() = \"" + email + "\"]/.."));

        if(tableRows.size() != 0){
            return true;
        }else{
            System.out.println("There is no such record present in the table");
            return false;
        }
    }

    public void editRecord(int id , TableRecord record){
      getElement(By.xpath("//*[@id=\"edit-record-" + id + "\"]")).click();



        getElement(firstNameField, 5).clear();
        getElement(firstNameField).sendKeys(record.getFirstName());

        getElement(lastNameField,5).clear();
        getElement(lastNameField).sendKeys(record.getLastName());

        getElement(emailField,5).clear();
        getElement(emailField).sendKeys(record.getEmail());

        getElement(ageField,5).clear();
        getElement(ageField).sendKeys(record.getAge() + "");

        getElement(salaryField,5).clear();
        getElement(salaryField).sendKeys(record.getSalary());

        getElement(departmentField,5).clear();
        getElement(departmentField).sendKeys(record.getDepartment());

        getElement(submitButton).click();

    }

    public void deleteRecord(String email){
       getElement(By.xpath("//div[text()=\"" + email + "\"]/..//span[starts-with(@id, \"delete\")]"),5).click();
    }
}
