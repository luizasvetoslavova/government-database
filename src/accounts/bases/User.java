package accounts.bases;

import citizenData.lists.UserPrivacyStatus;

public abstract class User extends Account {
    private UserPrivacyStatus privacyStatus;

    public User(String email, String password) {
        super(email, password);
        privacyStatus = UserPrivacyStatus.STATE_OWNED;
    }

    public void setPrivacyStatus(UserPrivacyStatus privacyStatus) {
        this.privacyStatus = privacyStatus;
    }

    public UserPrivacyStatus getPrivacyStatus() {
        return privacyStatus;
    }
}
