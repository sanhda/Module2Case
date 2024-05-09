package request;

import java.util.List;

public class DropRequest extends Request {
    public DropRequest(String action, List<String> params, String keyword) {
        super(action, params, keyword);
    }

    public DropRequest(String[] parts) {
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
