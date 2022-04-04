package database.operations;

public class FileExtractor implements FileExtraction {

//    @Override
//    public String extractWholeData(Path path) {
//        StringBuilder data = new StringBuilder();
//
//        try {
//            Reader reader = new FileReader(path.toFile());
//            int character = 0;
//            do {
//                try {
//                    character = reader.read();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//                data.append((char) character);
//            } while (character != -1);
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//        return data.toString();
//    }

    @Override
    public String extractBankCitizenData() {
        return null;
        //TODO
    }

    @Override
    public String extractPoliceCitizenData() {
        return null;
        //TODO
    }
}
