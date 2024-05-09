package request;

import java.util.List;

public class ExportRequest extends Request {
    public ExportRequest(String action, List<String> params, String keyword) {
        super(action, params, keyword);
    }

    public ExportRequest(String[] parts) {
        super(parts);
    }

    @Override
    public void processRequest() {
        System.out.println(this.getAction() + this.getKeyword());
    }

    @Override
    public boolean isValid() {
        return this.getAction() != null && this.getKeyword() != null;
    }
}
