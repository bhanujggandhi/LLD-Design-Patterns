package Decorator;

public class DarkRoast extends Beverage{
    public DarkRoast() {
        discription = "Delicious Dark Roast";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
