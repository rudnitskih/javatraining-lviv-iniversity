package lab.handlers;

import lab.HttpHandler;

public class RedirectionHandler implements HttpHandler {
    @Override
    public void process() {
        System.out.println("process REDIRECTION status...");
    }
}
