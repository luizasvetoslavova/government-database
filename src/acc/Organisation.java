package acc;

import java.util.List;

public class Organisation extends Account {

    List <User> users;

    public Organisation(String username, String password) {
        super(username, password);
    }

    public void addUser(User user){
        users.add(user);
    }
}
