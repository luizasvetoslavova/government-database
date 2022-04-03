package database.operations;

import java.io.IOException;
import java.nio.file.Path;

public interface FileEditing {
    void inputData(Path path, String input);
    void redactData();

}
