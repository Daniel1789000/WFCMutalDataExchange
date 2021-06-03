import java.util.Vector;

public class SummaryRecord {

    static final String STATE = "STATE";
    static final String MIN_BALANCE = "MIN_BALANCE";
    static final String MAX_BALANCE = "MAX_BALANCE";
    static final String MEAN_BALANCE = "MEAN_BALANCE";
    static final String TOTAL_BALANCE = "TOTAL_BALANCE";
    private final String state;
    private float minBalance;
    private float maxBalance;
    private float meanBalance;
    private float totalBalance;
    private int numBalances;
    public SummaryRecord(String _state,float balance){
        state = _state;
        minBalance = balance;
        maxBalance = balance;
        meanBalance = balance;
        totalBalance = balance;
        numBalances = 1;
    }
    public void setBalance(float balance){
        numBalances ++;
        if(balance < minBalance){
            minBalance = balance;
        }
        if(balance > maxBalance){
            maxBalance = balance;
        }
        totalBalance += balance;
        meanBalance = totalBalance/numBalances;
    }
    public static Vector<String> getColumnNames(){
        Vector<String> result = new Vector<>();
        result.add(STATE);
        result.add(MIN_BALANCE);
        result.add(MAX_BALANCE);
        result.add(MEAN_BALANCE);
        result.add(TOTAL_BALANCE);
        return result;
    }
    public Vector<String> getValues(){
        Vector<String> result = new Vector<>();
        result.add(state);
        result.add(Float.toString(minBalance));
        result.add(Float.toString(maxBalance));
        result.add(Float.toString(meanBalance));
        result.add(Float.toString(totalBalance));
        return result;
    }
}
