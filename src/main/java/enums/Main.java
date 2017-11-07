package enums;

import lombok.SneakyThrows;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        PersonReader personReader = new PersonReader();
        Person previousPerson = null;

        while (true) {
            Person person = personReader.read();

            if (person.equals(previousPerson)) {
                System.out.println("You again???");
            } else {
                previousPerson = person;
            }

            Thread.sleep(1000);
        }
    }
}
