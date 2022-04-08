package fileOperators;

import accounts.bases.Record;

import java.io.*;

public class FileEditor implements FileEditing {

    private static FileEditor instance;

    public static FileEditor getInstance() {
        if (instance == null) {
            instance = new FileEditor();
        }
        return instance;
    }

    private FileEditor() {

    }

    @Override
    public void inputData(String file, Record object) {
        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(file, true));
            os.writeObject(object);
            os.write("\n".getBytes());
            os.flush();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}