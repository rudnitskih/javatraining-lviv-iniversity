package lab.handlers;

import lab.HttpHandler;

public class ClientErrorHandler implements HttpHandler {
    @Override
    public void process() {
        System.out.println("process CLIENT error status...");
    }
}
