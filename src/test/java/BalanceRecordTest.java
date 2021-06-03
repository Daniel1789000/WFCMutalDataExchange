import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.*;

class BalanceRecordTest {

    @Test
    void balanceRecordConstructors() {
        assertThrows(IllegalArgumentException.class,()->{BalanceRecord balanceRecord = new BalanceRecord(null);});
        assertThrows(IllegalArgumentException.class,()->{BalanceRecord balanceRecord = new BalanceRecord(null,null);});
        assertThrows(IllegalArgumentException.class,()->{BalanceRecord balanceRecord = new BalanceRecord("");});
        assertThrows(IllegalArgumentException.class,()->{BalanceRecord balanceRecord = new BalanceRecord("","");});
    }
    @Test
    void balanceRecordGetState(){
        BalanceRecord balanceRecord = new BalanceRecord("Katharine,Kshlerin,0369 Jerde Glens,West Gwen,Massachusetts,38804,605-352-1078,$3961.40");
        assertEquals("Massachusetts",balanceRecord.getState());
    }
    @Test
    void balanceRecordGetBalance(){
        BalanceRecord balanceRecord = new BalanceRecord("Katharine,Kshlerin,0369 Jerde Glens,West Gwen,Massachusetts,38804,605-352-1078,$3961.40");
        assertEquals((float)3961.4,balanceRecord.getBalance());
    }
}