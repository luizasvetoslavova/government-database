package database.operations;

import java.io.IOException;

public interface FileEditing {
    void inputData(String input) throws IOException;
    void redactData();

}
