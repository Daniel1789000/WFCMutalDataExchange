import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Vector;

class ImportCSVToVectorTest {
    ImportCSVToVector importer;

    @Test
    void testFileNotFound() throws Exception {
        try {
            ImportCSVToVector csv = new ImportCSVToVector("somenonexitentfile");
        } catch (FileNotFoundException e) {
            return;
        }
        //should not get here
        throw new Exception();
    }

    private void getImporter() throws FileNotFoundException {
        try {
            importer = new ImportCSVToVector("balances.csv");
        } catch (FileNotFoundException ignored) {
        }
        importer = new ImportCSVToVector(new StringBuilder().
                append(System.getProperty("user.home")).
                append("\\Downloads\\java-developer-data-exchange-master\\java-developer-data-exchange-master\\balances.csv").
                toString());

    }

    @Test
    void testImportFile() throws FileNotFoundException {
        getImporter();
    }


    @Test
    void getVector() throws FileNotFoundException {
        if(importer == null){
            getImporter();
        }
        if(importer != null){
            Vector<BalanceRecord> balanceRecords = importer.getBalances();
        }
    }
}