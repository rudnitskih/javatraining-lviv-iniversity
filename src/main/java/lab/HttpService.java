package lab;

public class HttpService {
    public void handleHttpCode(int code) {
        System.out.println("\nCode: " + code);
        try {
            HttpStatus httpStatus = HttpStatus.findByHttpCode(code);
            httpStatus.getHandler().process();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
