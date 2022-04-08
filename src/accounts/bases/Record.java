package accounts.bases;

public abstract class Record {

    private final String id;

    public Record(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
