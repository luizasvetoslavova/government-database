package login.authentication;

public interface Authentication {
    boolean isEmailLegal();
    boolean isPasswordCorrect();
    String repeatIncorrectPassword();
    String repeatIncorrectEmail();
}
