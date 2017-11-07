package lab.handlers;

import lab.HttpHandler;

public class ServerErrorHandler implements HttpHandler {
    @Override
    public void process() {
        // 59 lines of code

        System.out.println("process SERVER error status...");
    }
}
