package fileOperations;

import accounts.bases.Record;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class FileEditor implements FileEditing {

    private static final FileEditor instance = new FileEditor();

    public static FileEditor getInstance() {
        return instance;
    }

    private FileEditor() {

    }

    @Override
    public void inputObject(String file, Record object) {
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file, true))) {
            os.writeObject(object);
            os.write("\r\n\r\n\r\n".getBytes());
            os.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}