package tests;

import dataprovider.TableRecordProvider;
import model.TableRecord;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.WebTablesPage;

public class TableTest extends BaseTest{

    @Test(dataProvider = "tableRecords", dataProviderClass = TableRecordProvider.class)
    public void addNewRecordTest(TableRecord record){
        System.out.println(record);
        WebTablesPage tablesPage = new WebTablesPage(driver);
        tablesPage.addNewRecord(record);

        Assert.assertTrue(tablesPage.checkIfRecordPresent(record.getEmail()));
    }

    @Test(dataProvider = "tableRecords", dataProviderClass = TableRecordProvider.class)
    public void editRecordTest(TableRecord record){
        WebTablesPage tablesPage = new WebTablesPage(driver);
        tablesPage.editRecord(1, record);

        Assert.assertTrue(tablesPage.checkIfRecordPresent(record.getEmail()));
        Assert.assertEquals(tablesPage.getRecord(record.getEmail()), record);
    }

    @Test(dataProvider = "tableRecords", dataProviderClass = TableRecordProvider.class)
    public void deleteRecordTest(TableRecord record){
        WebTablesPage tablesPage = new WebTablesPage(driver);
        tablesPage.addNewRecord(record);

        Assert.assertTrue(tablesPage.checkIfRecordPresent(record.getEmail()));

        tablesPage.deleteRecord(record.getEmail());

        Assert.assertFalse(tablesPage.checkIfRecordPresent(record.getEmail()));

    }
}
