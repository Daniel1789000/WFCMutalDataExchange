import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SummaryTableTest {

    @Test
    void constructorTest(){
        assertThrows(IllegalArgumentException.class,()-> new SummaryTable(null));
        assertThrows(IllegalArgumentException.class,()-> new SummaryTable(""));
    }

    @Test
    /*
    this test will create a file on the hard disk. Don't run during build.
     */
    void writeHeader() throws Exception {
        try (SummaryTable summaryTable = new SummaryTable("tempfile")) {
           summaryTable.writeHeader("");
        }
        File tempFile = new File("tempfile");
        if(tempFile.exists()){
            if(!tempFile.delete()){
                throw new IOException("failed to delete temp file during testing");
            }
        }
        else{
            throw new IOException("failed to create temp file for testing");
        }
    }

    @Test
    void writeRecord() throws Exception {
        try (SummaryTable summaryTable = new SummaryTable("tempfile")) {
            summaryTable.writeRecord("");
        }
        File tempFile = new File("tempfile");
        if(tempFile.exists()){
            if(!tempFile.delete()){
                throw new IOException("failed to delete temp file during testing");
            }
        }
        else{
            throw new IOException("failed to create temp file for testing");
        }
    }

    @Test
    void close() {
    }
}