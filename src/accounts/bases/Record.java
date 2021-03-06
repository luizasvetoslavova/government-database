package accounts.bases;

import java.io.Serializable;

public abstract class Record implements Serializable {

    private final String id;

    public Record(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
