package Decorator;

public abstract class Beverage {
    String discription = "Unknown beverage";

    public String getDiscription() {
        return discription;
    }

    public abstract double cost();
}
