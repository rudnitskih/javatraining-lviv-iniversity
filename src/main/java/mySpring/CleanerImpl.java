package mySpring;

import mySpring.annotations.InjectRandomInt;
import mySpring.annotations.MultiplyByValue;

public class CleanerImpl implements Cleaner {
    @InjectRandomInt(min = 3, max = 7)
    @MultiplyByValue(10)
    private int repeat;

    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("VVVVVVVvvvvvvvvvvvvvvvvv");
        }
    }
}
