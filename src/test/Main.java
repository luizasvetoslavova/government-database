package test;

import login.LoginManager;

public class Main {
    /* README: database text files' readability is significantly dependent on your personal IDE settings and stated
    encoding preferences. Please, check them out to prevent occurring errors and run-time exceptions. */

    /* README: In order .database files to be initialized, DefaultInsertion main class is supposed to be run, BUT just
    once. After that, you could run the standard Main class as many times as you need to. The distinction is made to
    prevent duplication and overflow. */

    public static void main(String[] args) {
        LoginManager.getInstance().startLoginProcess();
    }
}
