import java.io.*;
import java.util.Scanner;
import java.util.Vector;

public class ImportCSVToVector implements java.lang.AutoCloseable{
    Scanner scanner;
    public ImportCSVToVector(String fileName) throws FileNotFoundException {
        scanner = new Scanner(new File(fileName));
        scanner.useDelimiter(",");
    }
    public Vector<BalanceRecord> getBalances(){
        Vector<BalanceRecord>result = new Vector<>();
        String columnOrder;
        if(scanner.hasNext()){
            //first line should have the order of the columns
            columnOrder = scanner.nextLine();
            if(columnOrder.contains("FIRST_NAME")) {
                while (scanner.hasNext()) {
                    String row = scanner.nextLine();
                    result.add(new BalanceRecord(columnOrder,row));
                }
            }else{
                //first line did not contain the  column order so use the default
                result.add(new BalanceRecord(columnOrder));
                while (scanner.hasNext()) {
                    String row = scanner.nextLine();
                    result.add(new BalanceRecord(row));
                }
            }
        }
        return result;
    }

    @Override
    public void close(){
        if(scanner != null){
            scanner.close();
        }
    }
}
