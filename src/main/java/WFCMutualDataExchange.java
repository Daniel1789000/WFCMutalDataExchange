import java.util.HashMap;
import java.util.Vector;

public class WFCMutualDataExchange {
    public static void main(String[] args) throws Exception {
        if(args.length >= 1) {
            Vector<BalanceRecord> balanceRecords;
            try (ImportCSVToVector importer = new ImportCSVToVector(args[0])) {
                balanceRecords = importer.getBalances();
            }
            System.out.println("imported " + balanceRecords.size() + " records");

            HashMap<String, SummaryRecord> summaryMap = new HashMap<>();
            for (BalanceRecord balanceRecord : balanceRecords) {
                if (summaryMap.containsKey(balanceRecord.getState())) {
                    summaryMap.get(balanceRecord.getState()).setBalance(balanceRecord.getBalance());
                } else {
                    SummaryRecord summaryRecord = new SummaryRecord(balanceRecord.getState(), balanceRecord.getBalance());
                    summaryMap.put(balanceRecord.getState(), summaryRecord);
                }
            }
            String lineEnding;
            if (isWindows()) {
                lineEnding = "\r\n";
            } else {
                lineEnding = "\r";
            }
            //write the column names as the first line in the summary file
            Vector<String> columnNames = SummaryRecord.getColumnNames();
            String header = "";
            for (int index = 0; index < columnNames.size(); index++) {
                header = header.concat(columnNames.get(index));
                if (index < columnNames.size() - 1) {
                    header = header.concat(",");
                } else {
                    header = header.concat(lineEnding);
                }
            }
            try (SummaryTable summaryTable = new SummaryTable(System.getProperty("user.home") +
                    "\\Downloads\\java-developer-data-exchange-master\\java-developer-data-exchange-master\\summary.csv")) {
                summaryTable.writeHeader(header);
                //now write the values
                for (SummaryRecord summaryRecord : summaryMap.values()) {
                    Vector<String> values = summaryRecord.getValues();
                    String summaryString = "";
                    for (int index = 0; index < values.size(); index++) {
                        summaryString = summaryString.concat(values.get(index));
                        if (index < values.size() - 1) {
                            summaryString = summaryString.concat(",");
                        } else {
                            summaryString = summaryString.concat(lineEnding);
                        }
                    }
                    summaryTable.writeRecord(summaryString);
                }
            }
        }else{
            throw new IllegalArgumentException("A file name must be provided on the command line");
        }
    }
    private static boolean isWindows(){
        boolean result = false;
        String OS = System.getProperty("os.name");
        if(OS != null){
            result = OS.startsWith("Windows");
        }
        return result;
    }
}
