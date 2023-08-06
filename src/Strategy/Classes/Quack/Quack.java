package Strategy.Classes.Quack;

import Strategy.Interfaces.QuackBehavior;

public class Quack implements QuackBehavior {
    public Quack() {
    }

    public void quack() {
        System.out.println("See I am quacking!!");
    }
}
