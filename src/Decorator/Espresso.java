package Decorator;

public class Espresso extends Beverage{
    public Espresso() {
        discription = "Delicious Espresso";
    }

    @Override
    public double cost() {
        return 1.99;
    }
}
