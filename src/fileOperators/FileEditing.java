package fileOperators;

import accounts.bases.Record;

public interface FileEditing<T extends Record> {
    void inputData(String file, T object);
}
