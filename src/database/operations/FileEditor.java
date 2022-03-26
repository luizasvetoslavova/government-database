package database.operations;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

public class FileEditor implements FileEditing{

    @Override
    public void inputData(String input) throws IOException {
        OutputStream os = new FileOutputStream(String.valueOf(Path.of("src","database","government","Citizens.csv")),true);
        //TODO move input to a new line
        os.write(input.getBytes());
        os.flush();
        os.close();
    }

    @Override
    public void redactData() {

    }
}
