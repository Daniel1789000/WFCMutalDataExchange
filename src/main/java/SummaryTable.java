import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SummaryTable implements java.lang.AutoCloseable{
    File summaryFile;
    FileWriter fileWriter;
    SummaryTable(String fileName) throws IOException {
        if(fileName != null && !fileName.isEmpty()) {
            summaryFile = new File(fileName);
            if (summaryFile.exists()) {
                if (!summaryFile.delete()) {
                    throw new IOException("existing file could not be deleted");
                }
            }
            fileWriter = new FileWriter(summaryFile.getAbsolutePath());
        }else{
            throw new IllegalArgumentException("file name not provided");
        }
    }
    public void writeHeader(String header) throws IOException {
        if(header != null) {
            writeString(header);
        }else{
            throw new IllegalArgumentException();
        }
    }
    public void writeRecord(String record) throws IOException {
        if(record != null) {
            writeString(record);
        }else{
            throw new IllegalArgumentException();
        }
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
