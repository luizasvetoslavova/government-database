package login.authentication;

public class Authenticator implements Authentication {
    @Override
    public boolean emailExists() {
        return false;
    }

    @Override
    public boolean isPasswordCorrect() {
        return false;
    }
}
