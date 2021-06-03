import java.util.HashMap;

public class BalanceRecord {
    String firstName;
    String lastName;
    String address;
    String city;
    String state;
    String zip;
    String phone;
    String balanceString;
    float balance;
    static String FIRST_NAME = "FIRST_NAME";
    static String LAST_NAME = "LAST_NAME";
    static String ADDRESS = "ADDRESS";
    static String CITY = "CITY";
    static String STATE = "STATE";
    static String ZIP = "ZIP";
    static String PHONE = "PHONE";
    static String BALANCE = "BALANCE";
    HashMap<String,Integer> columnOrder;
    //figure out the column order
    BalanceRecord(String _columnOrder, String row){
        columnOrder = orderOfColumns(_columnOrder);
        String[] columnValues = row.split(",");
        firstName = columnValues[columnOrder.get(FIRST_NAME)];
        lastName = columnValues[columnOrder.get(LAST_NAME)];
        address = columnValues[columnOrder.get(ADDRESS)];
        city = columnValues[columnOrder.get(CITY)];
        state = columnValues[columnOrder.get(STATE)];
        zip = columnValues[columnOrder.get(ZIP)];
        phone = normalizePhoneNumber(columnValues[columnOrder.get(PHONE)]);
        balanceString = columnValues[columnOrder.get(BALANCE)];
        if(balanceString.contains("$")) {
            //if the '$' character is not in the first position then all bets are off
            balanceString = balanceString.substring(1);
        }
        balance = Float.parseFloat(balanceString);
    }
    //use the default column order
    BalanceRecord(String row){
        this("FIRST_NAME,LAST_NAME,ADDRESS,CITY,STATE,ZIP,PHONE,BALANCE",row);
    }
    public String getState(){
        return state;
    }

    public float getBalance(){
        return balance;
    }
    private String normalizePhoneNumber(String phoneNumber){
        String result;
        result = phoneNumber.replaceAll("[^0-9]", "");
        return result;
    }
    private int indexOfColumn(String[] columns,String column){
        int result = -1;
        int index = 0;
        for(String currentColumn : columns){
            if(currentColumn.equalsIgnoreCase(column)){
                result = index;
                break;
            }
            index++;
        }
        return result;
    }
    private HashMap<String,Integer> orderOfColumns(String row){
        HashMap<String,Integer> result = new HashMap<>();
        String[] columns = row.split(",");
        result.put(FIRST_NAME,indexOfColumn(columns,FIRST_NAME));
        result.put(LAST_NAME,indexOfColumn(columns,LAST_NAME));
        result.put(ADDRESS,indexOfColumn(columns,ADDRESS));
        result.put(CITY,indexOfColumn(columns,CITY));
        result.put(STATE,indexOfColumn(columns,STATE));
        result.put(ZIP,indexOfColumn(columns,ZIP));
        result.put(PHONE,indexOfColumn(columns,PHONE));
        result.put(BALANCE,indexOfColumn(columns,BALANCE));
        return result;
    }
}
