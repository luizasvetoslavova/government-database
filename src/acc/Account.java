package acc;

public abstract class Account {
    private String email;
    private String password;

    public Account(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Account{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
