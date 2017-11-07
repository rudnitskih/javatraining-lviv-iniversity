package lab;

import lombok.SneakyThrows;


public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        HttpService httpService = new HttpService();

        while (true) {
            httpService.handleHttpCode((int) (Math.random() * 700));
            Thread.sleep(1000);
        }
    }
}
