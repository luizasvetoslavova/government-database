package login.authentication;

public interface Authentication {
<<<<<<< HEAD
    boolean emailExists();
    boolean isPasswordCorrect();
}
=======
    String checkEmail(String email);
    String checkPassword(String email, String password);
}
>>>>>>> login
