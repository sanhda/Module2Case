package request;

import java.util.ArrayList;
import java.util.List;

public abstract class  Request {
    private String action;
    private List<String> params;
    private String keyword;

    public Request(String action, List<String> params, String keyword) {
        this.action = action;
        this.params = params;
        this.keyword = keyword;
    }

    public Request(String[] parts) {
        if (parts.length >= 2) {
            this.action = parts[0];
            this.keyword = parts[parts.length-1];
        }

        if (parts.length == 3) {
            this.params = new ArrayList<>();
            this.params.add(parts[1]);
        }
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public abstract void processRequest();
    public abstract boolean isValid();
}
