package request;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DefineRequest extends Request {
    public DefineRequest(String action, List<String> params, String keyword) {
        super(action, params, keyword);
    }

    public DefineRequest(String[] parts) {
        super(parts);
    }

    @Override
    public void processRequest() {
        List<String> newParams = new ArrayList<>(this.getParams());
        Scanner scanner = new Scanner(System.in);

        // add definition
        System.out.print("Definition:");
        newParams.add(scanner.nextLine());

        // add sentence
        System.out.print("Sentence:");
        newParams.add(scanner.nextLine());

        // add sentence meaning
        System.out.print("Sentence meaning:");
        newParams.add(scanner.nextLine());

        // write
        DictionaryFileManager fileManager = DictionaryFileManager.getInstance();
        fileManager.writeNewDefinition(this.getKeyword(), newParams);
    }

    @Override
    public boolean isValid() {
        return this.getAction() != null && this.getParams() != null && !this.getParams().isEmpty() && this.getKeyword() != null;
    }
}
