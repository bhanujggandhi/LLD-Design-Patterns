package Strategy.Classes.Fly;

import Strategy.Interfaces.FlyBehavior;

public class FlyWithWings implements FlyBehavior {
    public FlyWithWings() {
    }

    public void fly() {
        System.out.println("I can fly with wings!");
    }
}
