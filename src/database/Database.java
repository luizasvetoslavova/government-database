package database;

import accounts.bases.Record;
import fileOperations.FileEditor;

import java.util.Set;

public abstract class Database<T extends Record> {

    public abstract String getFileName();

    public abstract Set<T> getDatabase();

    public void add(T object) {
        getDatabase().add(object);
        FileEditor.getInstance().inputData(getFileName(), object);
    }

    public T findBy(String id) {
        return getDatabase()
                .stream()
                .filter(object -> object.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
