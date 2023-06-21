package dataprovider;

import model.TableRecord;
import org.testng.annotations.DataProvider;

import java.util.LinkedList;
import java.util.List;

public class TableRecordProvider {

    @DataProvider(name = "tableRecords")
    public static Object[][] tableRecords(){
        List<TableRecord> tableRecords = new LinkedList<>();
        tableRecords.add(new TableRecord(
                "John",
                "Dou",
                "JohnDou@gmail.com",
                33,
                "5000",
                "QA"));
        tableRecords.add(new TableRecord(
                "David",
                "Simpson",
                "David1993@gmail.com",
                30,
                "12000",
                "Developer"));

      Object[][] objects = new Object[tableRecords.size()][1];

        for(int i = 0; i < tableRecords.size(); i++){
            objects[i][0] = tableRecords.get(i);
        }

        return objects;
    }
}
