package Strategy.Classes.Quack;

import Strategy.Interfaces.QuackBehavior;

public class MuteQuack implements QuackBehavior {
    public MuteQuack() {
    }

    public void quack() {
        System.out.println("I cannot quack! Shhh");
    }
}