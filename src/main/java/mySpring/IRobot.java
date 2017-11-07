package mySpring;


import lombok.Getter;
import mySpring.annotations.InjectRandomInt;
import mySpring.annotations.MultiplyByValue;

public class IRobot {

    private Speaker speaker = ObjectFactory.getInstance().createObject(Speaker.class);
    private Cleaner cleaner = ObjectFactory.getInstance().createObject(Cleaner.class);

    @InjectRandomInt(min = 3, max = 5)
    @MultiplyByValue(3)
    @Getter
    private int version;

    public void cleanRoom() {
        speaker.speak("I started my work");
        cleaner.clean();
        speaker.speak("I finished my work");
    }
}
