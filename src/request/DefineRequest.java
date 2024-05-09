package request;

import java.util.List;

public class DefineRequest extends Request {
    public DefineRequest(String action, List<String> params, String keyword) {
        super(action, params, keyword);
    }

    public DefineRequest(String[] parts) {
        super(parts);
    }

    @Override
    public void processRequest() {
        System.out.println(this.getAction() + this.getKeyword());
    }

    @Override
    public boolean isValid() {
        return this.getAction() != null && !this.getParams().isEmpty() && this.getKeyword() != null;
    }
}
