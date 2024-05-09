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
        System.out.println(this.getAction() + this.getKeyword());
    }

    @Override
    public boolean isValid() {
        return this.getAction() != null && this.getKeyword() != null;
    }
}
