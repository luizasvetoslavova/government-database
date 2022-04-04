package database.operations;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Path;

public class FileEditor implements FileEditing {

    @Override
    public void inputData(Path path, String input) {
        try {
            OutputStream os = new FileOutputStream(path.toFile(), true);
            os.write(input.getBytes());
            os.write("\n".getBytes());
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void bankEditCitizenData() {

    }

    @Override
    public void policeEditCitizenData() {

    }
}
