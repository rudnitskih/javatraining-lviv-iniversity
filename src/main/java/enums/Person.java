package enums;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
    private String name;
    private MaritalStatus maritalStatus;

    @Override
    public String toString() {
       return name + ", " + maritalStatus.getRussianDesc();
    }
}
