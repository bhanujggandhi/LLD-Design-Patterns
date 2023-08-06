package Strategy.Classes.Duck;

import Strategy.Classes.Fly.FlyWithWings;
import Strategy.Classes.Quack.Quack;

public class MallardDuck extends Duck {
    public MallardDuck() {
        this.flyBehavior = new FlyWithWings();
        this.quackBehavior = new Quack();
    }
}
