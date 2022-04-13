package login.authentication;

public interface Authentication {
    String checkEmail(String email);

    String checkPassword(String email, String password);
}

