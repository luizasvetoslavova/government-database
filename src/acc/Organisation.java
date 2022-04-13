package acc;

import java.util.List;

public class Organisation extends Account {
    List<User> users;

    public Organisation(String username, String password) {
        super(username, password);
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
