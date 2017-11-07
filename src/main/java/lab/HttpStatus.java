package lab;

import lab.handlers.*;
import lombok.Getter;
import lombok.SneakyThrows;

@Getter
public enum HttpStatus {
    INFO(100, 199, InformHandler.class),
    SUCCESS(200, 299, SuccessHandler.class),
    REDIRECTION(300, 399, RedirectionHandler.class),
    CLIENT_ERROR(400, 499, ClientErrorHandler.class),
    SERVER_ERROR(500, 599, ServerErrorHandler.class);

    private final int minCode;
    private final int maxCode;
    private final HttpHandler handler;

    @SneakyThrows
    HttpStatus(int minCode, int maxCode, Class handlerClass) {
        this.minCode = minCode;
        this.maxCode = maxCode;

        if (HttpHandler.class.isAssignableFrom(handlerClass)) {
            this.handler = (HttpHandler) handlerClass.newInstance();
        } else {
            throw new RuntimeException("You need to provide class which implement HttpHandler interface.");
        }
    }

    public static HttpStatus findByHttpCode(int code) {
        HttpStatus[] statusTypes = values();

        for (HttpStatus statusType : statusTypes) {
            if (statusType.minCode < code && statusType.maxCode > code) {
                return statusType;
            }
        }

        throw new RuntimeException(code + " not supported");
    }
}
