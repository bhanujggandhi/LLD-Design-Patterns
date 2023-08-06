package Decorator;

public class Decaf extends Beverage{
    public Decaf() {
        discription = "Drastic Decaf";
    }

    @Override
    public double cost() {
        return 1.05;
    }
}
