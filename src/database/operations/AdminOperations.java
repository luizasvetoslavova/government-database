package database.operations;

import acc.Organisation;

public interface AdminOperations {
    void inputData();
    void redactData();
    void getFullDatabase();
    Organisation addOrganisation();
}
