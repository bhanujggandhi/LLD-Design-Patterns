package Strategy.Classes.Quack;

import Strategy.Interfaces.QuackBehavior;

public class Squeak implements QuackBehavior {
    public Squeak() {
    }

    public void quack() {
        System.out.println("I am squeaking!!!");
    }
}
