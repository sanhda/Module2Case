package request;

import java.util.List;

public class LookupRequest extends Request {

    public LookupRequest(String action, List<String> params, String keyword) {
        super(action, params, keyword);
    }

    public LookupRequest(String[] parts) {
        super(parts);
    }

    @Override
    public void processRequest() {
        DictionaryFileManager fileManager = DictionaryFileManager.getInstance();
        fileManager.showWord(this.getKeyword());
    }

    @Override
    public boolean isValid() {
        return this.getAction() != null && this.getKeyword() != null;
    }
}
