package accounts.users.police;

import accounts.bases.User;
import citizenData.lists.UserPrivacyStatus;

public class Police extends User {
    private static Police instance;

    public static Police getInstance() {
        if (instance == null) {
            instance = new Police("police@gmail.com", "police1234");
        }
        return instance;
    }

    private Police(String email, String password) {
        super(email, password);
        this.setPrivacyStatus(UserPrivacyStatus.STATE_OWNED);
    }
}