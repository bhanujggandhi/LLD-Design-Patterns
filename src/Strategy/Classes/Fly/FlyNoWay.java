package Strategy.Classes.Fly;

import Strategy.Interfaces.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
    public FlyNoWay() {
    }

    public void fly() {
        System.out.println("I cannot fly!!");
    }
}
