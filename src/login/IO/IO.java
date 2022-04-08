package login.IO;

import accounts.Organisation;
import accounts.bases.User;

public interface IO {
    void initAdminOperations();
    void initOrganisationOperations(Organisation organisation);
    void initUserOperations(User user);
}
