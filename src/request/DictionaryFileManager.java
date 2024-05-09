package request;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DictionaryFileManager {
    private static final DictionaryFileManager INSTANCE = new DictionaryFileManager();
    private static final String folderPath = "Data";
    private static final String symbol = "/";

    private DictionaryFileManager() {}

    public static DictionaryFileManager getInstance() {
        return INSTANCE;
    }

    public void writeNewDefinition(String fileName, List<String> contents) {
        try (BufferedWriter writer = new BufferedWriter(
                new FileWriter(folderPath + "/" + fileName + ".def", true))) {
            writer.newLine();
            writer.write(String.join(symbol, contents));
            System.out.println("Đã thêm từ " + fileName);
        } catch (Exception e) {
            System.out.println("Không thể thêm nghĩa mới: " + e.getMessage());
        }
    }

    public void dropFile(String fileName) {
        try {
            Files.delete(Paths.get(folderPath + "/" + fileName + ".def"));
            System.out.println("Đã xóa từ " + fileName);

        } catch (IOException e) {
            System.err.println("Từ cần tra chưa được định nghĩa. Dùng define để định nghĩa từ");
        }
    }

    public void showWord(String fileName) {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(folderPath + "/" + fileName + ".def"))) {
            String line;

            System.out.println("Các nghĩa của từ: " + fileName);
            while ((line = reader.readLine()) != null) {
                this.showMeaning(line);
            }
            System.out.println();

        } catch (IOException e) {
            System.err.println("Từ cần tra chưa được định nghĩa. Dùng define để định nghĩa từ");
        }
    }

    private void showMeaning(String data) {
        String[] parts = data.split(symbol);

        if (parts.length >= 4) {

            // definition
            System.out.println();
            System.out.println("--------------------");
            System.out.printf("Nghĩa: %s (%s)", parts[1], parts[0]);

            // sentence
            System.out.println();
            System.out.printf("Ví dụ: %s (%s)", parts[2], parts[3]);

        }
    }
}
