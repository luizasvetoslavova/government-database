package fileOperations;

import accounts.bases.Record;

public interface FileEditing<T extends Record> {
    void inputObject(String file, T object);
}
