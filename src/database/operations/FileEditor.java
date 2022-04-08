package database.operations;

import citizenData.Citizen;

import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;

public class FileEditor implements FileEditing {

    private static FileEditor instance;

    private Path citizens;

    public static FileEditor getInstance() {
        if (instance == null) {
            instance = new FileEditor();
        }
        return instance;
    }

    private FileEditor() {
        citizens = Path.of("src", "database", "government", "Citizens.psv");
    }

    @Override
    public void inputData(Path path, String input) {
        try {
            OutputStream os = new FileOutputStream(path.toFile(), true);
            os.write(input.getBytes());
            os.write("\n".getBytes());
            os.flush();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void replaceData(Path path, String input) {
        try {
            OutputStream os = new FileOutputStream(path.toFile());
            os.write(input.getBytes());
            os.write("\n".getBytes());
            os.flush();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void editCitizenData(Citizen citizen) {
        try {
            OutputStream os = new FileOutputStream(citizens.toFile());
            String[] citizenDataLines = citizens.toFile().toString().split("\r\n");

            for (int i = 0; i < citizenDataLines.length; i++) {
                if (citizenDataLines[i].equals
                        ("Citizen{name='" + citizen.getName() +
                                "'|id='" + citizen.getId() +
                                "'|address='" + citizen.getAddress() +
                                "'|gender=" + citizen.getGender() +
                                "|crimes=" + citizen.getCrimes() +
                                "|possessions=" + citizen.getPossessions() +
                                "|crossingBorders=" + citizen.getCrossingBorders() +
                                "|credits=" + citizen.getCredits() +
                                "|relatives=" + citizen.getRelatives() +
                                "|companies=" + citizen.getCompanies() +
                                "}")) {

                    citizenDataLines[i] = citizen.toString();
                }
                os.write(citizenDataLines[i].getBytes());
                os.write("\n".getBytes());
            }
            os.flush();
            os.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}