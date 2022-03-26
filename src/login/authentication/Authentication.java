package login.authentication;

public interface Authentication {
    boolean isEmailLegal(String email);
    boolean isPasswordCorrect(String email, String password);
}
