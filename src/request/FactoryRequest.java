package request;

import request.DefineRequest;
import request.DropRequest;
import request.ExportRequest;
import request.LookupRequest;

public class FactoryRequest {

    public FactoryRequest() {
    }

    public static Request getRequest(String action) {
        String[] parts = action.split(" ");

        if (parts.length==0) {
            return null;
        }

        switch (parts[0]) {
            case "lookup":
                return new LookupRequest(parts);

            case "define":
                return new DefineRequest(parts);

            case "drop":
                return new DropRequest(parts);

            case "export":
                return new ExportRequest(parts);

            default:
                return null;
        }
    }
}
