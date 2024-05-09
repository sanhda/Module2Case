import request.FactoryRequest;
import request.Request;

import java.util.Scanner;

public class Controller {

    public static boolean start() {
        System.out.print("Enter action (lookup, define, drop, export, quit): ");
        Scanner scanner = new Scanner(System.in);
        String action = scanner.nextLine();

        // quit if user use action quit
        if (action.split(" ")[0].equals("quit")) {
            return false;
        }

        // process request
        processRequest(action);
        return true;
    }

    public static void processRequest(String action) {

        // using factory pattern to get request subclass
        Request request = FactoryRequest.getRequest(action);
        if (request==null || !request.isValid()) {
            System.out.println("Action không hợp lệ");
            return;
        }

        // call abstract method
        request.processRequest();
    }
}
