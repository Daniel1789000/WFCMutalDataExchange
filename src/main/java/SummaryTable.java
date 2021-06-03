import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SummaryTable implements java.lang.AutoCloseable{
    File summaryFile;
    FileWriter fileWriter;
    SummaryTable(String fileName) throws IOException {
        File summaryTableFile = new File(fileName);
        if(summaryTableFile.exists()){
            if(!summaryTableFile.delete()){
                throw new IOException("existing file could not be deleted");
            }
        }
        summaryFile = new File(fileName);
        fileWriter = new FileWriter(summaryFile.getAbsolutePath());
    }
    public void writeHeader(String header) throws IOException {
        writeString(header);
    }
    public void writeRecord(String record) throws IOException {
        writeString(record);
    }
    private void writeString(String value) throws IOException {
        if(fileWriter != null) {
            fileWriter.write(value);
        }else{
            throw new IOException("The Summary file is not open");
        }
    }

    @Override
    public void close() throws Exception {
        if(fileWriter != null){
            fileWriter.close();
        }
    }
}
