package accounts;

import accounts.bases.Account;
import accounts.bases.User;

import java.util.List;

public class Organisation extends Account {
    List<User> users;

    public Organisation(String email, String password) {
        super(email, password);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "Organisation{" +
                "users=" + users +
                '}';
    }
}
