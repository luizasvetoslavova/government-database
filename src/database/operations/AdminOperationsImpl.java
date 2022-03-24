package database.operations;

import acc.Organisation;

import java.util.Scanner;

public class AdminOperationsImpl implements AdminOperations{

    @Override
    public void inputData() {

    }

    @Override
    public void redactData() {

    }

    @Override
    public void getFullDatabase() {

    }

    @Override
    public Organisation addOrganisation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input username: ");
        String username = scanner.nextLine();
        System.out.print("Input password: ");
        String password = scanner.nextLine();

        return new Organisation(username,password);
    }
}
