import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class SummaryRecordTest {

    @Test
    void setBalance() {
        SummaryRecord record = new SummaryRecord("Utah",(float)0.0);
        record.setBalance((float)1.0);
        Vector<String> values = record.getValues();
        assertEquals("Utah",values.get(0));
        assertEquals("0.0",values.get(1));
        assertEquals("1.0",values.get(2));
        assertEquals("0.5",values.get(3));
        assertEquals("1.0",values.get(4));
        record.setBalance((float)2.0);
        values = record.getValues();
        assertEquals("Utah",values.get(0));
        assertEquals("0.0",values.get(1));
        assertEquals("2.0",values.get(2));
        assertEquals("1.0",values.get(3));
        assertEquals("3.0",values.get(4));
    }

    @Test
    void getColumnNames() {
        Vector<String> columnNames = SummaryRecord.getColumnNames();
        assertEquals("STATE",columnNames.get(0));
        assertEquals("MIN_BALANCE",columnNames.get(1));
        assertEquals("MAX_BALANCE",columnNames.get(2));
        assertEquals("MEAN_BALANCE",columnNames.get(3));
        assertEquals("TOTAL_BALANCE",columnNames.get(4));
    }

    @Test
    void getValues() {
        SummaryRecord record = new SummaryRecord("Utah",(float)0.0);
        Vector<String> values = record.getValues();
        assertEquals("Utah",values.get(0));
        assertEquals("0.0",values.get(1));
        assertEquals("0.0",values.get(2));
        assertEquals("0.0",values.get(3));
        assertEquals("0.0",values.get(4));

    }
}