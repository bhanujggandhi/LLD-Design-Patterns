package Decorator;

public class Mocha extends CondimentDecorator{
    public Mocha(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDiscription() {
        return this.beverage.discription + ", yummy mocha";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.20;
    }
}
